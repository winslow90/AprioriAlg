package com.su90.AprioriAlg.base;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	public abstract BaseDao<T> getBaseDao(); 

	public List<T> getEntries() {
		return this.getBaseDao().findEntry();
	}

	public List<T> getEntriesByIds(Integer[] ids) {
            if (ids.length>0) {
		return this.getBaseDao().getEntriesByIds(ids);
            }else{
                return new ArrayList<T>();
            }
	}

	public void saveEntry(T t) {
		this.getBaseDao().saveEntry(t);
		
	}

	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
		
	}

	public T getEntryById(Integer id) {
		return this.getBaseDao().getEntryById(id);
	}

	public void deleteEntriesByIds(Integer[] ids) {
            if (ids.length>0) this.getBaseDao().deleteEntriesByIDS(ids);
		
	}

	public void deleteEntryById(Integer id) {
		this.getBaseDao().deleteEntry(id);
		
	}

}
