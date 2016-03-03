/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.su90.AprioriAlg.controller;

import com.su90.AprioriAlg.service.ItemService;
import com.su90.AprioriAlg.service.TransactionService;
import com.su90.AprioriAlg.utils.SpringUtil;
import com.su90.AprioriAlg.domain.Item;
import static com.su90.AprioriAlg.utils.SpringUtil.context;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author superman90
 */
public class AprioriAlgProcessor extends SpringUtil {
    private TransactionService transactionService;
    private ItemService itemService;
    private Integer miniSupportNum;
    ArrayList<Item> allitems;
	
    public AprioriAlgProcessor(Double minisupport){
            this.transactionService = (TransactionService) context.getBean("transactionService");
            this.itemService = (ItemService) context.getBean("itemService");		
            this.miniSupportNum = (Integer)Math.round((float) (transactionService.count()*minisupport));
    }
    
    LinkedList<SearchItemType> operatoQueue = new LinkedList();
    ArrayList<SearchItemType> intermediateResult = new ArrayList();
        
    private void initOperateQueue(){
        this.allitems = new ArrayList<Item>(this.itemService.getEntries());
        
        for (Item item : allitems){
            Integer PchsdCount = itemService.countPchsdItemsbyID(item.getId());
            if (PchsdCount > miniSupportNum){
                SearchItemType searchitem = new SearchItemType(transactionService, itemService);
                searchitem.getSearchItems().add(item);                
                operatoQueue.addLast(searchitem);
            }            
        }        
    }    
    private void _do_intermediatesearch(SearchItemType searchItem){
        for (Item item : allitems){
            if (searchItem.largerIdthanMe(item.getId())){
                SearchItemType newsearchitem = new SearchItemType(transactionService, itemService);
                newsearchitem.getSearchItems().addAll(searchItem.getSearchItems());
                newsearchitem.getSearchItems().add(item);
                if (newsearchitem.countTransContainMe()>miniSupportNum){
                    intermediateResult.add(newsearchitem);
                    operatoQueue.addLast(newsearchitem);
                }
            }
        }
    }
    private void generateIntermediateResult(){
        while (operatoQueue.size()>0){
            SearchItemType searchItem = operatoQueue.getFirst();
            operatoQueue.removeFirst();
            _do_intermediatesearch(searchItem);
        }
    }
    private void generateFinalResult(){
        for (SearchItemType searchitem : intermediateResult){
            searchitem.generateEquation();
        }        
    }
    public void do_process(){
        this.initOperateQueue();
        this.generateIntermediateResult();
        this.generateFinalResult();
    }
}

class SearchItemType{
    private TransactionService transactionService;
    private ItemService itemService;
    private SearchItemSentence lefts,rights;
    
    
    public SearchItemType(TransactionService transactionService, ItemService itemService){
        this.transactionService= transactionService;
        this.itemService = itemService;
    }        
    
    ArrayList<Item> searchItems = new ArrayList();

    public ArrayList<Item> getSearchItems() {
        return searchItems;
    }

    public void setSearchItems(ArrayList<Item> searchItems) {
        this.searchItems = searchItems;
    }
    

    public Integer countTransContainMe(){
        ArrayList<Integer> ids = new ArrayList();
        for(Item it: searchItems){
            ids.add(it.getId());
        }
        return transactionService.countTranswithItemIds(ids);
    }
    public boolean largerIdthanMe(Integer id){
        for(Item it : searchItems){
            if (it.getId()>=id) return false;
        }
        return true;
    }
    private void outputOneResult(LinkedList<Item> from, LinkedList<Item> to, Integer total, Integer supportnum, Integer confidencenum){
        StringBuilder sb = new StringBuilder();
        for (Item it : from){
            sb.append(it.getName());
            sb.append(" ");
        }
        sb.append("-> ");
        for (Item it : to){
            sb.append(it.getName());
            sb.append(" ");
        }
        sb.append(": [");
        float r1 = confidencenum;
        r1= r1/total;
        sb.append(r1);
        sb.append(", ");
        float r2 = confidencenum;
        r2 = r2/supportnum;
        sb.append(r2);
        sb.append("]");
        System.out.println(sb.toString());                
    }
    private void _do_EquSearch(Integer index){
        if (index>= searchItems.size()){
            if ((lefts.getItems().size()>0)&&(rights.getItems().size()>0)){
                outputOneResult(lefts.getItems(),rights.getItems(),
                        transactionService.count(),
                        lefts.countTransContainMe(),
                        this.countTransContainMe()
                        );
            }
        }else{
            if (lefts.largerIdthanMe(searchItems.get(index).getId())){
                lefts.getItems().addLast(searchItems.get(index));
                _do_EquSearch(index+1);
                lefts.getItems().removeLast();
            }
            if (rights.largerIdthanMe(searchItems.get(index).getId())){
                rights.getItems().addLast(searchItems.get(index));
                _do_EquSearch(index+1);
                rights.getItems().removeLast();
            }
        }
    }
    public void generateEquation(){
        lefts = new SearchItemSentence(transactionService, itemService);
        rights = new SearchItemSentence(transactionService, itemService);
        _do_EquSearch(0);
    }
}

class SearchItemSentence{
    private TransactionService transactionService;
    private ItemService itemService;
    
    private LinkedList<Item> items = new LinkedList();

    public LinkedList<Item> getItems() {
        return items;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }
        
    public SearchItemSentence(TransactionService transactionService, ItemService itemService){
        this.transactionService= transactionService;
        this.itemService = itemService;
    }      
    
    public Integer countTransContainMe(){
        ArrayList<Integer> ids = new ArrayList();
        for(Item it : items){
            ids.add(it.getId());
        }
        if (ids.size()>0){
            return transactionService.countTranswithItemIds(ids);     
        }else{
            return 0;
        }
    }
    public boolean largerIdthanMe(Integer id){
        for(Item it : items){
            if (it.getId()>=id) return false;
        }        
        return true;
    }
}