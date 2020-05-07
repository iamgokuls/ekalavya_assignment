package com.assignment;

public class Assign5{
	
	static void permutation(String str,String s ) {
		
		if(str.length()==0) {
			System.out.println(s);
			return;
		}
		
		for(int index=0;index<str.length();index++) {
			
			char ch=str.charAt(index);
			String temp= str.substring(0,index)+str.substring(index+1);
			permutation(temp,s+ch);
		}
	}

	public static void main(String [] args){
		
		String str="EKLAVYA2020";
		permutation(str,"");
	}
	
}