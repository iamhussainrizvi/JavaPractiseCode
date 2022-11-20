// if the length of the number is even
// take the first half, revese it and concatenate it witht the first half of the number.
// if the length of the number is odd
// take the first half , reverse it and then add --> first half + mid digit + reversed first half
//return answer 


import java.util.*;
public class Main {
	public static void main(String[] args) {
		//System.out.println("Hello, World");
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		int ans = getPalind(num);
		
		System.out.println(ans);
	}
	
	public static int getPalind(int num){
		
		String n = String.valueOf(num);
		String firstHalf = n.substring(0,n.length()/2);
		StringBuilder sb = new StringBuilder("");
			
			for(int a=n.length()/2-1;a>=0;a--){
				sb.append(n.charAt(a));
			}
		
		if(n.length()%2==0){
			return Integer.parseInt( firstHalf+sb.toString() );
		}else{
			
			char midDigit = n.charAt((n.length()/2));
			//System.out.println(firstHalf+" "+midDigit) ;
			return Integer.parseInt( firstHalf+midDigit+sb.toString() );
		}
	}
}
