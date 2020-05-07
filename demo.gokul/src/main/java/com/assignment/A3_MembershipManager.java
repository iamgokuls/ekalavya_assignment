package com.assignment;
//Program to demonstrate Factory method pattern
//This program handles membership management of members in a club
//For demonstration purpose only create member function is implemented

import java.util.Scanner;

interface Member{
    void register(); 
	void notify_member();
}

class AnnualMember implements Member{
	
	String name;
	int age;
	int advance=1000;
	int AnnualFee=5000;
	Scanner sc=new Scanner(System.in);
	@Override
	public void register() {
		System.out.println("Type your name");
		name=sc.next();
		System.out.println("Type your age");
		age=sc.nextInt();
		
	}
	
	@Override
	public void notify_member() {
		System.out.println(name+" Successfully registered for Annual Membership");
		System.out.println("Advance fee is "+advance+" and AnnualFee is"+AnnualFee);
		
	}
}
class LifetimeMember implements Member{

	String name;
	int age;
	int advance=1500;
	int AnnualFee=3000;
	Scanner sc=new Scanner(System.in);
	@Override
	public void register() {
		System.out.println("Type your name");
		name=sc.next();
		System.out.println("Type your age");
		age=sc.nextInt();
		
	}
	
	@Override
	public void notify_member() {
		System.out.println(name+" Successfully registered for Lifetime Membership");
		System.out.println("Advance fee is "+advance+" and AnnualFee is"+AnnualFee);
		
	}
}
class TempMember implements Member{
	
	String name;
	int age;
	int advance=500;
	int MonthlyFee=500;
	Scanner sc=new Scanner(System.in);
	@Override
	public void register() {
		System.out.println("Type your name");
		name=sc.next();
		System.out.println("Type your age");
		age=sc.nextInt();
		
	}
	
	@Override
	public void notify_member() {
		System.out.println(name+" Successfully registered for Temperory Membership");
		System.out.println("Advance fee is "+advance+" and MonthlylFee is"+MonthlyFee);
		
	}
}

class MemberFactory{ // Factory class
	
	public Member create_member(int op) {
		
		if(op==1)
			return new LifetimeMember();
			else if(op==2)
				return new AnnualMember();
				else if(op==3)
					return new TempMember();
					else
						return null;
	
	}
}

public class A3_MembershipManager {
	
	  static void create_membership() {
		
		 System.out.println("Which type of membership do you need>?\n 1.Lifetime 2.Annual 3.Temperory\n choose your option");
		 Scanner sc=new Scanner(System.in);
		 int option=sc.nextInt();
		 MemberFactory mf=new MemberFactory();
		 Member m=mf.create_member(option);
		 if(m==null)
		 {
			 System.out.println("Invalid option..... ");
			 return;
		 }
		 m.register();
		 m.notify_member();
		
	}
	
	public static void main(String[] args) {
		create_membership();
	}
}
