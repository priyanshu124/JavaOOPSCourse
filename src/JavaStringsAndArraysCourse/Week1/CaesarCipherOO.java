package JavaStringsAndArraysCourse.Week1;

import edu.duke.*; 

public class CaesarCipherOO {	
	private String alphabet;
	private String shiftedAlphabet;
	private String shiftedAlphabet2;
	private int key;
	private int key2;

	public CaesarCipherOO (int key){
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shiftedAlphabet = alphabet.substring(key) +  alphabet.substring(0,key);
		this.key = key;
	}
	public CaesarCipherOO (int key, int key2){
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shiftedAlphabet = alphabet.substring(key) +  alphabet.substring(0,key);
		shiftedAlphabet2 = alphabet.substring(key2) +  alphabet.substring(0,key2);
		this.key = key;
		this.key2 = key2;
	}
	public String encrypt(String input) {
		StringBuilder message = new StringBuilder(input);
		for(int i = 0; i < message.length(); i+=1) {
			Character ch = Character.toLowerCase(message.charAt(i));
			int idx = alphabet.indexOf(ch);
			
			if(idx != -1) {
				if(Character.isUpperCase(message.charAt(i))){
					message.setCharAt(i, Character.toUpperCase(shiftedAlphabet.charAt(idx)));
				}
				else {
					message.setCharAt(i, shiftedAlphabet.charAt(idx));
				}
			}
		}
		return message.toString();
	}
	
	
	public String encryptTwoKey(String input) {
		StringBuilder message = new StringBuilder(input);
		for(int i = 0; i < message.length(); i+=1) {
			Character ch = Character.toLowerCase(message.charAt(i));
			int idx = alphabet.indexOf(ch);
			if(i%2 == 0) {
				if(idx != -1) {
					if(Character.isUpperCase(message.charAt(i))){
						message.setCharAt(i, Character.toUpperCase(shiftedAlphabet.charAt(idx)));
					}
					else {message.setCharAt(i, shiftedAlphabet.charAt(idx));}
				}
			}
			
			else {
				if(idx != -1) {
					if(Character.isUpperCase(message.charAt(i))){
						message.setCharAt(i, Character.toUpperCase(shiftedAlphabet2.charAt(idx)));
					}
					else {message.setCharAt(i, shiftedAlphabet2.charAt(idx));}
				}
			}
		}
		return message.toString();
	}
	
	
	public String decrypt(String input) {
		CaesarCipherOO cc = new CaesarCipherOO(26-key);
		return cc.encrypt(input);
	}
	
	public String decryptTwoKey(String input) {
		CaesarCipherOO cc = new CaesarCipherOO(26-key, 26-key2);
		return cc.encryptTwoKey(input);
	}	
	
	
	public static void main(String[] a) {
		FileResource file = new FileResource("data/CaesarCipherTestFile.txt");
		String input = file.asString();
		CaesarCipherOO cc = new CaesarCipherOO(18);
		
		TestCaesarCipherOO tcc = new TestCaesarCipherOO();
		String encrypted = cc.encrypt(input);
		System.out.println("Original Message: " + input);
		//System.out.println("Encrypted Message: " + encrypted);
		System.out.println("Decrypted Message: " + tcc.breakCaesarCipherTwoKey(encrypted));	
		String firsthalf = tcc.halfOfString(encrypted, 0); 
		String secondhalf = tcc.halfOfString(encrypted, 1); 
		
		System.out.println("Key1: " + tcc.getKey(firsthalf));
		System.out.println("Key2: " + tcc.getKey(secondhalf));
		
		CaesarCipherOO ccTwoKey = new CaesarCipherOO(14, 24);
		//String encryptedTwoKey = ccTwoKey.encryptTwoKey(input);
		String decryptedTwoKey = ccTwoKey.decryptTwoKey(input);
		//System.out.println("Encrypted Message TwoKey: " + encryptedTwoKey);
		//System.out.println("Encrypted Message TwoKey: " + decryptedTwoKey);
		
		
		/*String decryptMessage = tcc.breakCaesarCipher(encrypted);
		System.out.println("Decrypted Message: " + decryptMessage);
		
		System.out.println("Decryption Key is: " + tcc.getKey(input));
		int[] countLetters = tcc.countLetters(encrypted);
		System.out.println("Max idx  is: " + tcc.indexOfMax(countLetters));
		
		for(int i=0; i<countLetters.length; i+=1) {
			System.out.println(cc.alphabet.charAt(i) + " " + i + " = " +  countLetters[i]);			
		}
		*/
	}
}
	
	
	
	
class TestCaesarCipherOO{
	

	 int[] countLetters(String message) {
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
	
	 int indexOfMax(int[] values) {
		int indexOfMax = 0;
		for(int i=1; i < values.length; i+=1 ) {
			if(values[i] > values[indexOfMax]) {indexOfMax=i;}
		}
		return indexOfMax;
	}
	
	
	 String halfOfString(String message, int start) {
		StringBuilder halfString = new StringBuilder("");
		for(int i = start; i < message.length(); i+=2) {
			halfString = halfString.append(message.charAt(i));
		}
		return halfString.toString();
	}
	
	
	 int getKey(String s) {
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
	
	 String breakCaesarCipher(String encrypted) {
		
		int decryptKey = getKey(encrypted);
		CaesarCipherOO cc = new CaesarCipherOO(decryptKey);
		return cc.decrypt(encrypted);
		
	}
	
	 String breakCaesarCipherTwoKey(String encrypted) {
			String firsthalf = halfOfString(encrypted, 0); 
			String secondhalf = halfOfString(encrypted, 1); 
			CaesarCipherOO cc = new CaesarCipherOO(getKey(firsthalf), getKey(secondhalf));
			return cc.decryptTwoKey(encrypted);
			
		}
	
	
}

