package com.su90.AprioriAlg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.su90.AprioriAlg.base.BaseDaoImpl;
import com.su90.AprioriAlg.dao.TransactionDao;
import com.su90.AprioriAlg.domain.Transaction;
import com.su90.AprioriAlg.mapper.TransactionMapper;
import java.util.ArrayList;
import java.util.HashMap;

@Repository("transactionDao")
public class TransactionDaoImpl extends BaseDaoImpl<Transaction> implements TransactionDao {

	public TransactionDaoImpl() throws ClassNotFoundException {
		super();
	}

    public Transaction getTranswithItems(Integer id) {
        TransactionMapper mapper = this.getSqlSession().getMapper(TransactionMapper.class);
        return mapper.getTranswithItems(id);
    }

    public void insertTranswithaItem(Integer tid, Integer iid) {
        TransactionMapper mapper = this.getSqlSession().getMapper(TransactionMapper.class);
        HashMap<String, Integer> map = new HashMap();
        map.put("tid", tid);
        map.put("iid", iid);
        mapper.insertTranswithaItem(map);
    }

    public void deleteTranswithaItem(Integer tid, Integer iid) {
        TransactionMapper mapper = this.getSqlSession().getMapper(TransactionMapper.class);
        HashMap<String, Integer> map = new HashMap();
        map.put("tid", tid);
        map.put("iid", iid);
        mapper.deleteTranswithaItem(map);
    }

    public Integer countTranswithItemIds(List<Integer> ids) {
        TransactionMapper mapper = this.getSqlSession().getMapper(TransactionMapper.class);
        return mapper.countTranswithItemIds(ids);
    }

    public Integer countTranswithItemNames(List<String> names) {
        TransactionMapper mapper = this.getSqlSession().getMapper(TransactionMapper.class);
        return mapper.countTranswithItemNames(names);
    }

    public Transaction getTransbyCustomid(Integer cid) {
        TransactionMapper mapper = this.getSqlSession().getMapper(TransactionMapper.class);
        HashMap<String, Object> map = new HashMap();
        map.put("cid", cid);
        ArrayList<Transaction> result= new ArrayList<Transaction>(mapper.find(map));
        if (result.size()>0){
            return result.get(0);
        }else{
            return null;
        }
    }

}
