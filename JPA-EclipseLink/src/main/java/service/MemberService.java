package service;

import java.util.List;
import java.util.stream.Stream;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Member;
import repository.MemberRepository;

@ApplicationScoped
public class MemberService {
	@Inject
	private MemberRepository repository;
	
	public boolean addMember(String name, String sex, String address, String phone) {

		if(Stream.of(new String[]{name, address, phone}).anyMatch(data -> data.trim().matches("")))
			return false;
		
		// sex to char
		char gender = sex.charAt(0); 
		
		Member member = new Member();
		member.setName(name);
		member.setSex(gender);
		member.setAddress(address);
		member.setPhone(phone);
		repository.add(member);
		
		return true;
	}
	
	public List<?> showMember() {	
		
		return repository.getAllStudents();			
	}
	
	public void deleteMember(String delete) {
		
		int id = Integer.parseInt(delete);
		repository.delete(id);
	}
	
	public Member findMember(String number) {
		
		int id = Integer.parseInt(number);
		
		return repository.findById(id);
	}
	
	public void updateMember(String update, String name, String sex, String address, String phone) {
		
		int id = Integer.parseInt(update);		
		char gender = sex.charAt(0);
		
		Member member = this.findMember(update);
		member.setId(id);
		if(!name.trim().matches(""))
			member.setName(name);
		member.setSex(gender);
		if(!address.trim().matches(""))
			member.setAddress(address);
		if(!phone.trim().matches(""))
			member.setPhone(phone);
		
		repository.update(member);		
	}
}
