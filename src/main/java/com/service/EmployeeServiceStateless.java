package com.service;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.dao.EmployeeLuv2Dao;
import com.dao.impl.EmployeeLuv2DaoImpl;
import com.model.entity.EmployeeLuv2;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

/**
 * Session Bean implementation class EmployeeLuv2Service
*/
@Stateless
@LocalBean
public class EmployeeServiceStateless {
	private DataSource ds;
	@Inject
	private Instance<EmployeeLuv2DaoImpl> daoInstance;
	private EmployeeLuv2Dao eDao;
	
    public EmployeeServiceStateless() {
        // TODO Auto-generated constructor stub
    }

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public boolean addEmployee(String lName, String fName, String email, String department, String salary) {
		
		eDao = daoInstance.get();
		((EmployeeLuv2DaoImpl)eDao).setDs(ds); // has-a
		EmployeeLuv2 emp = ((EmployeeLuv2DaoImpl)eDao).getEmployeeLuv2(); // has-a
		System.out.println("emp object:" + emp.toString());
		
		// 只要其中一個沒寫就結束method
		String[] total = {lName, fName, email, department, salary};
		if(Stream.of(total).anyMatch(t -> t.trim().matches("")))
			return false;
		
		// 再帶入
		emp.setLastName(lName);
		emp.setFirstName(fName);
		emp.setEmail(email);
		emp.setDepartments(department);
		if(salary.matches("\\d*"))  //也有在 html 防呆；
			emp.setSalary(Integer.parseInt(salary)); //java.lang.NumberFormatException
		
		// test emp value 是否存在於物件
		((EmployeeLuv2DaoImpl)eDao).showEmployeeLuv2(emp); 
		//inject EmployeeLuv2
		eDao.add(emp);
		return true;
	}
	
	public void deleteEmployee(String delete) {
		// 宣告 declare
		int id = Integer.parseInt(delete);
		eDao = daoInstance.get();
		((EmployeeLuv2DaoImpl)eDao).setDs(ds);		
		
		eDao.delete(id);
		
	}
	
	public EmployeeLuv2 selectEmployee(String id) {
		
		eDao = daoInstance.get();
		((EmployeeLuv2DaoImpl)eDao).setDs(ds);
		// 將獲得 DataSource 物件傳到 Daoimpl
		int i = Integer.parseInt(id);
		EmployeeLuv2 emp = eDao.findById(i);		
		
//		eDao.update(emp) 原來數據需要被保留，因為不是所有都會被修改
		
		return emp;		
	}
	
	public void updateEmployee(String lName, String fName, String email, String department, String salary, String id) {
		
		eDao = daoInstance.get();
		((EmployeeLuv2DaoImpl)eDao).setDs(ds);
		
		EmployeeLuv2 emp = this.selectEmployee(id);
		
		// 參數存在就修改
		if(!lName.trim().matches(""))
			emp.setLastName(lName);
		
		if(!fName.trim().matches(""))
			emp.setFirstName(fName);
		
		if(!email.trim().matches(""))
			emp.setEmail(email);
		
		if(!department.trim().matches(""))
			emp.setDepartments(department);
		
		if(!salary.trim().matches("") && salary.matches("\\d+"))
			emp.setSalary(Integer.parseInt(salary));	
		
		
		((EmployeeLuv2DaoImpl)eDao).showEmployeeLuv2(emp);

		eDao.update(emp);
	}
	
}
