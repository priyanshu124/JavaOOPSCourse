package JavaStringsAndArraysCourse.Week2;

import java.util.ArrayList;
import edu.duke.*; 

public class CharactersInPlay {
	private ArrayList<String> uniqueChr;
	private ArrayList<Integer> countEachChr;
	
	public CharactersInPlay() {
		uniqueChr = new ArrayList<String>();
		countEachChr = new ArrayList<Integer>();	
	}
	
	public void updateChrList(String name) {
		int idxOfName = uniqueChr.indexOf(name);
		if(idxOfName == -1) {
			uniqueChr.add(name);
			countEachChr.add(1);
		}
		else {
			countEachChr.set(idxOfName, countEachChr.get(idxOfName) + 1);
		}
	}
	
	public void findAllCharacters(String file) {
		uniqueChr.clear();
		countEachChr.clear();
		FileResource fr = new FileResource(file);
		
		for(String line: fr.lines()) {
			int idxOfPeriod = line.trim().indexOf(".");
			if(idxOfPeriod != -1) {
				String characterName = line.trim().substring(0, idxOfPeriod);
				updateChrList(characterName);
			}
		}
	}
	
	public int findIndexOfMax () {
		int idx = countEachChr.get(0);
		for (int i = 0; i < countEachChr.size(); i+=1) {
			if(countEachChr.get(i)>countEachChr.get(idx)) {
				idx = i;
			}
		}
		return idx;
	}
	
	public void printChrWithNumParts(int num1, int num2) {
		
		
		for(String name: uniqueChr) {
			int idxOfName = uniqueChr.indexOf(name);
			if(countEachChr.get(idxOfName)>= num1 & countEachChr.get(idxOfName)<= num2 ) {
				System.out.println(countEachChr.get(uniqueChr.indexOf(name)) + " " + name);
			}
		}	
	}
	
	public static void main (String[] a) {
		CharactersInPlay cp = new CharactersInPlay();
		cp.findAllCharacters("data/WordsFreq.txt");
		cp.printChrWithNumParts(10, 15);
		System.out.println("The word that occurs most often and its count are: " + cp.countEachChr.get(cp.findIndexOfMax()) + " " + cp.uniqueChr.get(cp.findIndexOfMax()));
		
	}
}