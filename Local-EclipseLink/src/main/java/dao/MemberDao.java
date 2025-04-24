package dao;

import java.util.List;

import model.Member;

public interface MemberDao {

	void add(Member member);
	void update(Member member);
	void delete(Member member);

	Member findById(int id);
	List<Member> find();

	void close();
}
