package com.alex.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Palindromos {
	
	public static void main(String[] args) {
		String [] str = {"ivcci", "oyotta", "cecarar", "bbb", "babbb","xxoo","a","abcdef","abbb", "dvd","baba","roo","oosms"};
		construct_palindromes(str);
	}
	
	public static void construct_palindromes(String [] word){
		Map<Character,Integer> control = null;
		List<String> result = new ArrayList<String>();
		if(!(word.length-1 > 1000)){
			for(String s: word){
				control = new TreeMap<Character, Integer>();
				if(!(s.length() > 1000)){
					for(int i = 0; i<s.length(); i ++){
						if(!control.containsKey(s.charAt(i))){
							control.put(s.charAt(i), 1);
						}else{
							control.put(s.charAt(i), control.get(s.charAt(i))+1);
						}
						
					}
					
					StringBuilder even = new StringBuilder();
					StringBuilder odd = new StringBuilder();
					Character middle = null; int te = 0;
					for(Map.Entry<Character, Integer> entry: control.entrySet()){
						Character currentChar = entry.getKey();
						Integer times = entry.getValue();
						if(times % 2 == 0){
							int c = times/2;
							while(c > 0){
								even.append(currentChar);
								c --;
							}
						}else{
							te ++;
							middle = currentChar;
							while(times > 0){
								odd.append(middle);
								times --;
							}
							
						}
					}
					
					if(te > 1){
						even.delete(0, even.length());
						even.append("-1");
					}else{
						String original =null;
						String reverse = null;
						if(middle != null){
							if(even.length() != 0){
								original = even.toString();
								reverse = even.reverse().toString();
								even.delete(0, even.length());
								even.append(original+reverse).insert(s.length()/2, odd);
							}else{
								even.append(odd);
							}
						}else{
							original = even.toString();
							reverse = even.reverse().toString();
							even.delete(0, even.length());
							even.append(original+reverse);
						}
					}
					
					
					result.add(even.toString());
				}
			}
		}
		
		for(String c: result){
			System.out.println(c);
		}
		
		
	}

}
