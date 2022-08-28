package Practice;

import java.io.*;
import edu.duke.*; 


public class WordLengths {
	
	public int[] wordLengthCount( int[] counts) {
		FileResource resource = new FileResource("data/CaesarCipherTestFile.txt");
		String alph = "abcdefghijklmnopqrstuvwxyz";
		
		for (String word: resource.words()) {
			int wordLength = word.length();
			
			if(Character.isLetter(word.charAt(wordLength-1))& Character.isLetter(word.charAt(0))) {
				counts[wordLength] += 1;
			
			}
			else if (Character.isLetter(word.charAt(wordLength-1))& !Character.isLetter(word.charAt(0))) {
				if(wordLength > 1){
					counts[wordLength-1] += 1;
				}
			}
			else if (!Character.isLetter(word.charAt(wordLength-1))& Character.isLetter(word.charAt(0))) {
				if(wordLength > 1){
					counts[wordLength-1] += 1;
				}
			}
			else if (!Character.isLetter(word.charAt(wordLength-1))& !Character.isLetter(word.charAt(0))) {
				if(wordLength > 2){
					counts[wordLength-2] += 1;
				}
			}
		}
		return counts;
	}
	
	public int indexOfMax(int[] values) {
		int indexOfMax = values[0];
		for(int i=1; i < values.length; i+=1 ) {
			if(values[i] > values[indexOfMax]) {indexOfMax=i;}
		}
		return indexOfMax;
	}
	
    public static void main (String[] a)    {
    	int[] counts = new int[20];
    	WordLengths wordlength= new WordLengths();
    	counts=wordlength.wordLengthCount(counts);
    	for (int k = 1; k < counts.length; k+=1) {
    		System.out.println("word length "+ k + " = " + counts[k]);
    	}
    	//int indexOfMax = ;
    	System.out.println("Word length that occured max times"+  " = " + wordlength.indexOfMax(counts));
    	
    }
	
}