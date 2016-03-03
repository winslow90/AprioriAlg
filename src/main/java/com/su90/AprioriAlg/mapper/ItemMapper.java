package com.su90.AprioriAlg.mapper;

import com.su90.AprioriAlg.base.BaseMapper;
import com.su90.AprioriAlg.domain.Item;

public interface ItemMapper extends BaseMapper<Item> {
	public Integer countPchsdItemsbyId(Integer id);
	public Integer countPchsdItemsbyName(String name);
}
