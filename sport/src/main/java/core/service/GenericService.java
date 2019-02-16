package core.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import core.repository.Expression;

public class GenericService<T extends Serializable> {
	public List<T> findAll(){
		return new ArrayList<T>();
	}
	public List<T> findByExpression(Expression e){
		return new ArrayList<T>();
	}
}
