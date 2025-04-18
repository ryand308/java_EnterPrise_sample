package dao;

import java.util.List;

import javax.sql.DataSource;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface MemberDao {

	void add(Member member);
	void update(Member member);
	void delete(int id);
	
	Member findById(int id);
	List<Member> getAllStudents();
	//test DataSource Object
	DataSource getDs();
}
