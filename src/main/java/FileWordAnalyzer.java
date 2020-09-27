import java.io.IOException;
import java.util.*;

public class FileWordAnalyzer {

    private final FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderAlphabetically() throws IOException {
        List<String> textWords = getTextWords();
        Collections.sort(textWords);
        return textWords;

    }

    private List<String> getTextWords() throws IOException {
        return Arrays.asList(filePartReader.readLines().split("\\s+"));

    }

    public List<String> getWordsContainingSubstring (String subString) throws IOException {
        List<String> wordsContainingSubstring = new ArrayList<>();
        List<String> textWords = getTextWords();
        for (String word : textWords){
            if (word.contains(subString)){
                wordsContainingSubstring.add(word);
            }
        }
        return wordsContainingSubstring;

    }


    public List<String> getStringsWhichPalindromes () throws IOException {
        List<String> palindromes = new ArrayList<>();
        List<String> textWords = getTextWords();
        for (String word : textWords){
            var stringBuilder = new StringBuilder();
            stringBuilder.append(word).reverse();
            if (word.equalsIgnoreCase(stringBuilder.toString()) && word.length() > 1){
                palindromes.add(word);
            }
        }
        return palindromes;

    }

}
