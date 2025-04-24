package repository;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.Employee;

/**
 * Session Bean implementation class EmployeeRepository
 */
@Stateless
@LocalBean
public class EmployeeRepository implements Repository<Employee, Long>{

	@PersistenceContext( unitName = "testHibernate")
	private EntityManager em;
	
    public EmployeeRepository() {
       
    }

	@Override
	public Employee add(Employee employee) {
		em.persist(employee);
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		em.merge(employee);
		return employee;
	}

	@Override
	public void delete(Long id) {
		Employee employee = this.findById(id);
		if(employee != null)
			em.remove(employee);
	}

	@Override
	public Employee findById(Long id) {
		Employee employee = em.find(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> find() {
		Query query = em.createNamedQuery("Employee.findAll");
		var list = query.getResultList();
		return list;
	}

}
