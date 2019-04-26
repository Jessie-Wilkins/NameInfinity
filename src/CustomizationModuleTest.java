import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomizationModuleTest {

	CustomizationModule custMod;
	
	@BeforeEach
	void setUp() throws Exception {
		custMod = new CustomizationModule();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void ReceiveInputForGenerationMethodPremade() {
		custMod.methodUsedUserInput("P");
		assertEquals("P", custMod.getMethodUsed());
	}
	
	@Test
	void validateInputForGenerationMethodPremade() {
		custMod.methodUsedUserInput("R");
		assertEquals(null, custMod.getMethodUsed());
	}
	
	@Test
	void ReceiveInputForGender() {
		custMod.genderUserInput("M");
		assertEquals("M", custMod.getGender());
	}
	
	@Test
	void ReceiveInputForLowerCaseGender() {
		custMod.genderUserInput("m");
		assertEquals("M", custMod.getGender());
	}
	
	@Test
	void validateInputForGender() {
		custMod.genderUserInput("R");
		assertEquals(null, custMod.getGender());
	}
	
	@Test
	void ReceiveInputForLength() {
		custMod.lengthUserInput("5");
		assertEquals(5, custMod.getLength());
	}
	
	@Test
	void validateInputForLength() {
		custMod.lengthUserInput("R");
		assertEquals(0, custMod.getLength());
	}
	
	@Test
	void checkIfLengthGreaterThanZero() {
		custMod.lengthUserInput("-2");
		assertEquals(0, custMod.getLength());
	}
	
	@Test
	void ReceiveInputForBeginningLetter() {
		custMod.beginningLetterUserInput("c");
		assertEquals("c", custMod.getBeginningLetter());
	}
	
	@Test
	void validateInputForBeginningLetter() {
		custMod.beginningLetterUserInput("1");
		assertEquals(null, custMod.getBeginningLetter());
	}
	
	@Test
	void ReceiveInputForLettersUsed() {
		custMod.lettersUsedUserInput("ctryu");
		assertEquals("ctryu", custMod.getLettersUsed());
	}
	
	@Test 
	void validateInputForLettersUsed() {
		custMod.lettersUsedUserInput("!%1");
		assertEquals(null, custMod.getLettersUsed());
	}

}
