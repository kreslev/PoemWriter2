import java.util.Random;

public class Poem {
    //Where the class pulls words from
    WordStorage store;

    /**
     * Constructor: takes in WordStorage and sets it for the class.
     * @param storeIn The WordStorage to be set.
     */
    public Poem(WordStorage storeIn) {
        setStorage(storeIn);
    }

    /**
     * Sets the WordStorage.
     * @param storeIn the WordStorage to be set.
     */
    public void setStorage(WordStorage storeIn) {
        store = storeIn;
    }

    /**
     * Returns a String that is 10-20 lines long each line being 5-15 words each.
     * @return String that is the poem.
     */
    public String getPoem() {
        Random rand = new Random();
        int lineCount = rand.nextInt(10) + 10;
        String poem = "";
        for (int i = 0; i < lineCount; i++) {
            poem += getLine();
            if (i != lineCount - 1) {
                poem += "\n";
            }
        }
        return poem;
    }

    /**
     * Returns a line of text in String form that is 5-15 words long.
     * @return String that is the line.
     */
    public String getLine() {
        Random rand = new Random();
        int lineCount = rand.nextInt(10) + 4;
        String line = "";
        Word word = store.getRandomWord();
        line += word.getWord();
        for (int i = 0; i < lineCount; i++) {
            String nextWord = word.getWordAfter();
            if (nextWord == null) {
                word = store.getRandomWord();
                line += " " + word.getWord();
            } else {
                word = store.getSpecificWord(nextWord);
                line += " " + word.getWord();
            }
        }
        return line;
    }
}
