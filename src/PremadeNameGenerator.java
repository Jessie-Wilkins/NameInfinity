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
		
		pickRandomName(names, genders, name_attr);
		
		return name_attr;
	}

	private void pickRandomName(ArrayList<String> names, ArrayList<String> genders, ArrayList<String> name_attr) {
		Random rand = new Random();
		
		boolean incorrect_criteria = true;
		
		while(incorrect_criteria) {
			int index = rand.nextInt(names.size());
			incorrect_criteria = checkIfNameMatchesCriteria(new CheckIfNameMatchesCriteriaParameter(names, genders, name_attr, incorrect_criteria, index));
		}
	}

	private boolean checkIfNameMatchesCriteria(CheckIfNameMatchesCriteriaParameter parameterObject) {
		if(criteriaToMatch(parameterObject)) {
			parameterObject.name_attr.add(parameterObject.names.get(parameterObject.index));
			parameterObject.name_attr.add(parameterObject.genders.get(parameterObject.index));
			parameterObject.name_attr.add(String.valueOf(parameterObject.names.get(parameterObject.index).length()));
			parameterObject.name_attr.add(String.valueOf(parameterObject.names.get(parameterObject.index).charAt(0)));
			parameterObject.name_attr.add(String.valueOf(getLettersUsed()));
			parameterObject.incorrect_criteria = false;
		}
		return parameterObject.incorrect_criteria;
	}

	private boolean criteriaToMatch(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return ifSameGender(parameterObject) && 
				ifSameLength(parameterObject) && 
				ifSameBeginningLetter(parameterObject) &&
				ifSameLettersUsed(parameterObject);
	}

	private boolean ifSameLettersUsed(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return parameterObject.names.get(parameterObject.index).matches(".*["+getLettersUsed()+getBeginningLetter()+"].*");
	}

	private boolean ifSameBeginningLetter(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return parameterObject.names.get(parameterObject.index).startsWith(getBeginningLetter());
	}

	private boolean ifSameLength(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return parameterObject.names.get(parameterObject.index).length() == getLength();
	}

	private boolean ifSameGender(CheckIfNameMatchesCriteriaParameter parameterObject) {
		return parameterObject.genders.get(parameterObject.index).contentEquals(getGender());
	}

}
