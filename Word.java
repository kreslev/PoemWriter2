import java.util.ArrayList;
import java.util.Random;

public class Word {
    // Import Syllable class for use to define syllable count.
    Syllable syllable = new Syllable();

    // Variables for the Word class
    String word;
    int sylCount;
    ArrayList<String> wordsAfter = new ArrayList<String>();

    /**
     * Constructor class takes in String and creates word object arround it.
     * 
     * @param wordIn this is the String that defines the class
     */
    public Word(String wordIn) {
        setWord(wordIn);
        setSylCount(wordIn);
    }

    /**
     * Returns the String the class if built for.
     * 
     * @return
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word for the class.
     * 
     * @param wordIn this is the word object from the constructor.
     */
    public void setWord(String wordIn) {
        word = wordIn;
    }

    /**
     * Returns the Syllable Count for the word object.
     * 
     * @return
     */
    public int getSylCount() {
        return sylCount;
    }

    /**
     * This takes the String the class if built for and runs it through the Syllable
     * class to get the the syllable count.
     * 
     * @param wordIn this is the string from the constructor
     */
    public void setSylCount(String wordIn) {
        sylCount = syllable.sylCount(wordIn);
    }

    /**
     * This adds a word to the word after array.
     * 
     * @param newWord the word to add
     */
    public void addWordAfter(String newWord) {
        if (newWord != "") {
            wordsAfter.add(newWord);
        }
    }

    /**
     * This gets a random word from the word after array or a set string if none
     * exist.
     * 
     * @return five a's or a word from the wordsAfter array
     */
    public String getWordAfter() {
        if (wordsAfter.size() == 0) {
            return null;
        } else if (wordsAfter.size() == 1) {
            return wordsAfter.get(0);
        } else {
            Random rand = new Random();
            return wordsAfter.get(rand.nextInt(wordsAfter.size()));
        }
    }
}
