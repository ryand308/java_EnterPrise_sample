package login.repository;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import login.model.entity.JavaRole;
import login.model.entity.RoleId;

/**
 * Session Bean implementation class JavaUserRepository
 */
@Stateless
@LocalBean
public class JavaRoleRepository {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager em;
	
    public JavaRoleRepository() {
        // TODO Auto-generated constructor stub
    }

    public void add(JavaRole javaRole) {
    	if(javaRole != null)
    		em.persist(javaRole);
    }
    
    public JavaRole update(JavaRole javaRole) {
    	return em.merge(javaRole);
    }
    
    public void delete(JavaRole javaRole) {
    	if(javaRole != null)
    		em.remove(javaRole);
    	
    }
    
    public JavaRole findById(RoleId roleId) {   
    	// 獨佔鎖 可讀不可改
    	return em.find(JavaRole.class, roleId, LockModeType.PESSIMISTIC_READ);
    }
    
    public List<JavaRole> findUser() {
    	
    	TypedQuery<JavaRole> query = em.createQuery("SELECT j FROM JavaRole j where j.roleName = \'USER\'", JavaRole.class);
    	
    	List<JavaRole> list = query.getResultList();
    	return list;
    }
    
}
