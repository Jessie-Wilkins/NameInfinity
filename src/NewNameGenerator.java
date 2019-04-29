/*
 Authors: Jessie Wilkins and Jordan Throgmorton 
 Date: April 2019
 Description: This class is used to randomly generate names from a character array 
 	based on the parameters from the fields
 */

import java.util.ArrayList;
import java.util.Random;

public class NewNameGenerator {

	private String gender;
	private int length;
	private String beginningLetter;
	private String lettersUsed;
	private int new_name_length;
	private int [] usedLettersIndices;
	private String new_name;
	private int usedLettersIndex;

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setLength(int length) {
		this.length = length;
		
	}

	public int getLength() {
		return length;
	}

	public void setBeginningLetter(String beginningLetter) {
		this.beginningLetter = beginningLetter.toUpperCase();
	}

	public String getBeginningLetter() {
		return beginningLetter;
	}

	public void setLettersUsed(String lettersUsed) {
		this.lettersUsed = lettersUsed;
		
	}
	
	public String getLettersUsed() {
		return lettersUsed;
	}

	public ArrayList<String> getRandomName() {
		ArrayList<String> name_attr = new ArrayList<String>();
		char [] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y','z'};
		Random rand = new Random();
		iterateThroughLetters(name_attr, letters, rand);
		return name_attr;
	}
	
