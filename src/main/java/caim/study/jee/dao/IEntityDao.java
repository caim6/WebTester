package caim.study.jee.dao;

import java.io.Serializable;
import java.util.List;


public interface IEntityDao<T> {

	void save(T e);
	
	void update(T e);
	
	void delete(T e);
	
	void remove(T e);

	T findById(Serializable id);
	
	List<T> findAll();
	
	void close();
}
