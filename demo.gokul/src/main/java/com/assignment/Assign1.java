//Display all subset of array [1,2,....9] whose sum is 9

package com.assignment;

public class Assign1 {

	static void sub(int[] ar, int csum, int index, int sum,int[] s)
    {
        if (csum == sum) {
          System.out.println("\n");
          
          for (int i = 0; i < 9; i++) {
        	  
            if (s[i] == 1)
            {
              System.out.print("  " + ar[i]);
            }
          }

        } 
        
        else if (index == 9) {
          return;
        }
        
        else {
          s[index] = 1;
          csum += ar[index];
          sub(ar, csum, index + 1, sum, s);
          csum -= ar[index];	
          s[index] = 0;
          sub(ar, csum, index + 1, sum, s);
        }
        
      }
	
      public static void main(String[] args) {
        int[] ar = { 1,2,3,4,5,6,7,8,9};
        int[] s = new int[9];
        sub(ar, 0, 0, 9, s);
      }
}
