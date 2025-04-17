package dao;

import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import model.Member;

@Stateless
@Local(MemberDao.class) //MeberDao 加@Local 也行 
public class MemberDaoImpl implements MemberDao {
	@Resource
	private DataSource ds;
	
	@Override
	public DataSource getDs() {
		return this.ds;
	}
	
	//--------------JDBC---------------------------
	@Override
	public void add(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
