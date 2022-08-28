package Practice;

import java.util.Scanner;

public class CaesarCipher {
	public String encrypt(String input, int key1, int key2) {
		StringBuilder encrypted = new StringBuilder(input);
		String upAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowAlphabet = upAlphabet.toLowerCase();
		String shiftedUpAlphabet1 = upAlphabet.substring(key1) + upAlphabet.substring(0,key1);
		String shiftedUpAlphabet2 = upAlphabet.substring(key2) + upAlphabet.substring(0,key2);
		String shiftedLowAlphabet1 = shiftedUpAlphabet1.toLowerCase();
		String shiftedLowAlphabet2 = shiftedUpAlphabet2.toLowerCase();
		
		for(int i = 0; i < encrypted.length(); i+=1) {
			char c = encrypted.charAt(i);
			//if char is upper case then use uppercase Shifted alphabet
			if (Character.isUpperCase(c)) {
				int indexC = upAlphabet.indexOf(c);
				// if the chr is aphabet
				if (indexC != -1) {
					if (i%2 == 0) {
						encrypted.setCharAt(i, shiftedUpAlphabet1.charAt(indexC));
					}
				else {
					encrypted.setCharAt(i, shiftedUpAlphabet2.charAt(indexC));
					}
				}
				//if chr is not a alphabet reset wordCharNo to 1
				
			}
			
			// for lower case
			else {
				int indexC = lowAlphabet.indexOf(c);
				if (indexC != -1) {
					if (i%2 == 0) {
						encrypted.setCharAt(i, shiftedLowAlphabet1.charAt(indexC));
					}
				else {
					encrypted.setCharAt(i, shiftedLowAlphabet2.charAt(indexC));
					}
				}
					
			}
		}
		return encrypted.toString();
	}
	
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter string to encrypt, and key");
		String inputString = input.nextLine();
		int key1 = input.nextInt();
		int key2 = input.nextInt();
		CaesarCipher caesarCipher = new CaesarCipher();
		System.out.println(caesarCipher.encrypt(inputString, key1, key2));
		System.out.println(caesarCipher.encrypt(caesarCipher.encrypt(inputString, key1, key2), 26-key1, 26-key2));

	}

}
