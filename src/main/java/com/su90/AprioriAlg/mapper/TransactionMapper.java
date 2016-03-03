package com.su90.AprioriAlg.mapper;

import java.util.List;
import java.util.Map;

import com.su90.AprioriAlg.base.BaseMapper;
import com.su90.AprioriAlg.domain.Transaction;

public interface TransactionMapper extends BaseMapper<Transaction> {
	public Transaction getTranswithItems(Integer id);
	public void insertTranswithaItem(Map<String, Integer> map);
	public void deleteTranswithaItem(Map<String, Integer> map);
	
	public Integer countTranswithItemIds(List<Integer> ids);
	public Integer countTranswithItemNames(List<String> names);	
}
