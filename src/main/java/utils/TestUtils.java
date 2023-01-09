package utils;

import org.apache.commons.text.CharacterPredicate;
import org.apache.commons.text.RandomStringGenerator;

import static org.apache.commons.text.CharacterPredicates.ASCII_LETTERS;

public class TestUtils {

    public static String randomString(int numberOfCharacters) {
        return randomString(numberOfCharacters, ASCII_LETTERS);
    }

    private static String randomString(int numberCount, CharacterPredicate characterPredicate) {
        var generator = new RandomStringGenerator.Builder().filteredBy(characterPredicate).build();
        return generator.generate(numberCount);
    }

}
