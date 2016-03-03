package com.su90.AprioriAlg.domain;

import java.io.Serializable;

public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1414911267916084797L;
	public Integer id;
	public String name;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Item: ");
		sb.append(id);
		sb.append(name);
		sb.append("\n");
		
		return sb.toString();
	}	
}
