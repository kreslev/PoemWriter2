import java.util.ArrayList;

public class Processor {
    Reader reader = new Reader();
    ArrayList<String> words = new ArrayList<String>();

    public Processor(String filePath) {
        setArray(filePath);
    }

    public void setArray(String filePath) {
        words = reader.readFile(filePath);
    }

    public WordStorage createStorage() {
        WordStorage toReturn = new WordStorage();

        for(int i = 0; i < words.size(); i++) {
            if(i == words.size() - 1) {
                toReturn.inputWord(words.get(i), "");
            } else {
                toReturn.inputWord(words.get(i), words.get(i + 1));
            }
        }

        return toReturn;
    }
}
