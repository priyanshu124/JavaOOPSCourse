package Practice;

import java.util.Scanner;

public class CaesarBreaker {
	
	public int[] countLetters(String message) {
		int[] count = new int[26];
		String alph = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i = 0; i < message.length(); i+=1) {
			int idx = alph.indexOf(Character.toLowerCase(message.charAt(i)));
			if(idx!=-1) {
				count[idx] += 1;
			}
		}
		return count;
	}
	
	
	public int indexOfMax(int[] values) {
		int indexOfMax = 0;
		for(int i=1; i < values.length; i+=1 ) {
			if(values[i] > values[indexOfMax]) {indexOfMax=i;}
		}
		return indexOfMax;
	}
	
	
	public String halfOfString(String message, int start) {
		StringBuilder halfString = new StringBuilder("");
		for(int i = start; i < message.length(); i+=2) {
			halfString = halfString.append(message.charAt(i));
		}
		return halfString.toString();
	}
	
	
	public int getKey(String s) {
		int[] freqs = countLetters(s);
		int indexOfMax = indexOfMax(freqs);
		int key = 0;
		if(indexOfMax < 4) {
			key = 26 - (4 - indexOfMax);
		}
		else {
			key = indexOfMax - 4;
		}
		return key;
	}
	
	public String decrypt(String encrypted) {
		
		CaesarCipher cc = new CaesarCipher();
		int decryptKey = getKey(encrypted);
		return cc.encrypt(encrypted, 26-decryptKey, 26-decryptKey);
		
	}
	
	public String decryptTwoKeys(String encrypted) {
		int key1 = getKey(halfOfString(encrypted, 0));
		int key2 = getKey(halfOfString(encrypted, 1));
		CaesarCipher cc = new CaesarCipher();
		return cc.encrypt(encrypted, 26-key1, 26-key2);
	}
	
	
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter string to decrypt");
		String encrypted = input.nextLine();
		
		CaesarBreaker cb = new CaesarBreaker();
		String firstHalf = cb.halfOfString(encrypted, 0);
		String secondHalf = cb.halfOfString(encrypted, 1);
		int key1 = cb.getKey(firstHalf);
		int key2 = cb.getKey(secondHalf);
		System.out.println("firstHalf = "+ firstHalf + ", secondHalf = "+ secondHalf);
		System.out.println("indexOfMax firstHalf = " + cb.indexOfMax(cb.countLetters(firstHalf))+ ", indexOfMax secondHalf = " + cb.indexOfMax(cb.countLetters(secondHalf)));
		System.out.println("key1="+key1+" key2="+key2);
		System.out.println(cb.decryptTwoKeys(encrypted));
	}
}
