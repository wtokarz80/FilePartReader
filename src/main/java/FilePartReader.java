import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    FilePartReader(){
        this.filePath = "sdsjdj";
        this.fromLine = 3;
        this.toLine = 1;

    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }

    public void setup (String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine)
            throw new IllegalArgumentException("toLine must be greater than fromLine");
        else if (fromLine < 1)
            throw new IllegalArgumentException("fromLine must by greater than 1");

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }

    public String read () throws IOException {
        StringBuilder data = new StringBuilder();
        File myObj = new File(filePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            data.append(myReader.nextLine()).append("\n");
        }
        myReader.close();
        return data.toString();


    }

    public String readLines () throws IOException {
        String[] text = read().split("\n");
        StringBuilder selectedLines = new StringBuilder();
        for (int i = fromLine-1; i < toLine; i++) {
            selectedLines.append(text[i]).append("\n");
        }
        return selectedLines.toString();

    }

}
