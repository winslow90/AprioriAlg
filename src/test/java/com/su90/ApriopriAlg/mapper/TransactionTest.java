package com.su90.ApriopriAlg.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.su90.AprioriAlg.domain.Item;
import com.su90.AprioriAlg.domain.Transaction;
import com.su90.AprioriAlg.mapper.ItemMapper;
import com.su90.AprioriAlg.mapper.TransactionMapper;
import com.su90.AprioriAlg.utils.SpringUtil;

public class TransactionTest extends SpringUtil {
private SqlSessionFactory factory;	
	
	@Before
	public void init(){
		this.factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
	}
	
//	@Test
	public void testFindAll(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
				
		List<Transaction> transList = mapper.find(null);
		
		for (Transaction trans : transList){
			System.out.println(trans.toString());
			
		}		
		
	}
	
//	@Test
	public void testFindin(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		Integer[] ids = new Integer[]{1,3};
		
		List<Transaction> result = mapper.findin(ids);
		
		for (Transaction it : result){
			System.out.println(it.toString());
			
		}			
		
	}
	
//	@Test
	public void testGet(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		Transaction trans = mapper.get(2);		
		
		System.out.println(trans.toString());
	}
	
//	@Test
	public void testInsert(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
				
		Transaction trans = new Transaction();
		trans.setTdate(new Date());
		
		mapper.insert(trans);
		
//		session.commit();	
		
//		System.out.println("insert finished.");
	}
	
//	@Test
	public void testUpdate(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		Transaction trans = new Transaction();
		trans.setId(2);
		trans.setTdate(new Date());
		mapper.update(trans);		
	}
	
//	@Test
	public void testDeletebyId(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		mapper.deleteById(2);	
		
		
	}
	
//	@Test
	public void testDeleteArray(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		Integer[] ids = new Integer[]{4,5};
				
		mapper.deleteArray(ids);
	}
	
	
//	@Test
	public void testDeleteList(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		ArrayList<Integer> list  = new ArrayList<Integer>();
		
		list.add(8);
//		list.add(4);
		
		mapper.deleteList(list);
	}
	
//	@Test
	public void testDeleteMap(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		Integer[] idsi = new Integer[]{6,7};
		HashMap<String, Integer[]> ids = new HashMap<String, Integer[]>();		
		ids.put("ids", idsi);		
				
		mapper.deleteMap(ids);
	}
	
//	@Test
	public void testCount(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		Integer result = mapper.count();
		
		System.out.println(result);
		
	}
//	@Test
	public void testGetTransWithItems(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		Transaction trans = mapper.getTranswithItems(3);
		
		for (Item item : trans.getItems()){
			System.out.println(item);
			
		}
		
		System.out.println(trans);
	}
//	@Test
	public void testInsertTranswithaItem(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("tid", 3);
		map.put("iid", 9);
		
		mapper.insertTranswithaItem(map);	
		
		
		
	}
//	@Test
	public void testDeleteTranswithaItem(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("tid", 3);
		map.put("iid", 10);
		
		mapper.deleteTranswithaItem(map);	
	}
//	@Test
	public void testCountTranswithItemIds(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		ids.add(11);
		ids.add(9);
		
		Integer result = mapper.countTranswithItemIds(ids);
		
		System.out.println(result);
		
		
	}
//	@Test
	public void testCountTranswithItemNames(){
		SqlSession session = factory.openSession();
		TransactionMapper mapper = session.getMapper(TransactionMapper.class);
		
		ArrayList<String> names = new ArrayList<String>();
		
//		names.add("A");
		names.add("J");
		
		Integer result = mapper.countTranswithItemNames(names);
		
		System.out.println(result);
		
		
	}
}
