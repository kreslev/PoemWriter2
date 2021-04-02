import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    
    /**
     * Empty constructor in case it is needed later.
     */
    public Reader(){

    }

    /**
     * This takes in a file path of a txt file and returns a list of all the words in said file.
     * @param filePath the file path for the txt file
     * @return the list of words
     */
    public ArrayList<String> readFile(String filePath) {
        ArrayList<String> toReturn = new ArrayList<String>();
        
        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
            String lineText = null;
         
            while ((lineText = lineReader.readLine()) != null) {
                String[] toProcess = lineText.split(" ");
                for (String word : toProcess) {
                    word = wordProcessor(word);
                    if(isWord(word)) {
                        toReturn.add(word);
                    }
                }
            }
         
            lineReader.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return toReturn;
    }

    /**
     * This takes a string and trims non letters from the beginning and end and sets them to lower case.
     * @param wordIn the string to process
     * @return the formatted string
     */
     String wordProcessor(String wordIn) {
        if (wordIn.equals("") || wordIn.equals(" ")) {
            return "";
        } else if (wordIn.length() == 1) {
            return wordIn;
        }
        wordIn = wordIn.toLowerCase().trim();
        if(!Character.isLetter(wordIn.charAt(wordIn.length() - 1))) {
            wordIn = wordIn.substring(0, wordIn.length() - 1);
        }
        if(!Character.isLetter(wordIn.charAt(0))) {
           wordIn = wordIn.substring(1);
        }
        return wordIn;
    }

    /**
     * Checks the string to see if it meets the needed formatting
     * @param wordIn the string to check
     * @return true if the format is working. false if not.
     */
    private boolean isWord(String wordIn) {
        if(wordIn == "" || wordIn == " ") {
            return false;
        }
        if (wordIn.length() == 1) {
            if (wordIn.equals("a") || wordIn.equals("i")) {
                return true;
            } else {
                return false;
            }
        }
        for (Character letter : wordIn.toCharArray()) {
            if(Character.isDigit(letter)) {
                return false;
            } else if (!Character.isLetter(letter) && letter != '-') {
                return false;
            }
        }
        return true;
    }
}