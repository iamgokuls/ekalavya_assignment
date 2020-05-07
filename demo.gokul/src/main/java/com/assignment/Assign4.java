package com.assignment;
// Illustriate different object initialization methods
// Illustriate uses of 'this' keyword
//Illustriate uses of 'super' keyword

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

class Person{
	 
	String Name;
	int age;
	
	Student obj;
	
	Person(){
		
		Name="your name";
		age=15;
	}
	
	Person(Student obj){
		
		this.obj=obj;								 // Using �this� keyword as an argument in the constructor call
		
	}
	
	public void print() {
		System.out.println("Name: "+Name+ "\nage: "+age);
	}
	
	
}

 class Student extends Person implements Cloneable{
	 
	int rollno;
	double gpa;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {

	    return super.clone();
	}
	
	Student(){
		
		this(2,7.5); 								//Using this() to invoke current class constructor
	}
	
	Student(int rollno,double gpa){
		
		super();									//Use of super with constructors
		
		this.rollno=rollno; 						//Using �this� keyword to refer current class instance variables
		this.gpa=gpa;
		this.print();								//Using �this� keyword to invoke current class method
		this.display(this);							//Using �this� keyword as method parameter
	}
	
	public void display(Student obj) {
		System.out.println("Name : "+ super.Name);  //  Use of super with variables
	}
	
	Student get() {
		return this; 								//  Using �this� keyword to return the current class instance
		
	}
	
	@Override
	public void print() {
		super.print(); 								//Use of super with methods
		System.out.println("Rollno: "+rollno+ "\nGPA: "+gpa);
	}
	
}




class Assign4  {
	
	
	
	public static void main(String [] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
													//Different methods to create an object
		
													//1.new keyword
		Student s1=new Student();
		
													//2.Using newInstance() method
		try{
			Student s2=Student.class.newInstance();
		}
		catch (InstantiationException e) { 
            e.printStackTrace(); 
        }
		catch (IllegalAccessException e) { 
            e.printStackTrace(); 
        }
		
													//3.Using newInstance() method of Constructor class
		try { 
			Constructor<Student> constructor = Student.class.getConstructor(int.class,double.class);
			Student s3 = constructor.newInstance(3,8.6);
	    } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
													//4.Using clone() method
		
		try {
			Student s4=(Student) s1.clone();
		}
		catch (CloneNotSupportedException e) { 
	            e.printStackTrace(); 
	    }
		
		
													//5.Using Deserialization
		
		try {
			FileOutputStream f = new FileOutputStream("student.txt");     
			ObjectOutputStream out = new ObjectOutputStream(f);
			Student s5 = new Student();
			out.writeObject(s5);
			out.close();
			f.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//reading object in file
		try {
			FileInputStream f = new FileInputStream("student.txt");
			ObjectInputStream in = new ObjectInputStream(f);
			Student s5 = (Student)in.readObject();
			s5.print();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		s1.print();
		
	}

}
