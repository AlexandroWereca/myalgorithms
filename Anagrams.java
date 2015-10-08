package com.alex.algorithms;

import java.util.Arrays;

public class Anagrams {

	public static void main(String[] args) {
		System.out.println(areAnagrams("Typhon","Pyhon"));
	}
	
	private static boolean areAnagrams(String one, String two){
		char[] o = one.toLowerCase().toCharArray();
		char[] t = two.toLowerCase().toCharArray();
		Arrays.sort(o);
		Arrays.sort(t);
		return Arrays.equals(o, t);
	}

}
