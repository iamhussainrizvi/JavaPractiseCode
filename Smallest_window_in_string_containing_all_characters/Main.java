//acquire the characters from the string2 while the desired limit is not reached. 
//(desired limit is that there must be all the characters of String 1 in the potential ans)
// once the limit is reached, that means we have all the charactes from the String 1.
// now we need to discard the extra characters one by one that we picked while trying to reached the desired limit
// we also need to keep in mind not to discard any usefull character.
// below if the java implementation for the above algo.


import java.util.*;
public class Main {
	public static void main(String[] args) {
		//user input 2 strings,
		Scanner scn = new Scanner(System.in);
		String str1 = scn.nextLine();
		String str2 =scn.nextLine();
		
		String ans = getMin(str1,str2);
		
		System.out.println(ans);
	}
	
	public static String getMin(String s1, String s2){
		
    //creating a frequency map for the first(Main) string.
		HashMap<Character, Integer> map1 =new HashMap<>();
		char ch;
		for(int a=0;a<s1.length();a++){
			ch = s1.charAt(a);
			map1.put(ch, map1.getOrDefault(ch,0)+1);
		}
    
    
		HashMap<Character, Integer> map2 =new HashMap<>(); // to store frequency of string 2's characters.
		int i=-1; //fast pointer
		int j=-1; //slow pointer
		String ans=""; // to store final answer;
		
		int dmct = s1.length();  // denoting the desired number of total characters in the Final Answer.
		int cmct =0; // denotes the current valid characters so far in the final Answer.
		
		while(true){
			boolean flag1=false;
			boolean flag2=false;
			//acquire
			while(i<s2.length()-1 && cmct <dmct){
				flag1=true;
				i++;
				ch = s2.charAt(i);
				
				map2.put(ch,map2.getOrDefault(ch,0)+1);
				
				if(map1.getOrDefault(ch,0) >= map2.getOrDefault(ch,0)){
					cmct++;
				}
			}
			// get answer and release;
			while(cmct==dmct && j<i){
				flag2=true;
				//storing possible answer
				ans = s2.substring(j+1, i+1);
				
				//releasing unwanted characters
				j++;
				ch = s2.charAt(j);
				
				if(map2.get(ch)==1){
					map2.remove(ch);
				}else{
					map2.put(ch, map2.get(ch)-1);
				}
				
				if(map2.getOrDefault(ch,0) < map1.getOrDefault(ch,0)){
					cmct--;
				}
			}
				if(flag1==false && flag2==false){
					break;
				}
			
		}
		return ans;
		
	}
}
