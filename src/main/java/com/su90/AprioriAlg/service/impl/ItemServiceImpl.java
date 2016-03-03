package com.su90.AprioriAlg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.su90.AprioriAlg.base.BaseDao;
import com.su90.AprioriAlg.base.BaseServiceImpl;
import com.su90.AprioriAlg.dao.ItemDao;
import com.su90.AprioriAlg.domain.Item;
import com.su90.AprioriAlg.domain.Transaction;
import com.su90.AprioriAlg.service.ItemService;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {
	
	@Resource(name="itemDao")
	private ItemDao itemDao;

	@Override
	public BaseDao<Item> getBaseDao() {
		return this.itemDao;
	}

    public List<Item> findlike(String name) {
        return this.itemDao.findlike(name);
    }

    public Item findUniquelike(String name) {
        ArrayList<Item> list = new ArrayList(this.findlike(name));
        if (list.size()>0){
            return list.get(0);
        }else{                
            return null;
        }
    }

    public Integer countPchsdItemsbyID(Integer id) {
        return this.itemDao.countPchsdItemsbyID(id);
    }

    public Integer countPchsdItemsbyName(String name) {
        return this.itemDao.countPchsdItemsbyName(name);
    }

    public Integer count() {
        return this.itemDao.Count();
    }
}
