import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		CustomizationModule cust = new CustomizationModule();
		Scanner user_input = new Scanner(System.in);
		System.out.println("Please enter method for name generation, P for premade or N for new: ");
		cust.methodUsedUserInput(user_input.next());
		System.out.println("Please enter gender of name, F for female or M for male: ");
		cust.genderUserInput(user_input.next());
		System.out.println("Please enter length of name, such as 6: ");
		cust.lengthUserInput(user_input.next());
		System.out.println("Please enter beginning letter used in name, such as a: ");
		cust.beginningLetterUserInput(user_input.next());
		System.out.println("Please enter letters used in name, such as rei: ");
		cust.lettersUsedUserInput(user_input.next());
		user_input.close();
		
		if(ifPremade(cust)) {
			PremadeNameGenerator gen = new PremadeNameGenerator();
			gen.setFile("NameList.txt");
			gen.setGender(cust.getGender());
			gen.setLength(cust.getLength());
			gen.setBeginningLetter(cust.getBeginningLetter());
			gen.setLettersUsed(cust.getLettersUsed());
			for(int i=0; i<3; i++){
				System.out.println(gen.getRandomName().get(0));
			}
		}
			
		else if(ifNew(cust)) {
			NewNameGenerator gen = new NewNameGenerator();
			gen.setGender(cust.getGender());
			gen.setLength(cust.getLength());
			gen.setBeginningLetter(cust.getBeginningLetter());
			gen.setLettersUsed(cust.getLettersUsed());
			for(int i=0; i<3; i++){
				System.out.println(gen.getRandomName().get(0));
			}
		}
		
	}

	private static boolean ifNew(CustomizationModule cust) {
		return cust.getMethodUsed().equals("N");
	}

	private static boolean ifPremade(CustomizationModule cust) {
		return cust.getMethodUsed().equals("P");
	}

}
