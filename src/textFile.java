import java.io.*;
import java.util.*;

public class textFile{

    private String selectedWord;
    private int totalWords = 0;
    private Scanner E;
    private ArrayList<String> words = new ArrayList<>();  // Pool of potential words that can be used in game.
    private ArrayList<String> usedWords = new ArrayList<>();  // An array list of previously used words.

    // Default constructor.
    public textFile(){
        openFile();
        readSet();
        closeFile();
    }

    // Opens the text file that contains the list of words.
    public void openFile(){
        try{
            E = new Scanner(new FileReader("wordlist.txt"));
        }
        catch (Exception e){
            System.out.println("Could not find file");
        }
    }

    /*
     * Traverses each word in the text file, parameters can be adjusted to include / exclude words of a certain length.
     * The words that meet the criteria will be placed into an array list.
     *
     * */
    public void readSet() {

        while (E.hasNext()) {
            totalWords++;
            selectedWord = E.next();

            while (selectedWord.length() != 6) {
                selectedWord = E.next();
                if (!E.hasNext()) {
                    break;
                }
            }
            words.add(selectedWord);
        }
        words.remove("phpbb");
        words.remove("msgstr");
        words.remove("rhythm");
        setTotalWords(words.size());
    }

    // Closes the text file that contains the list of words once every word has been checked and filtered.
    public void closeFile() {
        E.close();
    }

    /*
     * Checks for duplicates and removes them in the event the player plays more than one game.
     * Ensures a word from a previous play through doesn't get selected in future rounds.
     * Words used in previous rounds are stored in the "usedWords" array list.
     *
     * */
    public void wordFilter(){
        for (String usedWord : usedWords) {
            words.remove(usedWord);
        }
        setTotalWords(words.size());
    }

    // Removes a specified word from the "words" array list.
    public ArrayList<String> deleteWord(String delete){
        words.remove(delete);
        setTotalWords(words.size());
        return words;
    }

    /*
    * Clears the usedWords array list and fills the words array list with the original set of words that met the preset criteria.
    * This is utilized if the player plays more rounds / play through than the amount of potential secret words.
    * Since th previous word from the last round is removed to eliminate duplicates, after x amount of games the "words" array list will be empty.
    *
    * */
    public void emptyUsedWords(){
        if(words.size() == 0){
            usedWords.clear();
            openFile();
            readSet();
            closeFile();
        }
    }

    /*
     * This is used when the player restarts the game or returns to the main menu.
     * Clears the "words" array list, checks each word again, and adds the words that meet the criteria into the now empty "words" array list.
     * It adds the selected word from the previous game to the "usedWords" array list to eliminate repeats.
     *
     * */
    public void resetLists(String previousWord){
        words.clear();
        totalWords = 0;
        selectedWord = null;
        openFile();
        readSet();
        closeFile();
        usedWords.add(previousWord);
        emptyUsedWords();
        wordFilter();
    }

    // Returns the word from the array list at the specified index.
    public String getIndexWord(int index) {
        return words.get(index);
    }

    // Sets words in the array list.
    public void setWordsList(ArrayList<String> placer){
        this.words = placer;
    }

    // Returns the words in the "words" array list.
    public ArrayList<String> getWordsList() {
        return words;
    }

    // Sets the selected word.
    public void setSelectedWord(String word){
        this.selectedWord = word;
    }

    // Returns the selected word.
    public String getSelectedWord(){
        return selectedWord;
    }

    // Sets the total number of words.
    public void setTotalWords(int total){
        this.totalWords = total;
    }

    // Returns the total number of words.
    public int getTotalWords(){
        return totalWords;
    }
}
