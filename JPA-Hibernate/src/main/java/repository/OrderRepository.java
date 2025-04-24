package repository;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.Employee;
import model.Order;

@Stateless
@LocalBean
public class OrderRepository implements Repository<Order, Long>{

	@PersistenceContext( unitName = "testHibernate")
	private EntityManager em;
	
	@Override
	public void add(Order order) {
		em.persist(order);
		
	}

	@Override
	public void update(Order order) {
		em.merge(order);		
	}

	@Override
	public void delete(Long id) {
		Order order = this.findById(id);
		if(order != null)
			em.remove(order);
		
	}

	@Override
	public Order findById(Long id) {
		Order order = em.find(Order.class, id);
		return order;
	}

	@Override
	public List<Order> find() {
		Query query = em.createNamedQuery("Order.findAll");
		var list = query.getResultList();
		return list;
	}


}
