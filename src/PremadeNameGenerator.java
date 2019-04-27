import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Random;

public class PremadeNameGenerator {

	private String gender;
	private int length;
	private String beginningLetter;
	private String lettersUsed;
	private String file;

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

	public void setFile(String file) {
		this.file = file;
		
	}

	public boolean fileObjectExists() {
		return true;
	}

	public ArrayList<String> getNamesFromFile() throws FileNotFoundException {
		Scanner scanner = getFileReader();
		ArrayList<String> names = new ArrayList<String>();
		addToList(scanner, names);
		scanner.close();
		return names;
	}
	
	public ArrayList<String> getGendersFromFile() throws FileNotFoundException {
		Scanner scanner = getFileReader();
		ArrayList<String> genders = new ArrayList<String>();
		addGenderToList(scanner, genders);
		return genders;
	}

	private Scanner getFileReader() throws FileNotFoundException {
		File file_object = getFileObject();
		Scanner scanner = new Scanner(file_object);
		return scanner;
	}
	
	private File getFileObject() {
		File file_object = new File(System.getProperty("user.dir")+"/src/"+file);
		return file_object;
	}

	private void addToList(Scanner scanner, ArrayList<String> names) {
		while(scanner.hasNextLine()) {
			names.add(scanner.nextLine().split(",")[0]);
		}
	}
	
	private void addGenderToList(Scanner scanner, ArrayList<String> names) {
		while(scanner.hasNextLine()) {
			names.add(scanner.nextLine().split(",")[1]);
		}
	}

	public ArrayList<String> getRandomName() throws FileNotFoundException {
		ArrayList<String> names = getNamesFromFile();
		ArrayList<String> genders = getGendersFromFile();
		ArrayList<String> name_attr = new ArrayList<String>();
		
		ArrayList<String> filtered_names = selectNamesWithCriteria(names, genders);
		
		ArrayList<String> filtered_genders = selectGendersWithCriteria(genders);
		
		pickRandomName(filtered_names, filtered_genders, name_attr);
		
		return name_attr;
	}

	private ArrayList<String> selectGendersWithCriteria(ArrayList<String> genders) {
		ArrayList<String> filtered_genders = new ArrayList<String>();
		for(int i=1;i<genders.size();i++) {
			if(getGender().contentEquals(genders.get(i))) {
				filtered_genders.add(genders.get(i));
			}
			else if(getGender().contentEquals("?")) {
				filtered_genders.add(genders.get(i));
			}
		}
		return filtered_genders;
	}

	private ArrayList<String> selectNamesWithCriteria(ArrayList<String> names, ArrayList<String> genders) {
		ArrayList<String> filtered_names = new ArrayList<String>();
		for(int i=1;i<names.size();i++) {
			if(criteriaToMatch(new CheckIfNameMatchesCriteriaParameter(names, genders, i))) {
				filtered_names.add(names.get(i));
			}
		}
		return filtered_names;
		
	}

	private void pickRandomName(ArrayList<String> names, ArrayList<String> genders, ArrayList<String> name_attr) {
		Random rand = new Random();
		if(!names.isEmpty()) {
			int index = rand.nextInt(names.size());
			addAttributes(names, genders, name_attr, index);
		}
		else {
			addNothing(name_attr);
		}
	}

	private void addNothing(ArrayList<String> name_attr) {
		for(int i = 0; i<5; i++) {
			name_attr.add("No Name Found With Given Criteria");
		}
		
	}

	private void addAttributes(ArrayList<String> names, ArrayList<String> genders, ArrayList<String> name_attr, int index) {
		name_attr.add(names.get(index));
		name_attr.add(genders.get(index));
		name_attr.add(String.valueOf(names.get(index).length()));
		name_attr.add(String.valueOf(names.get(index).charAt(0)));
		name_attr.add(lettersUsedInRandomName(new CheckIfNameMatchesCriteriaParameter(names, genders, index)));	
		
	}

	private boolean criteriaToMatch(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return ifSameGender(parameterObject) && 
				ifSameLength(parameterObject) && 
				ifSameBeginningLetter(parameterObject) &&
				ifSameLettersUsed(parameterObject);
	}

	private boolean ifSameLettersUsed(CheckIfNameMatchesCriteriaParameter parameterObject) {
		boolean allLettersUsed = true;
		for(char i:getLettersUsed().toCharArray()) {
			if(!parameterObject.names.get(parameterObject.index).contains(String.valueOf(i)) && !getLettersUsed().contentEquals("?")) {
				allLettersUsed = false;
			}
		}
		return allLettersUsed;
	}

	private boolean ifSameBeginningLetter(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return parameterObject.names.get(parameterObject.index).startsWith(getBeginningLetter()) || getBeginningLetter().contentEquals("?");
	}

	private boolean ifSameLength(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return parameterObject.names.get(parameterObject.index).length() == getLength() || getLength() == -1;
	}

	private boolean ifSameGender(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return parameterObject.genders.get(parameterObject.index).contentEquals(getGender()) || getGender().contentEquals("?");
	}
	
	private String lettersUsedInRandomName (CheckIfNameMatchesCriteriaParameter parameterObject) {
		String rand_str = "";
		for(char i:getLettersUsed().toCharArray()) {
			if(parameterObject.names.get(parameterObject.index).contains(String.valueOf(i))) {
				rand_str += i;
			}
		}
		return rand_str;
	}

}
