package service;

import dao.MemberDao;
import dao.MemberDaoImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import model.Member;

@ApplicationScoped
public class MemberService {

	@Inject
	private Instance<MemberDaoImpl> instance;
	private MemberDao dao;

	public void findMember() {

		dao = instance.get();
		var lists = dao.find();
		for(var list: lists) {
			System.out.println(list);
		}

	}

	public void addMember(String name, char gender, String address, String phone) {

		dao = instance.get();
		Member member = new Member();
		member.setName(name);
		member.setGender(gender);
		member.setAddress(address);
		member.setPhone(phone);

		dao.add(member);
		dao.close();
	}
}
