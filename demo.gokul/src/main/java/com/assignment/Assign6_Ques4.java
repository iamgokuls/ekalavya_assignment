package com.assignment;
// Illustriate use of string as a literal and as an object


public class Assign6_Ques4 {
	
	public static void main(String[] args) {
		
		String s1="Gokul";            			//String as a literal 
		String s2=new String("Govind");			//String as an object
		
		String s3="Gokul";
		String s4=new String("Govind");
		
		System.out.println(s1==s3);				// True
		System.out.println(s1.equals(s3));		// True
		
		System.out.println(s2==s4);				// False
		System.out.println(s2.equals(s4));		// True , Here content of two objects are compared
		
		
		String s5=new String("Gokul");
		System.out.println(s1==s5);				// false
		System.out.println(s1.equals(s5));		// True
		
		String s6=s1;
		String s7=s2; 							// Now both s2 and s7 refers to the same object
		System.out.println(s1==s6);				// True
		System.out.println(s2==s7);				// True 
		
		s5=s5.intern();
		System.out.println(s1==s5);				// True, when intern is called reference will change

		
	}

}
