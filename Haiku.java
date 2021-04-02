public class Haiku {
    WordStorage store;

    /**
     * Constructor sets WordStorage
     * 
     * @param storeIn the WordStorage to set
     */
    public Haiku(WordStorage storeIn) {
        setStorage(storeIn);
    }

    /**
     * Sets the WordStorage. Left public so the Storage can change if need be.
     * 
     * @param storeIn the WordStorage to set
     */
    public void setStorage(WordStorage storeIn) {
        store = storeIn;
    }

    /**
     * Uses the line function to create a haiku. Returns a completed haiku.
     * 
     * @return the haiku
     */
    public String getHaiku() {
        return line(5) + "\n" + line(7) + "\n" + line(5);
    }

    /**
     * Takes in a line syllable count and returns the line
     * 
     * @param syl number of syllables per line
     * @return the completed line
     */
    private String line(int syl) {
        // Variables
        int sylCount = syl + 1;
        int firstNum = syl;
        boolean randTime = true;
        Word nextWord = null;
        Word testWord = null;
        String returnLine = "";

        // Ensures first word isn't past the syllable count.
        while (sylCount > firstNum) {
            nextWord = store.getRandomWord();
            sylCount = nextWord.getSylCount();
        }

        syl -= sylCount;
        returnLine = nextWord.getWord();

        while (syl > 0) {
            // Tries 50 times to pull word from Word's nextWord list before getting a new
            // random word.
            for (int i = 0; i < 50; i++) {
                testWord = store.getSpecificWord(nextWord.getWordAfter());
                if (testWord != null && testWord.getSylCount() <= syl) {
                    syl -= testWord.getSylCount();
                    returnLine += " " + testWord.getWord();
                    randTime = false;
                    nextWord = testWord;
                    i = 51;
                }
                if (testWord == null) {
                    i = 51;
                }
            }
            if (randTime) {
                nextWord = store.getRandomWord();
            } else {
                randTime = true;
            }
        }

        return returnLine;
    }
}
