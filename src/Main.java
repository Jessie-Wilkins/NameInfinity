import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		CustomizationModule cust = new CustomizationModule();
		getUserInput(cust);
		
		if(ifPremade(cust)) {
			PremadeNameGenerator gen = setPremadeNameGenerator(cust);
			outputPremadeName(gen);
		}
			
		else if(ifNew(cust)) {
			NewNameGenerator gen = setNewNameGenerator(cust);
			outputNewName(gen);
		}
		
		else if(ifRandomGen(cust)) {
			Random rand = new Random();
			if(rand.nextBoolean()) {
				NewNameGenerator gen = setNewNameGenerator(cust);
				outputNewName(gen);
			}
			else {
				PremadeNameGenerator gen = setPremadeNameGenerator(cust);
				outputPremadeName(gen);
			}
			
		}
		
	}

	private static boolean ifRandomGen(CustomizationModule cust) {
		return cust.getMethodUsed().equals("?");
	}

	private static void outputNewName(NewNameGenerator gen) {
		for(int i=0; i<3; i++){
			System.out.println(gen.getRandomName().get(0));
		}
	}

	private static void outputPremadeName(PremadeNameGenerator gen) throws FileNotFoundException {
		for(int i=0; i<3; i++){
			System.out.println(gen.getRandomName().get(0));
		}
	}

	private static NewNameGenerator setNewNameGenerator(CustomizationModule cust) {
		NewNameGenerator gen = new NewNameGenerator();
		gen.setGender(cust.getGender());
		gen.setLength(cust.getLength());
		gen.setBeginningLetter(cust.getBeginningLetter());
		gen.setLettersUsed(cust.getLettersUsed());
		return gen;
	}

	private static PremadeNameGenerator setPremadeNameGenerator(CustomizationModule cust) {
		PremadeNameGenerator gen = new PremadeNameGenerator();
		gen.setFile("NameList.txt");
		gen.setGender(cust.getGender());
		gen.setLength(cust.getLength());
		gen.setBeginningLetter(cust.getBeginningLetter());
		gen.setLettersUsed(cust.getLettersUsed());
		return gen;
	}

	private static void getUserInput(CustomizationModule cust) {
		Scanner user_input = new Scanner(System.in);
		getInputForMethodUsed(cust, user_input);
		getInputForGenderUsed(cust, user_input);
		getInputLengthUsed(cust, user_input);
		getInputForBeginningLetter(cust, user_input);
		getInputForLettersUsed(cust, user_input);
		user_input.close();
	}

	private static void getInputForLettersUsed(CustomizationModule cust, Scanner user_input) {
		System.out.println("Please enter letters used in name, such as rei: ");
		while(cust.getLettersUsed() == null) {
			cust.lettersUsedUserInput(user_input.next());
		}
	}

	private static void getInputForBeginningLetter(CustomizationModule cust, Scanner user_input) {
		System.out.println("Please enter beginning letter used in name, such as a: ");
		while(cust.getBeginningLetter() == null) {
			cust.beginningLetterUserInput(user_input.next());
		}
	}

	private static void getInputLengthUsed(CustomizationModule cust, Scanner user_input) {
		System.out.println("Please enter length of name, such as 6: ");
		while(cust.getLength() == 0) {
			cust.lengthUserInput(user_input.next());
		}
	}

	private static void getInputForGenderUsed(CustomizationModule cust, Scanner user_input) {
		System.out.println("Please enter gender of name, F for female or M for male: ");
		while(cust.getGender() == null) {
			cust.genderUserInput(user_input.next());
		}
	}

	private static void getInputForMethodUsed(CustomizationModule cust, Scanner user_input) {
		System.out.println("Please enter method for name generation, P for premade or N for new: ");
		while(cust.getMethodUsed() == null) {
			cust.methodUsedUserInput(user_input.next());
		}
	}

	private static boolean ifNew(CustomizationModule cust) {
		return cust.getMethodUsed().equals("N");
	}

	private static boolean ifPremade(CustomizationModule cust) {
		return cust.getMethodUsed().equals("P");
	}

}
