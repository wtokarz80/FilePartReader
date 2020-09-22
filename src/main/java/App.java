import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        FilePartReader filePartReader = new FilePartReader();

        filePartReader.setup("src/main/resources/harp.txt", 1, 1);
        filePartReader.readLines();
    }
}
