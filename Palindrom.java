package com.alex.algorithms;

public class Palindrom {

	public static void main(String[] args) {
		Palindrom pal = new Palindrom();
		System.out.println(pal.isPalindrome("anita lava la tina"));

	}
	
	private boolean isPalindrome(String text){
		String txt = text.trim().toLowerCase().replace(" ", "");
		boolean isP = true;
		if(txt.length() == 0){
			isP = false;
		}else if(text.length() == 1){
			isP = true;
		}else{
			for(int i = 0, j = txt.length()-1; !(i>j) ;i++, j--){
				System.out.println(txt.charAt(i) + " == "+ txt.charAt(j));
				if(txt.charAt(i) != txt.charAt(j)){
					isP = false;
					break;
				}
			}
		}
		return isP;
	}

}
