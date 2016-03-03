package com.su90.AprioriAlg.service;

import com.su90.AprioriAlg.base.BaseService;
import com.su90.AprioriAlg.domain.Item;
import java.util.List;

public interface ItemService extends BaseService<Item> {
    public List<Item> findlike(String name);
    public Item findUniquelike(String name);
    public Integer countPchsdItemsbyID(Integer id);
    public Integer countPchsdItemsbyName(String name);
}
