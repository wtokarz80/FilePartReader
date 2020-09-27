import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    void init(){
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/test.txt", 1, 3);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    @DisplayName("Testing getWordsOrderAlphabetically method")
    void testGetWordsOrderAlphabetically() throws IOException {
        List<String> expected = Arrays.asList("end", "endorphin", "eva", "madam", "olo", "txt");
        assertEquals(expected, fileWordAnalyzer.getWordsOrderAlphabetically());
    }

    @Test
    @DisplayName("Testing getWordsContainingSubstring method")
    void testGetWordsContainingSubstring() throws IOException {
        List<String> expected = Arrays.asList("end", "endorphin");
        assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("en"));
    }

    @Test
    @DisplayName(" Testing getStringsWhichPalindromes method")
    void testGetStringsWhichPalindromes() throws IOException {
        List<String> expected = Arrays.asList("madam", "olo", "txt");
        assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}