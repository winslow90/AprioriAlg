package com.su90.ApriopriAlg.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.su90.AprioriAlg.domain.Item;
import com.su90.AprioriAlg.mapper.ItemMapper;
import com.su90.AprioriAlg.utils.SpringUtil;

public class ItemTest extends SpringUtil {
	private SqlSessionFactory factory;	
	
	@Before
	public void init(){
		this.factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
	}
	
//	@Test
	public void testFindAll(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		List<Item> itemList = mapper.find(null);
		
		for (Item it : itemList){
			System.out.println(it.toString());
			
		}		
		
	}
	
//	@Test
	public void testFindin(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Integer[] ids = new Integer[]{1,8,9};
		
		List<Item> result = mapper.findin(ids);
		
		for (Item it : result){
			System.out.println(it.toString());
			
		}			
		
	}
	
//	@Test
	public void testGet(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Item it = mapper.get(2);
		
		System.out.println(it.toString());
	}
	
//	@Test
	public void testInsert(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Item it = new Item();
		it.setName("L");
		
		mapper.insert(it);
		
//		session.commit();	
		
		System.out.println("insert finished.");
	}
//	@Test
	public void testUpdate(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Item it = new Item();
		it.setId(2);
		it.setName("C");
		
		mapper.update(it);
	}
	
//	@Test
	public void testDeletebyId(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		mapper.deleteById(2);	
		
		
	}
	
//	@Test
	public void testDeleteArray(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Integer[] ids = new Integer[]{5,6};
				
		mapper.deleteArray(ids);
	}
	
	
//	@Test
	public void testDeleteList(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		ArrayList<Integer> list  = new ArrayList<Integer>();
		
		list.add(7);
//		list.add(4);
		
		mapper.deleteList(list);
	}
	
//	@Test
	public void testDeleteMap(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Integer[] idsi = new Integer[]{12,13};
		HashMap<String, Integer[]> ids = new HashMap<String, Integer[]>();		
		ids.put("ids", idsi);		
				
		mapper.deleteMap(ids);
	}
	
//	@Test
	public void testCount(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Integer result = mapper.count();
		
		System.out.println(result);
		
	}
	
//	@Test
	public void testcountPchsdItemsbyId(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Integer result = mapper.countPchsdItemsbyId(1);
		
		System.out.println(result);
	}
	
//	@Test
	public void testcountPchsdItemsbyName(){
		SqlSession session = factory.openSession();
		ItemMapper mapper = session.getMapper(ItemMapper.class);
		
		Integer result = mapper.countPchsdItemsbyName("J");
		
		System.out.println(result);
	}

}
