package com.su90.AprioriAlg.base;

import java.util.List;

public interface BaseDao <T> {
	public List<T> findEntry();
	public void saveEntry(T t);
	public void updateEntry(T t);
	public void deleteEntriesByIDS(Integer[] ids);
	public void deleteEntry(Integer id);
	public T getEntryById(Integer id);
	public List<T> getEntriesByIds(Integer[] ids);
	public int Count();
}
