import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		CustomizationModule cust = new CustomizationModule();
		cust.genderUserInput();
		cust.lengthUserInput();
		cust.beginningLetterUserInput();
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
