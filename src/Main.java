import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		CustomizationModule cust = new CustomizationModule();
		System.out.println("Please enter gender of name: ");
		cust.genderUserInput();
		System.out.println("Please enter length of name: ");
		cust.lengthUserInput();
		System.out.println("Please enter beginning letter used in name: ");
		cust.beginningLetterUserInput();
		System.out.println("Please enter letters used in name: ");
		cust.lettersUsedUserInput();
		cust.closeInput();
		
		PremadeNameGenerator gen = new PremadeNameGenerator();
		gen.setFile("NameList.txt");
		gen.setGender(cust.getGender());
		gen.setLength(cust.getLength());
		gen.setBeginningLetter(cust.getBeginningLetter());
		gen.setLettersUsed(cust.getLettersUsed());
		
		System.out.println(gen.getRandomName().get(0));

	}

}
