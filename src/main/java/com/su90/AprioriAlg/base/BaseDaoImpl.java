package com.su90.AprioriAlg.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDaoImpl <T> extends SqlSessionDaoSupport implements BaseDao<T> {
	
	private final Class classt;
	private final String mappername;
	private final Class classm;
	
	
	public BaseDaoImpl() throws ClassNotFoundException{
            	ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.classt = (Class)type.getActualTypeArguments()[0];
		mappername="com.su90.AprioriAlg.mapper."+classt.getSimpleName()+"Mapper";
		classm = Class.forName(mappername);
	}	
	
        @Resource(name="sqlSessionFactory")@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);		
	}	

	public List<T> findEntry() {
		BaseMapper<T> mapper = (BaseMapper<T>) this.getSqlSession().getMapper(classm);
		return mapper.find(null);
	}

	public void saveEntry(T t) {
		BaseMapper<T> mapper = (BaseMapper<T>) this.getSqlSession().getMapper(classm);
		mapper.insert(t);		
	}

	public void updateEntry(T t) {
		BaseMapper<T> mapper = (BaseMapper<T>) this.getSqlSession().getMapper(classm);
		mapper.update(t);
	}

	public void deleteEntriesByIDS(Integer[] ids) {
		BaseMapper<T> mapper = (BaseMapper<T>) this.getSqlSession().getMapper(classm);
		mapper.deleteArray(ids);		
	}

	public void deleteEntry(Integer id) {
		Integer theid = id;
		Integer[] ids = new Integer[1];
		ids[0] = theid;		
		this.deleteEntriesByIDS(ids);
	}

	public T getEntryById(Integer id) {
		BaseMapper<T> mapper = (BaseMapper<T>) this.getSqlSession().getMapper(classm);
		return mapper.get(id);
	}

	public List<T> getEntriesByIds(Integer[] ids) {
		BaseMapper<T> mapper = (BaseMapper<T>) this.getSqlSession().getMapper(classm);
		return mapper.findin(ids);
	}

	public int Count() {
		BaseMapper<T> mapper = (BaseMapper<T>) this.getSqlSession().getMapper(classm);
		return mapper.count();
	}

}
