public class Syllable {

    // Array of vowels
    char[] vowelLetters = { 'a', 'e', 'i', 'o', 'u', 'y' };

    // Empty constructor in case I need it later.
    public Syllable() {

    }

    /**
     * Counts the number of syllables in a word and returns the count.
     * 
     * @param word The word to be counted
     * @return the syllable count
     */
    public int sylCount(String word) {
        int count = getVowels(word);
        int subtract = getRepeats(word);
        count = count - subtract;
        if (endingTest(word)) {
            count--;
        }
        if (count < 1) {
            return 1;
        } else {
            return count;
        }
    }

    /**
     * Looks at the ending of the word to determine if the ending counts towards the
     * syllable count. le and les should not be preceeded by a vowel to count and
     * words ending in e should not have the last vowel count towards syllable.
     * 
     * @param word the word to be checked
     * @return true if vowel count should be -1 false if not.
     */
    public boolean endingTest(String word) {
        if (word.endsWith("le")) {
            if (isVowel(word.charAt(word.length() - 3))) {
                return true;
            } else {
                return false;
            }
        } else if (word.endsWith("les")) {
            if (isVowel(word.charAt(word.length() - 4))) {
                return true;
            } else {
                return false;
            }
        } else if (word.endsWith("e")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of vowels in a word.
     * 
     * @param word the word to be counted
     * @return the number of vowels in the word
     */
    private int getVowels(String word) {
        int vowels = 0;
        if (word.length() == 1) {
            return 1;
        }
        for (char letter : word.toCharArray()) {
            if (isVowel(letter)) {
                vowels++;
            }
        }
        return vowels;
    }

    /**
     * Looks for runs of vowels in words.
     * 
     * @param word the word to be checked
     * @return the number of vowel runs in the word.
     */
    private int getRepeats(String word) {
        //TODO: Cleanup how repeats are handled words such as eyes and acquainted show up as
        //wrong syllable count.
        if (word.length() == 1) {
            return 0;
        }
        boolean vowelFlag = false;
        boolean vowelRun = false;
        int repeats = 0;
        for (char letter : word.toCharArray()) {
            if (!vowelFlag && isVowel(letter)) {
                vowelFlag = true;
            } else if (vowelFlag && !isVowel(letter)) {
                vowelFlag = false;
                vowelRun = false;
            } else if (vowelFlag && !vowelRun && isVowel(letter)) {
                repeats++;
                vowelRun = true;
            }
        }
        return repeats;
    }

    /**
     * Checks if a letter is a vowel.
     * 
     * @param letter the letter to be checked
     * @return true if it is a vowel false if not.
     */
    private boolean isVowel(char letter) {
        for (char check : vowelLetters) {
            if (letter == check) {
                return true;
            }
        }
        return false;
    }
}
