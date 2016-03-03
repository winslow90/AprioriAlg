package com.su90.AprioriAlg.dao;

import com.su90.AprioriAlg.base.BaseDao;
import com.su90.AprioriAlg.domain.Item;
import java.util.List;
import java.util.Map;

public interface ItemDao extends BaseDao<Item> {
    public List<Item> findlike(String name);
    public Integer countPchsdItemsbyID(Integer id);
    public Integer countPchsdItemsbyName(String name);
}
