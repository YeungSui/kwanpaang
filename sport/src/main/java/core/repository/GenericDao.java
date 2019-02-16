package core.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericDao<T extends Serializable> {
	public List<T> findAll(){
		return new ArrayList<T>();
	}
	
	public List<T> findByExpression(Expression e){
		return new ArrayList<T>();
	}
}
