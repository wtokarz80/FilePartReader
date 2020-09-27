import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader filePartReader;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        filePartReader = new FilePartReader();
        testReporter.publishEntry("Running " + testInfo.getDisplayName());

    }

    @Test
    @DisplayName("Testing setup method")
    void testSetup() {
        String filePath = filePartReader.getFilePath();
        Integer fromLine = filePartReader.getFromLine();
        Integer toLine = filePartReader.getToLine();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(filePath, fromLine, toLine), "toLine lower than fromLine or fromLine lower than 1 should throw");
    }


    @ParameterizedTest
    @DisplayName("Testing read method")
    @ValueSource(strings = { "madam\n" +
            "olo eva end txt\n" +
            "endorphin\n" })

    void testRead(String text) throws IOException {
        filePartReader.setup("src/main/resources/test.txt", 1, 3);
        assertEquals(filePartReader.read(), text);
    }

    @ParameterizedTest
    @DisplayName("Testing readLines method ")
    @ValueSource(strings = { "madam\n" +
            "olo eva end txt\n"})
    void testReadLines(String text) throws IOException {
        filePartReader.setup("src/main/resources/test.txt", 1, 2);
        assertEquals(filePartReader.readLines(), text);

    }
}
