package com.service.ejb;

import java.util.List;
import java.util.stream.Stream;

import com.dao.StudentsDao;
import com.dao.impl.StudentJpaDaoImpl;
import com.model.entity.Students;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

/**
 * Session Bean implementation class StudentServiceStatefulJpa
 */
@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)  // 這裡改成 BMT，允許手動控制交易
public class StudentJpaServiceStateful{
	// 很像@Autowired；nuitName 是 persistence.xml 檔案裡的name；@PersistenceContext 只能作用在EJB
	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager em;
	
	@Resource  // 注入 UserTransaction；只出現手動環境下
    private UserTransaction ut;
	
	@Inject
	private Instance<StudentJpaDaoImpl> daoInstance;
	private StudentsDao sDao;
	
	// 沒有特別用途純粹測試手動；99%都使用CMT（容器管理交易）自動@Ttransactional。
	public void testBMT() {
		try {
            ut.begin();  // 手動開始交易
            // 放 em 的 CRUD方法
            System.out.println("Transaction手動控制沒問題！");
            ut.commit(); // 手動提交交易
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	
    public List<?> allStudent() {  	
    	sDao = daoInstance.get();    	   	
		
		try(Stream<Students> stream = em.createQuery("SELECT s FROM Students s", Students.class).getResultStream();
			Stream<Students> stream1 =stream.filter(club -> club.getClub() == 0).peek(stu -> System.out.println(stu.getName()));
				) {
			var list = stream1.toArray();
			System.out.println("找到未加入社團資料:");
			for(var l: list)
				System.out.println(l);			
		}
		
		return sDao.getAllStudents();
    }
    
}
