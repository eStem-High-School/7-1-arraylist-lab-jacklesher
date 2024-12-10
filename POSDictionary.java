import java.io.FileNotFoundException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class provides information about the parts of speech of words. It
 * provides methods for generating random words of a particular type, and
 * methods for checking the part of speech for a provided word.
 * 
 * @author Nathan Sprague and ???
 * @version 3/30/15
 */
public class POSDictionary{
    public ArrayList<String> N = new ArrayList<String>();
    public ArrayList<String> V = new ArrayList<String>();
    public ArrayList<String> Adj = new ArrayList<String>();
    public ArrayList<String> Adv = new ArrayList<String>();
    private Random generator;

    // DECLARE FOUR ARRAY LISTS TO CONTAIN NOUNS, VERBS, ADJECTIVES AND ADVERBS

    /**
     * Instantiate a POSDictionary from a dictionary file. Each word will be on
     * a single line, with a comma separating the word from a part of speech
     * identifier. For example:
     * 
     * pose,V
     * 
     * Indicates that the word "pose" is a verb. The four recognized part of
     * speech identifiers are:
     * 
     * N - Noun 
     * V - Verb 
     * A - Adjective 
     * v - Adverb
     * 
     * Unrecognized parts of speech will be ignored. Each word will be
     * associated with only one part of speech.
     * 
     * @param posFile - File name of the dictionary file
     * @throws FileNotFoundException - if the file cannot be opened for reading
     */
    public POSDictionary(String posFile) throws FileNotFoundException
    {
        generator = new Random();

        // UNFINISHED.
        // INSTANTIATE ARRAY LISTS HERE.

        loadFile(posFile);
    }

    /**
     * Helper method for loading the file. See constructor Javadoc for file
     * format.
     * 
     *   UNFINISHED.
     * 
     * @param posFile - File name of the dictionary file
     * @throws FileNotFoundException - if the file cannot be opened for reading
     */
    private void loadFile(String posFile) throws FileNotFoundException
    {
        generator = new Random();
        Scanner sc;
        String curLine, word, pos;
        String[] splitLine;

        sc = new Scanner(new File(posFile));

        while (sc.hasNextLine())
        {
            curLine = sc.nextLine();
            splitLine = curLine.split(",");
            word = splitLine[0];
            pos = splitLine[1];

            // INSERT EACH WORD INTO THE APPROPRIATE ARRAYLIST.
            // THIS IS A GOOD PLACE FOR A SWITCH STATEMENT.
            String secHalf = curLine.substring(curLine.indexOf(splitLine));
            String firstHalf = curLine.substring(0,curLine.indexOf(splitLine));
            if(secHalf.indexOf("N")!=-1){
                N.add(firstHalf);
            }
            if(secHalf.indexOf("V")!=-1){
                V.add(firstHalf);
            }
            if(secHalf.indexOf("A")!=-1){
                Adj.add(firstHalf);
            }
            if(secHalf.indexOf("v")!=-1){
                Adv.add(firstHalf);
            }

        }
        sc.close();
    }

    /**
     * Helper method for selecting a single random string from an ArrayList of
     * strings.
     * 
     * @param wordList - ArrayList of strings
     * @return a randomly selected string
     */
     private String randomWord(ArrayList<String> wordList)
    {
        // UNFINISHED
        String wordl= " ";
        if(wordList==N){
            wordl=randomNoun();
        }
        if(wordList==V){
            wordl=randomVerb();
        }
        if(wordList==Adj){
            wordl=randomAdjective();
        }
        if(wordList==Adv){
            wordl=randomAdverb();
        }
        return wordl;
    }
    
    
    // ALL OF THE METHODS BELOW THIS POINT SHOULD BE ONE-LINERS. 

    /**
     * @return A randomly selected noun
     */
    public String randomNoun()
    {
        // UNFINISHED
        String generator = new Random();
        return generator(0,N.size()+1);
    }

    /**
     * @return A randomly selected verb
     */
    public String randomVerb()
    {
        // UNFINISHED
        String generator = new Random();
        return generator(0,V.size()+1);
    }

    /**
     * @return A randomly selected adjective
     */
    public String randomAdjective()
    {
        // UNFINISHED
        String generator = new Random();
        return generator(0,Adj.size()+1);
    }

    /**
     * @return a randomly selected adverb
     */
    public String randomAdverb()
    {
        // UNFINISHED
        String generator = new Random();
        return generator(0,Adv.size()+1);
    }

    /**
     * Check a word to see if it is a noun.
     * 
     * @param word - the word to check
     * @return - true if it is a noun
     */
    public boolean isNoun(String word)
    {
        // UNFINISHED
        for (i = 0; i < N.size(); i++){
            if(word.equals(N.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Check a word to see if it is a verb.
     * 
     * @param word - the word to check
     * @return - true if it is a verb
     */
    public boolean isVerb(String word)
    {
        // UNFINISHED
        for (i = 0; i < V.size(); i++){
            if(word.equals(V.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Check a word to see if it is a adjective.
     * 
     * @param word - the word to check
     * @return - true if it is a adjective
     */
    public boolean isAdjective(String word)
    {
        // UNFINISHED
        for (i = 0; i < Adj.size(); i++){
            if(word.equals(Adj.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Check a word to see if it is a adverb.
     * 
     * @param word - the word to check
     * @return - true if it is a adverb
     */
    public boolean isAdverb(String word)
    {
        // UNFINISHED
        for (i = 0; i < Adv.size(); i++){
            if(word.equals(Adv.get(i))){
                return true;
            }
        }
        return false;
    }
}
