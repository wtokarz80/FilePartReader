import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/test.txt", 1, 2);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        List<String> sortedWords = fileWordAnalyzer.getWordsOrderAlphabetically();
        System.out.println(sortedWords);
        List<String> wordsWithSubstring = fileWordAnalyzer.getWordsContainingSubstring("en");
        System.out.println(wordsWithSubstring);
        List<String> palindromes = fileWordAnalyzer.getStringsWhichPalindromes();
        System.out.println(palindromes);

    }
}
