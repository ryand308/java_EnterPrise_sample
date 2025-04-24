package dao;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Member;

/**
 * Session Bean implementation class MemberDao
 */

@Dependent
public class MemberDaoImpl implements MemberDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("testLocalEclipseLink");
	private EntityManager em = emf.createEntityManager();

	private EntityTransaction et = em.getTransaction();

	public MemberDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Member member) {
		
		et.begin();		
		em.persist(member);
		et.commit();
		
	}

	@Override
	public void update(Member member) {

	}

	@Override
	public void delete(Member member) {

	}

	@Override
	public Member findById(int id) {

		return null;
	}

	@Override
	public List<Member> find() {

		Query query = em.createQuery("SELECT m FROM Member m");
		var list = query.getResultList();

		return list;
	}

	@Override
	public void close() {
		em.close();
		emf.close();
	}
}
