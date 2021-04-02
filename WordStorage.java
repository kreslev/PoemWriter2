import java.util.ArrayList;
import java.util.Random;

public class WordStorage {

    // ArrayLists for each letter of the alphabet.
    private ArrayList<Word> aList = new ArrayList<>();
    private ArrayList<Word> bList = new ArrayList<>();
    private ArrayList<Word> cList = new ArrayList<>();
    private ArrayList<Word> dList = new ArrayList<>();
    private ArrayList<Word> eList = new ArrayList<>();
    private ArrayList<Word> fList = new ArrayList<>();
    private ArrayList<Word> gList = new ArrayList<>();
    private ArrayList<Word> hList = new ArrayList<>();
    private ArrayList<Word> iList = new ArrayList<>();
    private ArrayList<Word> jList = new ArrayList<>();
    private ArrayList<Word> kList = new ArrayList<>();
    private ArrayList<Word> lList = new ArrayList<>();
    private ArrayList<Word> mList = new ArrayList<>();
    private ArrayList<Word> nList = new ArrayList<>();
    private ArrayList<Word> oList = new ArrayList<>();
    private ArrayList<Word> pList = new ArrayList<>();
    private ArrayList<Word> qList = new ArrayList<>();
    private ArrayList<Word> rList = new ArrayList<>();
    private ArrayList<Word> sList = new ArrayList<>();
    private ArrayList<Word> tList = new ArrayList<>();
    private ArrayList<Word> uList = new ArrayList<>();
    private ArrayList<Word> vList = new ArrayList<>();
    private ArrayList<Word> wList = new ArrayList<>();
    private ArrayList<Word> xList = new ArrayList<>();
    private ArrayList<Word> yList = new ArrayList<>();
    private ArrayList<Word> zList = new ArrayList<>();

    /**
     * Empty constructor in case I need it later.
     */
    public WordStorage() {

    }

    public Word getRandomWord() {
        String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z" };
        Random rand = new Random();
        ArrayList<Word> wordGetter;
        do {
            wordGetter = getList(alphabet[rand.nextInt(alphabet.length)]);
        } while (wordGetter.size() == 0);
        return wordGetter.get(rand.nextInt(wordGetter.size()));
    }

    public Word getSpecificWord(String wordIn) {
        return getMatch(wordIn, getList(wordIn));
    }

    /**
     * Takes the wordIn and the next word and tries to create a Word Object and
     * store it.
     * 
     * @param wordIn     String of the word to be processed
     * @param wordInNext next word in the sentence
     */
    public void createWord(String wordIn, String wordInNext) {
        wordIn = wordIn.trim().toLowerCase();
        wordInNext = wordInNext.trim().toLowerCase();
        if (checkWord(wordIn)) {
            processWord(wordIn, wordInNext);
        }
    }

    /**
     * Checks to see if the next word is valid and then searches for the word in
     * storage. If not found a new word object is created and stored.
     * 
     * @param wordIn
     * @param wordInNext
     */
    private void processWord(String wordIn, String wordInNext) {
        if (!checkWord(wordInNext)) {
            wordInNext = "";
        }
        Word match = getMatch(wordIn, getList(wordIn));
        if (match == null) {
            Word newWord = new Word(wordIn);
            if (wordInNext != "") {
                newWord.addWordAfter(wordInNext);
            }
            getList(newWord.getWord()).add(newWord);
        }
    }

    /**
     * Checks to see if the word is a valid word. If so it returns true. If not it
     * returns false.
     * 
     * @param wordIn
     * @return boolean from the check
     */
    private boolean checkWord(String wordIn) {
        if (wordIn == null || wordIn == "" || wordIn == " ") {
            return false;
        } else if (!Character.isLetter(wordIn.charAt(0))) {
            return false;
        } else {
            for (Character letter : wordIn.toCharArray()) {
                if (!Character.isLetter(letter) || letter == '-') {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Looks through storage to see if word alread is in database.
     * 
     * @param wordIn The word to be checked
     * @param list   The list to be looked through
     * @return The word if a listing is found. Null if not found.
     */
    private Word getMatch(String wordIn, ArrayList<Word> list) {
        for (Word word : list) {
            if (word.getWord().equals(wordIn)) {
                return word;
            }
        }
        return null;
    }

    /**
     * Takes in a word and the next word, looks for a match, then either adds the
     * word to storage, or adds the word after to the existing word.
     * 
     * @param wordIn     First word
     * @param wordInNext word after
     */
    public void inputWord(String wordIn, String wordInNext) {
        wordIn = wordIn.toLowerCase().trim();
        wordInNext = wordInNext.toLowerCase().trim();
        Word toAdd = getMatch(wordIn, getList(wordIn));
        if (checkWord(wordIn)) {
            if (toAdd == null) {
                createWord(wordIn, wordInNext);
            } else {
                toAdd.addWordAfter(wordInNext);
            }
        }
    }

    /**
     * Checks the first letter of the word and picks the corrosponding list.
     * 
     * @param wordIn The word that is used as a test
     * @return the corrosponding list
     */
    private ArrayList<Word> getList(String wordIn) {
        Character letter = wordIn.charAt(0);
        switch (letter) {
        case 'a':
            return aList;
        case 'b':
            return bList;
        case 'c':
            return cList;
        case 'd':
            return dList;
        case 'e':
            return eList;
        case 'f':
            return fList;
        case 'g':
            return gList;
        case 'h':
            return hList;
        case 'i':
            return iList;
        case 'j':
            return jList;
        case 'k':
            return kList;
        case 'l':
            return lList;
        case 'm':
            return mList;
        case 'n':
            return nList;
        case 'o':
            return oList;
        case 'p':
            return pList;
        case 'q':
            return qList;
        case 'r':
            return rList;
        case 's':
            return sList;
        case 't':
            return tList;
        case 'u':
            return uList;
        case 'v':
            return vList;
        case 'w':
            return wList;
        case 'x':
            return xList;
        case 'y':
            return yList;
        case 'z':
            return zList;
        default:
            return null;
        }
    }
}