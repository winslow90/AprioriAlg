package com.su90.AprioriAlg.service;

import com.su90.AprioriAlg.base.BaseService;
import com.su90.AprioriAlg.domain.Transaction;
import java.util.List;

public interface TransactionService extends BaseService<Transaction> {
    public Transaction getTranswithItems(Integer id);
    public void savenewTransItems(Transaction trans);
    public void updateExistTransItems(Transaction trans);
    public Integer countTranswithItemIds(List<Integer> ids);
    public Integer countTranswithItemNames(List<String> names);
}
