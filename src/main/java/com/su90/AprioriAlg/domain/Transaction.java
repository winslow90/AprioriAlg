package com.su90.AprioriAlg.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1631621202504104584L;
	public Integer id;
        public Integer cid;

	public Date tdate;
	
	public List<Item> items;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}        
        public Integer getCid() {
            return cid;
        }

        public void setCid(Integer cid) {
            this.cid = cid;
        }
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Trans: ");
		sb.append(id);
                sb.append(cid);
		sb.append(tdate);
		sb.append("\n");
		
		return sb.toString();
	}
}
