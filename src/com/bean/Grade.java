package com.bean;

import java.util.Date;

public class Grade{
	private Integer id;
	private String name;


	public Grade(){
		super();
	}
	public Grade(Integer id,String name) {
		super();
		this.id = id;
		this.name = name;

	}
	
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

}