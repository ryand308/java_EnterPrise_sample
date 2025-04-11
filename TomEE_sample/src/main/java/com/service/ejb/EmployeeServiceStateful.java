package com.service.ejb;

import java.util.List;

import javax.sql.DataSource;

import com.dao.EmployeeLuv2Dao;
import com.dao.impl.EmployeeLuv2DaoImpl;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@Stateful
@LocalBean
public class EmployeeServiceStateful {
	// Instance<> 延遲實體化(@Lazy)
	@Inject
	private Instance<EmployeeLuv2DaoImpl> daoInstance;

	private EmployeeLuv2Dao eDao;
	private DataSource ds;

	// setter
	public void setDs(DataSource ds) {
//    	this.eDao = new EmployeeLuv2DaoImpl(ds); // 手動建立 DAO 實例；避免單一物件重複使用，資源相互汙染
		this.ds = ds;
	}

	// ? 通配符
	public List<?> getFindAll() {
		// 呼叫方法在取得 物件
		eDao = daoInstance.get(); // 取代 new EmployeeLuv2DaoImpl(); 由容器控制；得到 DataSource 在實體化
		((EmployeeLuv2DaoImpl) eDao).setDs(ds); // has-a

		var lists = eDao.getAllEmployeeLuv2();
		/*
		for (EmployeeLuv2 list : lists) {
			System.out.printf("%3d %8s %8s %25s %15s %10d %n", list.getId(), list.getLastName(), list.getFirstName(),
					list.getEmail(), list.getDepartments(), list.getSalary());
		}*/
		System.out.println("show EmployeeLuv2 table list.");
		return lists;
	}
	

}
