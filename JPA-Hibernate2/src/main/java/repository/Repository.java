package repository;

import java.util.List;

public interface Repository<T, ID> {

	T add(T t);
	T update(T t);
	void delete(ID id);
	T findById(ID id);
	List<T> find();
}
