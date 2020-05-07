// Design a simple calculator using abstract factory design pattern

package com.assignment;

import java.util.Scanner;

interface Calculator{
	
	 int compute(int a,int b);
}

class add implements Calculator{ // Concrete class to implement addition operation
	
	@Override
	public int compute(int a,int b) {
		return(a+b);
	}
}

class diff implements Calculator{// Concrete class to implement minus operation
		
		@Override
		public int compute(int a,int b) {
			return(a-b);
		}
	}

class mul implements Calculator{// Concrete class to implement multiplication operation
	
	@Override
	public int compute(int a,int b) {
		return(a*b);
	}
}

class div implements Calculator{
	// Concrete class to implement division operation
	@Override
	public int compute(int a,int b) {
		return(a/b);
	}
}

//Factory class
class CalculatorFactory{
	
	Calculator getfunction(char op) {
		
		if(op=='+')
			return new add();
		else if(op=='-')
			return new diff();
		else if(op=='*')
			return new mul();
		else if(op=='/')
			return new diff();
		else
			return null;
			
	}
}


public class Assign3 {
	
	public static void main(String[] args) {
		
		int num1,num2;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 2 numbers:");
		num1=in.nextInt();
		num2=in.nextInt();
		System.out.println("Select your operation:\n + \t - \t * \t /");
		char op=in.next().charAt(0);
		CalculatorFactory f=new CalculatorFactory();
		Calculator obj=f.getfunction(op);
		if(obj==null)
		{
			System.out.println("Invalid operation selected");
			return;
		}
		System.out.println(obj.compute(num1,num2));
	}
	
}
