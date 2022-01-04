package ValidateSentence;

/** Validates a sentence
 * @author Philip Wilson
 * @version 1.0
 * @since 1.0
 */
public class ValidateSentence {

    private static int MIN_NAKED_NUMBER = 13;

    /** Checks that first character is a Capital
     * @param sentence  string containing sentence to be validated
     * @return          <code>true</code> if first char is capital letter
     *                  <code>false</code> first char is not capital letter
     */
    public boolean isFirstCharCapital(String sentence) {
        return Character.isLetter(sentence.charAt(0))
            && sentence.charAt(0) == sentence.toUpperCase().charAt(0);
    }

    /** Counts a specified charater
     * @param sentence  string containing sentence to be validated
     * @param character the character to be counted
     * @return          integer representing the number of the specified char is present
     */
    public static int countChar(String sentence, Character countChar) {
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (c == countChar) {
            count++;
            }
        }
        return count;
    }

    /** Checks the quote count is even
     * @param sentence  string containing sentence to be validated
     * @return          <code>true</code> if even number of quotes
     *                  <code>false</code> if odd number of quotes
     */
    public boolean checkQuotes(String sentence) {
        return countChar(sentence, '"') % 2 == 0;
    }

    /** Checks the last character is '!', '?' or '.'
     * @param sentence  string containing sentence to be validated
     * @return          <code>true</code> if valid character is final character
     *                  <code>false</code> if invalid character is final character
     */
    public boolean checkLastChar(String sentence) {
        char lastChar = sentence.charAt(sentence.length() - 1);
        
        return lastChar == '.' || lastChar == '?' || lastChar == '!';
    }

    /** Checks that numbers < 13 are represented alphabetically (e.g. 1 is one in the sentence)
     * @param sentence  string containing sentence to be validated
     * @return          <code>true</code> if all represented numbers are numerical if < 13
     *                  <code>false</code> if number < 13 is not alphabetically represented
     */
    public boolean checkNumbers(String sentence) {
        // Remove non numbers
        String strTmp = sentence.replaceAll("[^-?0-9]+", " ");
        strTmp = strTmp.trim();
    
        if (strTmp.isEmpty()) {
            return true;
        }
    
        int lowestNumber = MIN_NAKED_NUMBER;
        for (String number : strTmp.split(" ")) {
            // Ensure the value is an actual number
            if (!number.matches("[-+]?\\d*\\.?\\d+")) continue;
            lowestNumber = Math.min(lowestNumber, Integer.parseInt(number));
        }
    
        return lowestNumber >= MIN_NAKED_NUMBER;
    }

    /** Checks that only one period is present and if so it is the final character in the sentence
     * @param sentence  string containing sentence to be validated
     * @return          <code>true</code> if one period is present and is the final character
     *                  <code>false</code> if > 1 periods are present or only one is but not final character
     */
    public boolean checkForPeriods(String sentence) {
        if (countChar(sentence, '.') > 1 || (countChar(sentence, '.') == 1 && sentence.charAt(sentence.length() - 1) != '.')) {
            return false;
        }
        return true;

    }

    /** Validates the sentence according to rules:
     * String starts with a capital letter.
	 * String has an even number of quotation marks.
	 * String ends with one of the following sentence termination characters: ".", "?", "!"
	 * String has no period characters other than the last character.
	 * Numbers below 13 are spelled out (”one”, “two”, "three”, etc…).
     * @param sentence  string containing sentence to be validated
     * @return          <code>true</code> if valid
     *                  <code>false</code> if not valid
     */
    public boolean validate(String sentence) {
        return isFirstCharCapital(sentence) &&
                checkQuotes(sentence) &&
                checkLastChar(sentence) &&
                checkNumbers(sentence) &&
                checkForPeriods(sentence);
    }
}