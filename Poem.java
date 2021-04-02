import java.util.Random;

public class Poem {
    WordStorage store;

    public Poem(WordStorage storeIn) {
        setStorage(storeIn);
    }

    public void setStorage(WordStorage storeIn) {
        store = storeIn;
    }

    public String getPoem() {
        Random rand = new Random();
        int lineCount = rand.nextInt(10) + 10;
        String poem = "";
        for(int i = 0; i < lineCount; i ++) {
            poem += getLine();
            if(i != lineCount - 1) {
                poem += "\n";
            }
        }
        return poem;
    }

    public String getLine() {
        Random rand = new Random();
        int lineCount = rand.nextInt(10) + 4;
        String line = "";
        Word word = store.getRandomWord();
        line += word.getWord();
        for(int i = 0; i < lineCount; i++) {
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
