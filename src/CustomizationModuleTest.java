import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomizationModuleTest {

	CustomizationModule custMod;
	private String test_input; 
	
	@BeforeEach
	void setUp() throws Exception {
		custMod = new CustomizationModule();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void ReceiveInputForGenerationMethodPremade() {
		SimulateUserInput("P");
		custMod.methodUsedUserInput();
		assertEquals("P", custMod.getMethodUsed());
	}
	
	@Test
	void validateInputForGenerationMethodPremade() {
		SimulateUserInput("R");
		custMod.methodUsedUserInput();
		assertEquals(null, custMod.getMethodUsed());
	}
	
	@Test
	void ReceiveInputForGender() {
		SimulateUserInput("M");
		custMod.genderUserInput();
		assertEquals("M", custMod.getGender());
	}
	
	@Test
	void validateInputForGender() {
		SimulateUserInput("R");
		custMod.genderUserInput();
		assertEquals(null, custMod.getGender());
	}
	
	@Test
	void ReceiveInputForLength() {
		SimulateUserInput("5");
		custMod.lengthUserInput();
		assertEquals(5, custMod.getLength());
	}
	
	@Test
	void validateInputForLength() {
		SimulateUserInput("R");
		custMod.lengthUserInput();
		assertEquals(0, custMod.getLength());
	}
	
	@Test
	void ReceiveInputForBeginningLetter() {
		SimulateUserInput("c");
		custMod.beginningLetterUserInput();
		assertEquals("c", custMod.getBeginningLetter());
	}
	
	@Test
	void validateInputForBeginningLetter() {
		SimulateUserInput("1");
		custMod.beginningLetterUserInput();
		assertEquals(null, custMod.getBeginningLetter());
	}
	
	@Test
	void ReceiveInputForLettersUsed() {
		SimulateUserInput("ctryu");
		custMod.lettersUsedUserInput();
		assertEquals("ctryu", custMod.getLettersUsed());
	}
	
	@Test 
	void validateInputForLettersUsed() {
		SimulateUserInput("!%1");
		custMod.lettersUsedUserInput();
		assertEquals(null, custMod.getLettersUsed());
	}

	private void SimulateUserInput(String user_input) {
		ByteArrayInputStream in = new ByteArrayInputStream(user_input.getBytes());
		System.setIn(in);
	}

}
