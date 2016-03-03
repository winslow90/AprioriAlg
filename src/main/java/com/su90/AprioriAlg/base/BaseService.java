package com.su90.AprioriAlg.base;

import java.util.List;

public interface BaseService <T>{
	public List<T> getEntries();
	public List<T> getEntriesByIds(Integer[] ids);
	public void saveEntry(T t);
	public void updateEntry(T t);
	public T getEntryById(Integer id);
	public void deleteEntriesByIds(Integer[] ids);
	public void deleteEntryById(Integer id);
        public Integer count();

}
