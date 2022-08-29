package JavaStringsAndArraysCourse.Week2;


import java.util.ArrayList;
import edu.duke.*; 

public class WordsFreq {
	private ArrayList<String> uniqueWords;
	private ArrayList<Integer> freqs;
	
	public WordsFreq() {
		uniqueWords = new ArrayList<String>();
		freqs = new ArrayList<Integer>();	
	}
	public void findUnique(String file) {
		uniqueWords.clear();
		freqs.clear();
		FileResource fr = new FileResource(file);
		
		for(String word: fr.words()) {
			int idx = uniqueWords.indexOf(word.toLowerCase());
			if(idx == -1) {
				uniqueWords.add(word.trim().toLowerCase());
				freqs.add(1);
			}
			else {
				freqs.set(idx, freqs.get(idx)+ 1);
			}
		}
	}
	
	public int findIndexOfMax () {
		int idx = freqs.get(0);
		for (int i = 0; i < uniqueWords.size(); i+=1) {
			if(freqs.get(i)>freqs.get(idx)) {
				idx = i;
			}
		}
		return idx;
	}
	
	public static void main(String[] a) {
		WordsFreq wf = new WordsFreq();
		wf.findUnique("data/WordsFreq.txt");
		for(String word: wf.uniqueWords) {
			
			System.out.println(wf.freqs.get(wf.uniqueWords.indexOf(word)) + " " + word);
			
		}
		System.out.println("No of Unique Words = " + wf.uniqueWords.size());
		System.out.println("The word that occurs most often and its count are: " + wf.freqs.get(wf.findIndexOfMax()) + " " + wf.uniqueWords.get(wf.findIndexOfMax()));
	}
	
}
