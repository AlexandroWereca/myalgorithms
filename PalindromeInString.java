package com.alex.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PalindromeInString {

	public static void main(String[] args) {
		findPalindrome("asygfgrecsabdbascpabba");

	}
	private static void findPalindrome(String text){
		List<String> palindromes = new ArrayList<String>();
		int l = 0, r =0, p =0, t = text.trim().length();
		for(int i=0; i < t; i++){
			p = i;
			if(p == 0 && l-1 < 0){
				continue;
			}
			if(p == t-1){
				//System.out.println("p: "+p+" t: "+t);
				break;
			}
			l = p-1; r = p+1;
			//System.out.println("L = "+l+" R = "+r);
			if(text.charAt(l) == text.charAt(r)){
				int d = r, z = l;
				//System.out.println("Z = "+z+" D = "+d);
				while(text.charAt(z) == text.charAt(d)){
					if(d == t-1){
						//System.out.println("d+1 == t-1 "+d+" "+ z);
						d=t;
						//z--;
						break;
						
					}else if(!(d == t-1) && !(z-1<0)){
						//System.out.println("inside if");
						d++; z--;
						//System.out.println("inside if"+d+" "+z);
					}
					
				}
				//System.out.println("Z = "+z+" D = "+d);
				//System.out.println(text.substring(z+1,d));
				palindromes.add(text.substring(z+1,d));
				//isFound = true;
			}else{
				continue;
			}
		}
		for(String s: palindromes){
			System.out.println(s);
		}
		//System.out.println("palindromes found: "+palindromes);
		
	}

}
