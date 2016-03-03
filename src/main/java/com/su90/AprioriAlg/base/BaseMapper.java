package com.su90.AprioriAlg.base;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
	public List<T> find(Map<String,Object> map);
	public List<T> findin(Integer[] ids);
	public T get(Integer id);
	public void insert(T t);
	public void update(T t);
	public void deleteById(Integer id);
	
	public void deleteArray(Integer[] ids);
	public void deleteList(List<Integer> ids);
	public void deleteMap(Map<String,Integer[]> ids);
	public Integer count();
}
