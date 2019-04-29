/*
 Authors: Jessie Wilkins and Jordan Throgmorton 
 Date: April 2019
 Description: This class is used to receive the name parameters from the user
 */

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
	
	public void methodUsedUserInput(String input_string) {
		String test_value = input_string;
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
	
	public void genderUserInput(String input_string) {
		String test_value = input_string;
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
	
	public void lengthUserInput(String input_string) {
		String test_value = input_string;
		checkLengthUsed(test_value);
	}
	
	public void setBeginningLetter(String beginningLetter) {
		this.beginningLetter = beginningLetter;	
	}
	
	public String getBeginningLetter() {
		return beginningLetter;
	}
	
	public void beginningLetterUserInput(String input_string) {
		String test_value = input_string;
		checkBeginningLetterUsed(test_value);
	}

	private boolean isLetter(String test_value) {
		return Character.isLetter(test_value.charAt(0))&&test_value.length()==1;
	}
	
	public void setLettersUsed(String lettersUsed) {
		this.lettersUsed = lettersUsed;
	}
	
	public String getLettersUsed() {
		return lettersUsed;
	}
	
	public void lettersUsedUserInput(String input_string) {
		String test_value = input_string;
		checkLettersUsed(test_value);
	}

	private void checkLettersUsed(String test_value) {
		//Checks if the letters are letters or if the random option has been chosen
		if(areLetters(test_value) || isRandomOption(test_value)) {
			setLettersUsed(test_value.toLowerCase());
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
		//Checks if this is a known method or is a random option
		if(isMethod(test_value) || isRandomOption(test_value))
			setMethodUsed(test_value.toUpperCase());
		else
			System.out.println("Incorrect value: Please input either P or N");
	}
	
	private void checkGenderUsed(String test_value) {
		//Checks if this is a known gender or is a ranodm option
		if(isGender(test_value) || isRandomOption(test_value))
			setGender(test_value.toUpperCase());
		else  
			System.out.println("Incorrect value: Please input either M or F");
	}
	
	private void checkLengthUsed(String test_value) {
		//Checks if the length is a number and is above 0
		try {
			ifRandomOptionSetLengthToNegativeOne(test_value);
			if(!isRandomOption(test_value)) {
				ifNumberGreaterThanZeroSetLengthElsePrintErrorStatement(test_value);
			}
		}
		catch(Exception e) {
			System.out.println("Incorrect value: Please input integers with digits 0-9 and size greater than 0");
		}
	}
	
	private boolean isRandomOption(String test_value) {
		return test_value.contentEquals("?");
	}

	private void ifNumberGreaterThanZeroSetLengthElsePrintErrorStatement(String test_value) {
		int test_number = convertToInteger(test_value);
		if(test_number > 0) {
			setLength(test_number);
		}
		else{
			System.out.println("Incorrect value: Please input integers with digits 0-9 and size greater than 0");
		}
	}
	
	private void ifRandomOptionSetLengthToNegativeOne(String test_value) {
		if(isRandomOption(test_value)) {
			setLength(-1);
		}
	}

	private void checkBeginningLetterUsed(String test_value) {
		if(isLetter(test_value) || test_value.equals("?")) {
			setBeginningLetter(test_value);
		}
		else {
			System.out.println("Incorrect value: Please input a single letter (a-z)");
		}
	}

	public void closeInput() {
		user_input.close();
	}
}
