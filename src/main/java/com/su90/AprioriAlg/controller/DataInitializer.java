package com.su90.AprioriAlg.controller;

import java.util.List;

import com.su90.AprioriAlg.domain.Item;
import com.su90.AprioriAlg.domain.Transaction;
import com.su90.AprioriAlg.service.ItemService;
import com.su90.AprioriAlg.service.TransactionService;
import com.su90.AprioriAlg.utils.SpringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class DataInitializer extends SpringUtil {
        private static int INITCID=1;
	private TransactionService transactionService;
	private ItemService itemService;        
	
	public DataInitializer(){
		this.transactionService = (TransactionService) context.getBean("transactionService");                
		this.itemService = (ItemService) context.getBean("itemService");		                
	}
        
        public void formatToSelfDefinedData(String[] itemnames, String[][] transitemnamesstr){
            cleanitems();
            cleantransactions();
            insertSelfDefinedItems(itemnames);
            for(String[] strs: transitemnamesstr){
                insertSelfDefinedTrans(strs);
            }
        }
        private void insertSelfDefinedItems(String[] itemnames){
//            String[] itemnames = new String[]{"A","B","C","D","E"};            
            for (String name : itemnames){
                Item it = new Item();
                it.setName(name);
                itemService.saveEntry(it);
            }          
        }
        
        private void insertSelfDefinedTrans(String[] transitemnames) {
            Transaction trans;
            ArrayList<Item> items;
            
            items= new ArrayList();
            
            for (String str: transitemnames){
                items.add(itemService.findUniquelike(str));
            }
            
            trans=new Transaction();
            trans.setCid(INITCID++);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);
        }
        
        public void formatToSampleDate(){
            cleanitems();
            cleantransactions();
            insertsampleitems();
            insertsampletrans();
        }
        
        public void formatToRandomDate(final int totaltrans){
            cleanitems();
            cleantransactions();
            insertrandomitesm();
            insertrandomtrans(totaltrans);
        }
	
	private void cleanitems(){
            List<Item> allitems = itemService.getEntries();
            Integer[] ids;		
            ids = new Integer[allitems.size()];
            int i =0;		
            for (Item it : allitems){
                    ids[i++] = it.getId();
            }		
            itemService.deleteEntriesByIds(ids);		
	}
        private void cleantransactions(){
            List<Transaction> alltrans = this.transactionService.getEntries();
            Integer[] ids;		
            ids = new Integer[alltrans.size()];
            int i =0;		
            for (Transaction it : alltrans){
                    ids[i++] = it.getId();
            }		
            transactionService.deleteEntriesByIds(ids);                        
        }
        
        private void insertsampleitems(){
            String[] itemnames = new String[]{"A","B","C","D","E"};
            
            for (String name : itemnames){
                Item it = new Item();
                it.setName(name);
                itemService.saveEntry(it);
            }            
        }
        
        private void insertsampletrans(){
            Transaction trans;
            ArrayList<Item> items;
            
            items= new ArrayList<Item>();
            items.add(itemService.findUniquelike("B"));
            items.add(itemService.findUniquelike("C"));
            trans=new Transaction();
            trans.setCid(1);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);
            
            items= new ArrayList<Item>();
            items.add(itemService.findUniquelike("B"));
            items.add(itemService.findUniquelike("C"));
            items.add(itemService.findUniquelike("D"));
            trans=new Transaction();
            trans.setCid(2);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);
            
            items= new ArrayList<Item>();
            items.add(itemService.findUniquelike("A"));
            items.add(itemService.findUniquelike("D"));
            trans=new Transaction();
            trans.setCid(3);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);
            
            items= new ArrayList<Item>();
            items.add(itemService.findUniquelike("A"));
            items.add(itemService.findUniquelike("B"));
            items.add(itemService.findUniquelike("C"));
            items.add(itemService.findUniquelike("D"));
            trans=new Transaction();
            trans.setCid(4);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);
                        
            items= new ArrayList<Item>();
            items.add(itemService.findUniquelike("C"));
            items.add(itemService.findUniquelike("D"));
            trans=new Transaction();
            trans.setCid(5);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);
            
            items= new ArrayList<Item>();
            items.add(itemService.findUniquelike("C"));
            items.add(itemService.findUniquelike("D"));
            items.add(itemService.findUniquelike("E"));
            trans=new Transaction();
            trans.setCid(6);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);
            
            items= new ArrayList<Item>();
            items.add(itemService.findUniquelike("A"));
            items.add(itemService.findUniquelike("B"));
            trans=new Transaction();
            trans.setCid(7);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);           
            
        }
        
        

    private void insertrandomitesm() {
        String[] itemnames = new String[]{"A","B","C","D","E","F","G","H","I","J"};
            
            for (String name : itemnames){
                Item it = new Item();
                it.setName(name);
                itemService.saveEntry(it);
            }         
    }

    private void insertrandomtrans(final int totalnum) {
        
        ArrayList<Item> allitems = new ArrayList(itemService.getEntries());
        Transaction trans;
        ArrayList<Item> items;
        Random randomGenerator = new Random();
        
        for (int i = 0 ; i <totalnum; i++){
            items= new ArrayList<Item>();
            
            for (Item it : allitems){
                if (randomGenerator.nextBoolean()){
                    items.add(it);
                }                
            }            
            trans=new Transaction();
            trans.setCid(i+1000);
            trans.setTdate(new Date());
            trans.setItems(items);
            transactionService.savenewTransItems(trans);                    
        }        
    }

	
}
