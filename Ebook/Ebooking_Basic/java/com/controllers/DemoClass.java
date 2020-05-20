package com.controllers;

public class DemoClass {
	
	private int num;
	private String name;
	
	DemoClass(){}

	public DemoClass(int num, String name) {
		
		this.num = num;
		this.name = name;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DemoClass [num=" + num + ", name=" + name + "]";
	}
	
	
	

}
