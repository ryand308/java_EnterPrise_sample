package dao;

import java.util.List;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.Member;

@Stateless
@Local(MemberDao.class) //MeberDao 加@Local 也行 
public class MemberDaoImpl implements MemberDao {

    @PersistenceContext(unitName = "eclipseUnit")
	EntityManager em;
	
    public MemberDaoImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see MemberDao#update(Member)
     */
    public void update(Member member) {
        em.merge(member);
    }

	/**
     * @see MemberDao#delete(int)
     */
    public void delete(int id) {
    	
    	Member member = this.findById(id);
    	if(member != null)
    		em.remove(member);
    }

	/**
     * @see MemberDao#findById(int)
     */
    public Member findById(int id) {
        
    	Member member = em.find(Member.class, id);
    	
		return member;
    }

	/**
     * @see MemberDao#add(Member)
     */
    public void add(Member member) {        
        em.persist(member);        
    }

	/**
     * @see MemberDao#getAllStudents()
     */
    public List<Member> getAllStudents() {

    	Query query = em.createNamedQuery("Member.findAll", Member.class);
    	List<Member> list = query.getResultList();    	
			return list;
    }

}
