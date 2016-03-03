package com.su90.AprioriAlg.dao;

import com.su90.AprioriAlg.base.BaseDao;
import com.su90.AprioriAlg.domain.Transaction;
import java.util.List;

public interface TransactionDao extends BaseDao<Transaction> {
    public Transaction getTransbyCustomid(Integer cid);
    public Transaction getTranswithItems(Integer id);
    public void insertTranswithaItem(Integer tid, Integer iid);
    public void deleteTranswithaItem(Integer tid, Integer iid);

    public Integer countTranswithItemIds(List<Integer> ids);
    public Integer countTranswithItemNames(List<String> names);
}
