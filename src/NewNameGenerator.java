import java.util.ArrayList;
import java.util.Random;

public class NewNameGenerator {

	private String gender;
	private int length;
	private String beginningLetter;
	private String lettersUsed;

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
		int new_name_length=0;
		
		int [] usedLettersIndices = new int[getLettersUsed().length()];
		
		getRandomLocationsOfLettersUsed(rand, usedLettersIndices);
		
		String new_name = "";
		
		int usedLettersIndex = 0;
		
		while(new_name_length<getLength()) {
			int rand_index = rand.nextInt(letters.length);
			if(areNotBeginningContiguousConsonants(letters, new_name_length, new_name, rand_index)) {
				
			}
			else if(areNotMoreThanThreeContiguousConsonants(letters, new_name_length, new_name, rand_index)) {
				
			}
			else if(areNotTwoContiguousEndingConsonants(letters, new_name_length, new_name, rand_index)) {
				
			}
			else if(areNotMoreThanThreeContiguousVowels(letters, new_name_length, new_name, rand_index)) {
				
			}
			else if(isMale(new_name_length)) {
				if(isNotAOrI(letters, rand_index)) {
					new_name +=letters[rand_index];
					new_name_length++;
					addAttributes(name_attr, new_name);
				}
			}
			else if(isFemale(new_name_length)) {
				new_name +=letters[rand_index];
				new_name_length++;
				addAttributes(name_attr, new_name);
			}
			else if(isIndexOfLetterUsed(new_name_length, usedLettersIndices, usedLettersIndex)) {
				new_name+=getLettersUsed().charAt(usedLettersIndex);
				usedLettersIndex++;
				new_name_length++;
			}
			else if(new_name_length==0) {
				new_name+=getBeginningLetter();
				new_name_length++;
			}
			else {
				new_name += letters[rand_index];
				new_name_length++;
				System.out.println("Uses the else!");
			}
			
		}
		return new_name;
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
		return new_name_length == getLength()-1 && isConsonant(letters[rand_index])
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
			usedLettersIndices[i] = rand.nextInt(getLength()-1);
			if(usedLettersIndices[i] == 0) {
				usedLettersIndices[i]++;
			}
		}
	}

	private void addAttributes(ArrayList<String> name_attr, String new_name) {
		name_attr.add(new_name);
		name_attr.add("M");
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

	private boolean isNotAOrI(char[] letters, int rand_index) {
		return letters[rand_index]!='a' && letters[rand_index]!='i';
	}

	private boolean isMale(int new_name_length) {
		return new_name_length == getLength()-1 && getGender().equals("M");
	}
	
	private boolean isFemale(int new_name_length) {
		return new_name_length == getLength()-1 && getGender().equals("F");
	}

}
