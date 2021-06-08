import java.util.ArrayList;
import java.util.Random;

public class randomWord {

    private int i;
    private Random randomNumber = new Random();
    private textFile textFileObject = new textFile(); // Allows access to methods from textFile.

    // Default constructor.
    public randomWord(){
        randomlySelected();
    }

    /*
     * Sets and returns a randomly selected word from the "words" array list.
     * The randomly selected word is stored in the "selectedWord" variable.
     *
     * */
    public String randomlySelected(){
        i = randomNumber.nextInt(textFileObject.getTotalWords());
        while(i >= textFileObject.getTotalWords() || i < 0){
            i = randomNumber.nextInt(textFileObject.getTotalWords());
        }
        textFileObject.setSelectedWord(textFileObject.getWordsList().get(i));
        return (textFileObject.getSelectedWord());
    }

    // Sets the "words" array list to the given parameter from textFileObject.
    public void setWordsList(ArrayList<String> set){
        this.textFileObject.setWordsList(set);
    }

    // Sets the total number of words in the textFileObject.
    public void setTotalWords(int total){
        this.textFileObject.setTotalWords(total);
    }

}

