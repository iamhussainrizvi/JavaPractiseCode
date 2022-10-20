// this program find the duplicate number in a array of numbers 1 to N, in O(N) time and constant space.

import java.util.Scanner;
public class FindDuplicateInArray
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int a=0;a<n;a++){
		    arr[a]=scn.nextInt();
		}
		
		int slow = arr[0];
		int fast = arr[0];
		
		do{
		    slow = arr[slow];
		    fast = arr[arr[fast]];
		}while(slow != fast);
		
		fast = arr[0];
		
		while(slow != fast){
		    slow = arr[slow];
		    fast= arr[fast];
		}
		System.out.println(slow);
	}
}
