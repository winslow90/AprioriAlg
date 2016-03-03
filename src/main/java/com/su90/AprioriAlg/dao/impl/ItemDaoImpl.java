package com.su90.AprioriAlg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.su90.AprioriAlg.base.BaseDaoImpl;
import com.su90.AprioriAlg.dao.ItemDao;
import com.su90.AprioriAlg.domain.Item;
import com.su90.AprioriAlg.mapper.ItemMapper;
import java.util.HashMap;

@Repository("itemDao")
public class ItemDaoImpl extends BaseDaoImpl<Item> implements ItemDao {

	public ItemDaoImpl() throws ClassNotFoundException {
		super();
	}

    public Integer countPchsdItemsbyID(Integer id) {
        ItemMapper mapper = this.getSqlSession().getMapper(ItemMapper.class);
        return mapper.countPchsdItemsbyId(id);
    }

    public Integer countPchsdItemsbyName(String name) {
        ItemMapper mapper = this.getSqlSession().getMapper(ItemMapper.class);
        return mapper.countPchsdItemsbyName(name);
    }

    public List<Item> findlike(String name) {
        ItemMapper mapper = this.getSqlSession().getMapper(ItemMapper.class);
        
        HashMap<String,Object> map = new HashMap();
        map.put("name", name);
        return mapper.find(map);        
    }

}
