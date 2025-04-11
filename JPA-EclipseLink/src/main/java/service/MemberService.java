package service;

import java.util.List;

import dao.MemberDao;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import model.Member;

@ApplicationScoped
public class MemberService {
	@EJB
	MemberDao dao;
	
	public void addMember(String name, char gender, String address, String phone) {		
		Member member = new Member();
		member.setName(name);
		member.setSex(gender);
		member.setAddress(address);
		member.setPhone(phone);
		dao.add(member);
	}
	
	public List<?> showMember() {	
		
		return dao.getAllStudents();			
	}
	
}
