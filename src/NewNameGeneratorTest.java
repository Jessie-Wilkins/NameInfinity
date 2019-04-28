import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NewNameGeneratorTest {
	
	NewNameGenerator gen;
	
	@BeforeEach
	void setUp() throws Exception {
		gen = new NewNameGenerator();
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
		assertEquals(6, gen.getLength());
	}
	
	@Test
	void canGetBeginningLetter() {
		assertEquals("r", gen.getBeginningLetter().toLowerCase());
	}
	
	@Test
	void canGetLettersUsed() {
		assertEquals("u", gen.getLettersUsed());
	}
	
	@Test
	void canGetRandomNameOfSpecificGender() throws FileNotFoundException {
		ArrayList<String> name_attr = gen.getRandomName();
		assertEquals("M", name_attr.get(1));
		
	}
	
	@Test
	void canGetRandomNameOfFemaleGender() throws FileNotFoundException {
		gen.setGender("F");
		ArrayList<String> name_attr = gen.getRandomName();
		assertEquals("F", name_attr.get(1));
		
	}
	
	@Test
	void canGetRandomNameWithRandomGenderOption() {
		gen.setGender("?");
		ArrayList<String> name_attr = gen.getRandomName();
		assertNotEquals(0,name_attr.size());
	}
	
	@Test
	void canGetRandomNameOfSpecificLength() throws FileNotFoundException {
		ArrayList<String> name_attr = gen.getRandomName();
		assertEquals("6", name_attr.get(2));
	}
	
	@Test
	void canGetRandomNameWithRandomLengthOption() {
		gen.setLength(-1);
		ArrayList<String> name_attr = gen.getRandomName();
		assertNotEquals(0,name_attr.size());
	}
	
	@Test
	void canGetRandomNameWithSpecificBeginningLetter() throws FileNotFoundException {
		ArrayList<String> name_attr = gen.getRandomName();
		assertEquals("r", name_attr.get(3).toLowerCase());
	}
	
	@Test
	void canGetRandomNameWithRandomBeginningLetterOption() {
		gen.setBeginningLetter("?");
		ArrayList<String> name_attr = gen.getRandomName();
		assertNotEquals("?",name_attr.get(3));
	}
	
	@Test
	void canGetRandomNameWithSpecificLettersUsed() throws FileNotFoundException {
		ArrayList<String> name_attr = gen.getRandomName();
		String user_letters = sortString(gen.getLettersUsed());
		String random_letters = sortString(name_attr.get(4)); 
		assertEquals(user_letters, random_letters);
	}
	
	@Test
	void canGetRandomNameWithRandomLettersUsedOption() {
		gen.setLettersUsed("?");
		ArrayList<String> name_attr = gen.getRandomName();
		assertNotEquals("?",name_attr.get(4));
	}
	
	@Test
	void nameDoesNotHaveTwoContiguousBeginningConsonants() {
		ArrayList<String> name_attr = gen.getRandomName();
		assertNotEquals(gen.isConsonant(name_attr.get(0).toLowerCase().charAt(0)), gen.isConsonant(name_attr.get(0).toLowerCase().charAt(1)));
	}
	
	@Test
	void nameDoesNotHaveTwoContiguousBeginningVowels() {
		ArrayList<String> name_attr = gen.getRandomName();
		assertNotEquals(gen.isVowel(name_attr.get(0).toLowerCase().charAt(0)), gen.isVowel(name_attr.get(0).toLowerCase().charAt(1)));
	}
	
	@Test
	void nameDoesNotHaveMoreThanTwoContiguousConsonants() {
		ArrayList<String> name_attr1 = gen.getRandomName();
		ArrayList<String> name_attr2 = gen.getRandomName();
		ArrayList<String> name_attr3 = gen.getRandomName();
		ArrayList<String> name_attr4 = gen.getRandomName();
		ArrayList<String> name_attr5 = gen.getRandomName();
		ArrayList<String> name_attr6 = gen.getRandomName();
		assertFalse(checkIfThreeContiguousConsonants(name_attr1));
		assertFalse(checkIfThreeContiguousConsonants(name_attr2));
		assertFalse(checkIfThreeContiguousConsonants(name_attr3));
		assertFalse(checkIfThreeContiguousConsonants(name_attr4));
		assertFalse(checkIfThreeContiguousConsonants(name_attr5));
		assertFalse(checkIfThreeContiguousConsonants(name_attr6));
		
	}
	
	@Test
	void nameDoesNotHaveMoreThanTwoContiguousVowels() {
		ArrayList<String> name_attr1 = gen.getRandomName();
		ArrayList<String> name_attr2 = gen.getRandomName();
		ArrayList<String> name_attr3 = gen.getRandomName();
		ArrayList<String> name_attr4 = gen.getRandomName();
		ArrayList<String> name_attr5 = gen.getRandomName();
		ArrayList<String> name_attr6 = gen.getRandomName();
		assertFalse(checkIfThreeContiguousVowels(name_attr1));
		assertFalse(checkIfThreeContiguousVowels(name_attr2));
		assertFalse(checkIfThreeContiguousVowels(name_attr3));
		assertFalse(checkIfThreeContiguousVowels(name_attr4));
		assertFalse(checkIfThreeContiguousVowels(name_attr5));
		assertFalse(checkIfThreeContiguousVowels(name_attr6));
		
	}
	
	@Test
	void nameDoesNotEndWithTwoContiguousConsonants() {
		ArrayList<String> name_attr1 = gen.getRandomName();
		ArrayList<String> name_attr2 = gen.getRandomName();
		ArrayList<String> name_attr3 = gen.getRandomName();
		ArrayList<String> name_attr4 = gen.getRandomName();
		assertFalse(checkIfNameEndsWithTwoContiguousConsonants(name_attr1));
		assertFalse(checkIfNameEndsWithTwoContiguousConsonants(name_attr2));
		assertFalse(checkIfNameEndsWithTwoContiguousConsonants(name_attr3));
		assertFalse(checkIfNameEndsWithTwoContiguousConsonants(name_attr4));
	}
	
	@Test
	void femaleNameCanBeReturned() {
		gen.setGender("F");
		ArrayList<String> name_attr = gen.getRandomName();
		assertFalse(name_attr.isEmpty());
		
	}
	
	@Test
	void oneLetterNameDoesNotHaveLettersUsed() {
		gen.setLength(1);
		ArrayList<String> name_attr = gen.getRandomName();
		assertEquals("", name_attr.get(4));
	}
	
	@Test
	void oneLetterNameUsesBeginningLetter() {
		gen.setLength(1);
		ArrayList<String> name_attr = gen.getRandomName();
		assertEquals(gen.getBeginningLetter(), name_attr.get(3));
	}

	private boolean checkIfNameEndsWithTwoContiguousConsonants(ArrayList<String> name_attr1) {
		return gen.isConsonant(name_attr1.get(0).charAt(name_attr1.get(0).length()-1)) 
				&& gen.isConsonant(name_attr1.get(0).charAt(name_attr1.get(0).length()-2));
	}

	private boolean checkIfThreeContiguousConsonants(ArrayList<String> name_attr1) {
		return gen.isConsonant(name_attr1.get(0).charAt(2))
				&&gen.isConsonant(name_attr1.get(0).charAt(3))
				&&gen.isConsonant(name_attr1.get(0).charAt(4));
	}
	
	private boolean checkIfThreeContiguousVowels(ArrayList<String> name_attr1) {
		return gen.isVowel(name_attr1.get(0).charAt(2))
				&&gen.isVowel(name_attr1.get(0).charAt(3))
				&&gen.isVowel(name_attr1.get(0).charAt(4));
	}

	private String sortString(String unsort_string) {
		char [] chars_used = unsort_string.toCharArray();
		Arrays.sort(chars_used);
		String sorted_string = String.valueOf(chars_used);
		return sorted_string;
	}
	
	private void fieldSetter() {
		gen.setGender("M");
		gen.setLength(6);
		gen.setBeginningLetter("r");
		gen.setLettersUsed("u");
	}
	

}
