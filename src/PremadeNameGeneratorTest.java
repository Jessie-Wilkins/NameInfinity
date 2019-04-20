import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PremadeNameGeneratorTest {

	PremadeNameGenerator gen;
	
	@BeforeEach
	void setUp() throws Exception {
		gen = new PremadeNameGenerator();
		fieldSetter();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void canGetGender() {
		assertEquals("M", gen.getGender());
	}
	@Test
	void canGetLength() {
		assertEquals(4, gen.getLength());
	}
	
	@Test
	void canGetBeginningLetter() {
		assertEquals("r", gen.getBeginningLetter());
	}
	
	@Test
	void canGetLettersUsed() {
		assertEquals("rutyfv", gen.getLettersUsed());
	}
	
	@Test
	void hasAccessToFile() {
		assertTrue(gen.fileObjectExists());
	}
	
	@Test
	void canAccessNameFileContent() throws FileNotFoundException {
		ArrayList<String> names = gen.getNamesFromFile();
		assertEquals("Noah", names.get(2));
	}
	
	@Test
	void canGetGenderOfName() throws FileNotFoundException {
		ArrayList<String> gender = gen.getGendersFromFile();
		assertEquals("M", gender.get(2));
	}
	
	@Test
	void canGetRandomNameOfSpecificGender() throws FileNotFoundException {
		ArrayList<String> name_attr = gen.getRandomName();
		assertEquals("M", name_attr.get(1));
		
	}
	
	@Test
	void canGetRandomNameOfSpecificLength() throws FileNotFoundException {
		ArrayList<String> name_attr = gen.getRandomName();
		assertEquals("4", name_attr.get(2));
	}
	
	@Test
	void canGetRandomNameWithSpecificBeginningLetter() throws FileNotFoundException {
		
	}
	
	private void fieldSetter() {
		gen.setFile("NameList.txt");
		gen.setGender("M");
		gen.setLength(4);
		gen.setBeginningLetter("r");
		gen.setLettersUsed("rutyfv");
	}
	
	

}
