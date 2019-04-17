import java.util.Scanner;

public class CustomizationModule {
	
	private String MethodUsed;
	private String gender;
	private int length;
	private String beginningLetter;
	private String lettersUsed;
	
	public void setMethodUsed(String MethodUsed) {
		this.MethodUsed = MethodUsed;
	}

	public String getMethodUsed() {
		return MethodUsed;
	}
	
	public void methodUsedUserInput() {
		Scanner user_input = new Scanner(System.in);
		String test_value = user_input.next();
		if(isMethod(test_value))
			setMethodUsed(test_value);
		else
			System.out.println("Incorrect value: Please input either P or N");
		
		user_input.close();
		
	}

	private boolean isMethod(String test_value) {
		return test_value.equals("P") || test_value.equals("N");
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
	
	public void genderUserInput() {
		Scanner user_input = new Scanner(System.in);
		
		String test_value = user_input.next();
		if(isGender(test_value))
			setGender(test_value);
		else
			System.out.println("Incorrect value: Please input either M or F");
		
		user_input.close();
		
	}

	private boolean isGender(String test_value) {
		return test_value.equals("M") || test_value.equals("F");
	}
	
	public void setLength(int length) {
		this.length = length;
		
	}
	
	public int getLength() {
		return length;
	}
	
	public void lengthUserInput() {
		Scanner user_input = new Scanner(System.in);
		
		String test_value = user_input.next();
		
		try {
			setLength(convertToInteger(test_value));
		}
		
		catch(Exception e) {
			System.out.println("Incorrect value: Please input integers with digits 0-9");
		}
		
		finally {
			user_input.close();
		}
	}
	
	public void setBeginningLetter(String beginningLetter) {
		this.beginningLetter = beginningLetter;
		
	}
	
	public String getBeginningLetter() {
		return beginningLetter;
	}
	
	public void beginningLetterUserInput() {
		Scanner user_input = new Scanner(System.in);
		
		String test_value = user_input.next();
		if(isLetter(test_value)) {
			setBeginningLetter(test_value);
		}
		else {
			System.out.println("Incorrect value: Please input a letter (a-z)");
		}
		
		user_input.close();
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
		Scanner user_input = new Scanner(System.in);
		String test_value = user_input.next();
		
		if(areLetters(test_value)) {
			setLettersUsed(test_value);
		}
		else {
			System.out.println("Incorrect value: Please input a string with letters (a-z)");
		}
		
		
		user_input.close();
		
	}

	private boolean areLetters(String test_value) {
		boolean areLettersVar = true;
		for(char i:test_value.toCharArray()) {
			if(!Character.isLetter(i)) {
				areLettersVar = false;
			}
		}
		return areLettersVar;
	}
	
	private int convertToInteger(String test_value) {
		return Integer.parseInt(test_value);
	}


}
