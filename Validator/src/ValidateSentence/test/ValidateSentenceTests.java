package ValidateSentence.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ValidateSentence.ValidateSentence;

/** Unit tests for ValidateSentence
 * @author Philip Wilson
 * @version 1.0
 * @since 1.0
 */
public class ValidateSentenceTests {
    
    ValidateSentence vs;

    // Thesse sentences are valid and meet the rules
    String[] valid_sentences = new String[] {
        "The quick brown fox said \"hello Mr lazy dog\".", 
        "The quick brown fox said hello Mr lazy dog.", 
        "One lazy dog is too few, 13 is too many.", 
        "One lazy dog is too few, thirteen is too many.", 
        "How many \"lazy dogs\" are there?"
    };

    // Invalid capitalisation
    String[] invalid_capitals = new String[] {
        "the quick brown fox said \"hello Mr. lazy dog\".",
        "\"The quick brown fox said \"hello Mr lazy dog.\"", 
        ",The quick brown fox said \"hello Mr lazy dog.\""
    };

    // Invalid quotes
    String[] invalid_quotes = new String[] {
        "\"The quick brown fox said \"hello Mr lazy dog.\"", 
        "the quick brown fox said hello Mr lazy dog.\""
    };

    // Invalid termination character
    String[] invalid_termination = new String[] {
        "The quick brown fox said \"hello Mr. lazy dog\"#",
        "the quick brown fox said \"hello Mr lazy dog\",",
        "\"The quick brown fox said \"hello Mr lazy dog.\""
    }; 

    // Invalid periods
    String[] invalid_periods = new String[] {
        "The quick brown fox said \"hello Mr. lazy dog\".",
        "the quick b.rown fox said \"hello Mr lazy dog\".",
        "\"The quick brown fox said \"hello Mr. lazy dog\""
    };

    // Invalid number representation
    String[] invalid_numbers = new String[] {
        "One lazy dog is too few, 9 is too many.",
        "Are there 11, 12, or 13 lazy dogs?",
        "There is no punctuation in this sentence but 6 is wrong format but 66 is right!"
    };

    // Set up an instance of the class to be tested
    @Before
    public void setUp() {
        vs = new ValidateSentence();
    }

    @Test
    public void testCapitals() {
        System.out.println("Capitals valid tests start");
        for (int i = 0; i < valid_sentences.length; i++) {
            assertTrue("Capitals test failed for " + valid_sentences[i], vs.isFirstCharCapital(valid_sentences[i]));
        }
        System.out.println("Capitals valid tests complete");

        System.out.println("Capitals invalid tests start");
        for (int i = 0; i < invalid_capitals.length; i++) {
            assertFalse("Capitals test failed for " + invalid_capitals[i], vs.isFirstCharCapital(invalid_capitals[i]));
        }
        System.out.println("Capitals invalid tests complete");
    }

    @Test
    public void testQuotes() {
        System.out.println("Quotes valid tests start");
        for (int i = 0; i < valid_sentences.length; i++) {
            assertTrue("Quotes test failed for " + valid_sentences[i], vs.checkQuotes(valid_sentences[i]));
        }
        System.out.println("Quotes valid tests complete");

        System.out.println("Quotes invalid tests start");
        for (int i = 0; i < invalid_quotes.length; i++) {
            assertFalse("Quotes test failed for " + invalid_quotes[i], vs.checkQuotes(invalid_quotes[i]));
        }
        System.out.println("Quotes invalid tests complete");
    }

    @Test
    public void testSentenceTermination() {
        System.out.println("Sentence termination valid tests start");
        for (int i = 0; i < valid_sentences.length; i++) {
            assertTrue("Sentence termination test failed for " + valid_sentences[i], vs.checkLastChar(valid_sentences[i]));
        }
        System.out.println("Sentence termination valid tests complete");

        System.out.println("Sentence termination invalid tests start");
        for (int i = 0; i < invalid_termination.length; i++) {
            assertFalse("Sentence termination test failed for " + invalid_termination[i], vs.checkLastChar(invalid_termination[i]));
        }
        System.out.println("Sentence termination invalid tests complete");
    }

    @Test
    public void testPeriods() {
        System.out.println("Periods valid tests start");
        for (int i = 0; i < valid_sentences.length; i++) {
            assertTrue("Periods test failed for " + valid_sentences[i], vs.checkForPeriods(valid_sentences[i]));
        }
        System.out.println("Periods valid tests complete");

        System.out.println("Periods invalid tests start");
        for (int i = 0; i < invalid_periods.length; i++) {
            assertFalse("Periods test failed for " + invalid_periods[i], vs.checkForPeriods(invalid_periods[i]));
        }
        System.out.println("Periods invalid tests complete");
    }

    @Test
    public void testNumbers() {
        System.out.println("Numbers valid tests start");
        for (int i = 0; i < valid_sentences.length; i++) {
            assertTrue("Numbers test failed for " + valid_sentences[i], vs.checkNumbers(valid_sentences[i]));
        }
        System.out.println("Numbers valid tests complete");

        System.out.println("Numbers invalid tests start");
        for (int i = 0; i < invalid_numbers.length; i++) {
            assertFalse("Numbers test failed for " + invalid_numbers[i], vs.checkNumbers(invalid_numbers[i]));
        }
        System.out.println("Numbers invalid tests complete");
    }

}
