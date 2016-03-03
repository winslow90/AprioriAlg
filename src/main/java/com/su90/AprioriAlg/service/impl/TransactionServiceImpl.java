package com.su90.AprioriAlg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.su90.AprioriAlg.base.BaseDao;
import com.su90.AprioriAlg.base.BaseServiceImpl;
import com.su90.AprioriAlg.dao.TransactionDao;
import com.su90.AprioriAlg.domain.Transaction;
import com.su90.AprioriAlg.domain.Item;
import com.su90.AprioriAlg.service.TransactionService;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service("transactionService")
public class TransactionServiceImpl extends BaseServiceImpl<Transaction> implements TransactionService {
	
	@Resource(name="transactionDao")
	private TransactionDao transactionDao; 

	@Override
	public BaseDao<Transaction> getBaseDao() {
		return this.transactionDao;
	}

    public Transaction getTranswithItems(Integer id) {
        return this.transactionDao.getTranswithItems(id);
    }

    public void savenewTransItems(Transaction trans) {
        Transaction thetrans = trans;
        this.transactionDao.saveEntry(thetrans);
        thetrans = transactionDao.getTransbyCustomid(trans.getCid());
        ArrayList<Item> list = new ArrayList(trans.getItems());
        
        
        for (Item it : list){
            this.transactionDao.insertTranswithaItem(thetrans.getId(), it.getId());
        }        
    }

    public Integer countTranswithItemIds(List<Integer> ids) {
        if (ids.size()>0)  return this.transactionDao.countTranswithItemIds(ids);
        else return 0;
    }

    public Integer countTranswithItemNames(List<String> names) {
        if (names.size()>0)  return this.transactionDao.countTranswithItemNames(names);
        else return 0;
    }

    public void updateExistTransItems(Transaction trans) {
        
        Transaction oldtrans= this.transactionDao.getTranswithItems(trans.getId());
        
        ArrayList<Item> oldlist = new ArrayList(oldtrans.getItems());
        for (Item it : oldlist){
            this.transactionDao.deleteTranswithaItem(trans.getId(), it.getId());
        }  
        
        ArrayList<Item> list = new ArrayList(trans.getItems());
        
        for (Item it : list){
            this.transactionDao.insertTranswithaItem(trans.getId(), it.getId());
        }        
    }

    public Integer count() {
        return this.transactionDao.Count();
    }

}