	public boolean isConsonant(char charAt) {
		if("bcdfghjklmnpqrstvwxyz".contains(String.valueOf(charAt))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isVowel(char charAt) {
		if("aeiou".contains(String.valueOf(charAt))) {
			return true;
		}
		else {
			return false;
		}
	}

	private String iterateThroughLetters(ArrayList<String> name_attr, char[] letters, Random rand) {
		ifLengthIsRandomOptionGenerateRandomLength(rand);
		initializeNewNameLengthNewNameUsedLetters(rand);
		while(new_name_length<getLength()) {
			int rand_index = rand.nextInt(letters.length);
			checkRulesAndGenerateCharacterBasedOnRules(name_attr, letters, rand_index);
		}
		return new_name;
	}

	private void initializeNewNameLengthNewNameUsedLetters(Random rand) {
		new_name_length=0;
		usedLettersIndices = new int[getLettersUsed().length()];
		getRandomLocationsOfLettersUsed(rand, usedLettersIndices);
		new_name = "";
		usedLettersIndex = 0;
	}

	private void checkRulesAndGenerateCharacterBasedOnRules(ArrayList<String> name_attr, char[] letters,
			int rand_index) {
		if(areNotBeginningContiguousConsonants(letters, new_name_length, new_name, rand_index)) {
			
		}
		else if(areNotMoreThanThreeContiguousConsonants(letters, new_name_length, new_name, rand_index)) {
			
		}
		else if(areNotTwoContiguousEndingConsonants(letters, new_name_length, new_name, rand_index)) {
			
		}
		else if(areNotMoreThanThreeContiguousVowels(letters, new_name_length, new_name, rand_index)) {
			
		}
		else if(new_name_length==0) {
			ifBeginningLetterRandomOptionSetBeginningLetterToRandomLetter(letters, rand_index);
			new_name+=getBeginningLetter();
			new_name_length++;
			ifNewNameLengthEqualsPreSetLengthAddNameAttributes(name_attr);
		}
		else if(isMale(new_name_length)) {
			if(isNotAOrI(letters, rand_index)) {
				setToMale(name_attr, letters, rand_index);
			}
		}
		else if(isFemale(new_name_length)) {
			if(isNotO(letters, rand_index)) {
				setToFemale(name_attr, letters, rand_index);
			}
		}
		else if(isRandomGender(new_name_length)) {
			if(isNotO(letters, rand_index)) {
				setToFemale(name_attr, letters, rand_index);
			}
			else if(isNotAOrI(letters, rand_index)) {
				setToMale(name_attr, letters, rand_index);
			}
		}
		else if(isIndexOfLetterUsed(new_name_length, usedLettersIndices, usedLettersIndex)) {
			new_name+=getLettersUsed().charAt(usedLettersIndex);
			usedLettersIndex++;
			new_name_length++;
		}
		else {
			new_name += letters[rand_index];
			new_name_length++;
		}
	}

	private void setToFemale(ArrayList<String> name_attr, char[] letters, int rand_index) {
		new_name +=letters[rand_index];
		new_name_length++;
		String confirmed_gender = "F";
		addAttributes(name_attr, new_name, confirmed_gender);
	}

	private void setToMale(ArrayList<String> name_attr, char[] letters, int rand_index) {
		new_name +=letters[rand_index];
		new_name_length++;
		String confirmed_gender = "M";
		addAttributes(name_attr, new_name, confirmed_gender);
	}

	private void ifNewNameLengthEqualsPreSetLengthAddNameAttributes(ArrayList<String> name_attr) {
		if(new_name_length==getLength()) {
			addAttributes(name_attr, new_name, getGender());
		}
	}

	private void ifBeginningLetterRandomOptionSetBeginningLetterToRandomLetter(char[] letters, int rand_index) {
		if(getBeginningLetter().contentEquals("?")) {
			setBeginningLetter(String.valueOf(letters[rand_index]));
		}
	}

	private void ifLengthIsRandomOptionGenerateRandomLength(Random rand) {
		if(getLength() == -1) {
			setLength(rand.nextInt(19)+1);
		}
	}

	private boolean areNotMoreThanThreeContiguousConsonants(char[] letters, int new_name_length, String new_name,
			int rand_index) {
		return new_name_length > 1 && isConsonant(letters[rand_index])
				&& isConsonant(new_name.toLowerCase().charAt(new_name_length-1))
				&& isConsonant(new_name.toLowerCase().charAt(new_name_length-2));
	}
	
	private boolean areNotMoreThanThreeContiguousVowels(char[] letters, int new_name_length, String new_name,
			int rand_index) {
		return new_name_length > 1 && isVowel(letters[rand_index])
				&& isVowel(new_name.toLowerCase().charAt(new_name_length-1))
				&& isVowel(new_name.toLowerCase().charAt(new_name_length-2));
	}
	
	private boolean areNotTwoContiguousEndingConsonants(char[] letters, int new_name_length, String new_name,
			int rand_index) {
		return getLength()>1&&new_name_length == getLength()-1 && isConsonant(letters[rand_index])
				&& isConsonant(new_name.charAt(new_name_length-1));
	}

	private boolean areNotBeginningContiguousConsonants(char[] letters, int new_name_length, String new_name,
			int rand_index) {
		return new_name_length == 1 && isConsonant(new_name.toLowerCase().charAt(0)) && isConsonant(letters[rand_index]);
	}
	
	private boolean isIndexOfLetterUsed(int new_name_length, int[] usedLettersIndices, int usedLettersIndex) {
		return usedLettersIndex<usedLettersIndices.length&&new_name_length==usedLettersIndices[usedLettersIndex];
	}

	private void getRandomLocationsOfLettersUsed(Random rand, int[] usedLettersIndices) {
		for(int i = 0; i<getLettersUsed().length(); i++) {
			if(getLength() == 1 || getLettersUsed().contentEquals("?")) {
				break;
			}
			usedLettersIndices[i] = rand.nextInt(getLength()-1);
			if(usedLettersIndices[i] == 0) {
				usedLettersIndices[i]++;
			}
		}
	}

	private void addAttributes(ArrayList<String> name_attr, String new_name, String confirmed_gender) {
		name_attr.add(new_name);
		name_attr.add(confirmed_gender);
		name_attr.add(String.valueOf(new_name.length()));
		name_attr.add(String.valueOf(new_name.charAt(0)));
		String lettersFound = findLettersUsed(new_name);
		name_attr.add(lettersFound);
	}

	private String findLettersUsed(String new_name) {
		String lettersFound="";
		for(char letter:getLettersUsed().toCharArray()) {
			if(new_name.contains(String.valueOf(letter))) {
				lettersFound+=letter;
			}
		}
		return lettersFound;
	}
	//Used to determine if the name has feminine features such as A or I
	private boolean isNotAOrI(char[] letters, int rand_index) {
		return letters[rand_index]!='a' && letters[rand_index]!='i';
	}
	//Used to determine if the name has a masculine feature such as O
	private boolean isNotO(char[] letters, int rand_index) {
		return letters[rand_index]!='o';
	}

	private boolean isMale(int new_name_length) {
		return new_name_length == getLength()-1 && getGender().equals("M");
	}
	
	private boolean isRandomGender(int new_name_length) {
		return new_name_length == getLength()-1 && getGender().equals("?");
	}
	
	private boolean isFemale(int new_name_length) {
		return new_name_length == getLength()-1 && getGender().equals("F");
	}
}
