import java.util.Scanner;

public class CustomizationModule {
	
	private String MethodUsed;
	private String gender;
	private int length;
	private String beginningLetter;
	private String lettersUsed;
	private Scanner user_input = new Scanner(System.in);
	
	public void setMethodUsed(String MethodUsed) {
		this.MethodUsed = MethodUsed;
	}

	public String getMethodUsed() {
		return MethodUsed;
	}
	
	public void methodUsedUserInput() {
		String test_value = userInputString();
		checkMethodUsed(test_value);		
	}

	private boolean isMethod(String test_value) {
		return test_value.toUpperCase().equals("P") || test_value.toUpperCase().equals("N");
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
	
	public void genderUserInput() {
		String test_value = userInputString();
		checkGenderUsed(test_value);
	}

	private boolean isGender(String test_value) {
		return test_value.toUpperCase().equals("M") || test_value.toUpperCase().equals("F");
	}
	
	public void setLength(int length) {
		this.length = length;
		
	}
	
	public int getLength() {
		return length;
	}
	
	public void lengthUserInput() {
		String test_value = userInputString();
		checkLengthUsed(test_value);
	}
	
	public void setBeginningLetter(String beginningLetter) {
		this.beginningLetter = beginningLetter;
		
	}
	
	public String getBeginningLetter() {
		return beginningLetter;
	}
	
	public void beginningLetterUserInput() {
		String test_value = userInputString();
		checkBeginningLetterUsed(test_value);
		
	}

	private boolean isLetter(String test_value) {
		return Character.isLetter(test_value.charAt(0));
	}
	
	public void setLettersUsed(String lettersUsed) {
		this.lettersUsed = lettersUsed;
	}
	
	public String getLettersUsed() {
		return lettersUsed;
	}
	
	public void lettersUsedUserInput() {
		String test_value = userInputString();
		checkLettersUsed(test_value);
	}

	private void checkLettersUsed(String test_value) {
		if(areLetters(test_value)) {
			setLettersUsed(test_value);
		}
		else {
			System.out.println("Incorrect value: Please input a string with letters (a-z)");
		}
	}

	private boolean areLetters(String test_value) {
		boolean areLettersVar = true;
		for(char i:test_value.toCharArray()) {
			areLettersVar = isNotLetter(areLettersVar, i);
		}
		return areLettersVar;
	}

	private boolean isNotLetter(boolean areLettersVar, char i) {
		if(!Character.isLetter(i)) {
			areLettersVar = false;
		}
		return areLettersVar;
	}
	
	private int convertToInteger(String test_value) {
		return Integer.parseInt(test_value);
	}
	
	private void checkMethodUsed(String test_value) {
		if(isMethod(test_value))
			setMethodUsed(test_value.toUpperCase());
		else
			System.out.println("Incorrect value: Please input either P or N");
	}
	
	private void checkGenderUsed(String test_value) {
		if(isGender(test_value))
			setGender(test_value.toUpperCase());
		else  
			System.out.println("Incorrect value: Please input either M or F");
			
	}
	
	private void checkLengthUsed(String test_value) {
		try {
			setLength(convertToInteger(test_value));
		}
		
		catch(Exception e) {
			System.out.println("Incorrect value: Please input integers with digits 0-9");
		}
	}

	private void checkBeginningLetterUsed(String test_value) {
		if(isLetter(test_value)) {
			setBeginningLetter(test_value);
		}
		else {
			System.out.println("Incorrect value: Please input a letter (a-z)");
		}
	}
	
	private String userInputString() {
		String test_value = user_input.next();
		return test_value;
	}

	public void closeInput() {
		user_input.close();
	}

}
