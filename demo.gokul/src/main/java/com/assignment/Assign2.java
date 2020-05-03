//For a given array and count k, reverse the first k elements,second k elements etc....

package com.assignment;

import java.util.Scanner;

public class Assign2 {
	
	public static void main(String [] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n = in.nextInt();
		int[] ar=new int[n];
		
		System.out.println("Enter  elements");
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		System.out.println("Enter count");
		int c=in.nextInt();
		
		if(c>n) // case when count is greater than array size
		{
			c=n;
		}
		
		for(int i=0;i<n;i=i+c)
		{
			if((n-i)<c)
			{
				c=n-i; // to handle case when the last block has size less than count
			}
			
			for (int start=i,end=i+c-1;start<=end;start++,end--) {
			     int temp = ar[start];
			     ar[start] = ar[end];
			     ar[end] = temp;
			 }
			
		}
		
		
		for(int i=0;i<n;i++)
		{
		System.out.println(ar[i]);
		}
		
		
	
	}

}
