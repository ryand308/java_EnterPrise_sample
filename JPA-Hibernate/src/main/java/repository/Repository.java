package repository;

import java.util.List;

public interface Repository<T, ID> {

	void add(T t);
	void update(T t);
	void delete(ID id);
	T findById(ID id);
	List<T> find();
}
