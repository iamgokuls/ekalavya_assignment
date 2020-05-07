package com.assignment;

class CharacterNotFound extends Exception{ // Exception to handle character not found while using return_position method
	
	CharacterNotFound(String msg){
		
		//super(msg);
		System.out.println(msg);
	}
}


public class A6_StringManipulation {
	
	public static int return_position(String str,char ch) throws CharacterNotFound {
		
		if (str.indexOf(ch)==-1)
			throw new CharacterNotFound("No character found");
		else
			return(str.indexOf(ch));
		
		
	}
	
	public static void reverse(String str) {
		
		for (int i=str.length()-1;i>=0;i--){
			
					System.out.print(str.charAt(i));
				}
		System.out.println("\n");
	}
	
	
	public static void main(String [] args) throws CharacterNotFound {
		
		String str="abcdef(qwwas)gghhs";
		System.out.println("String is : "+str);
		// 1. To print position of opening&closing paranthesis
		System.out.println("Position of opening paranthesis: " + return_position(str,'('));
		System.out.println("Position of closing paranthesis: " + return_position(str,')'));
		
		// 2. To print substring inside the paranthesis(inclusive of paranthesis)
		System.out.print("String starting from open paranthesis to closed paranthesis (inclusive of the paranthesis)");
		System.out.println(str.substring(return_position(str,'(') , return_position(str,')')+1) );
		
		
		// 3. Count the number of characters
		System.out.println("Length of string is : "+ str.length());
		
		// 4. Reverse the original string
		System.out.print("reverse of string :");
		 reverse(str);
		 
		 
		//5. Character at position n-1
		 try {
			 System.out.println("Character at position n-1: " + str.charAt(str.length()-1));
		 }
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Index given is incorrect");
		}
		 
	}

}
