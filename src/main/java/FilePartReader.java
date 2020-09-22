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

    public void setup (String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine)
            throw new IllegalArgumentException("toLine must be greater than fromLine");
        else if (fromLine < 1)
            throw new IllegalArgumentException("fromLine must by greater than 1");

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }


//    opens the file on filePath , and gives back it's content as a String
//    it doesn't catch the exception being raised, if the file isn't present on filePath, we can expect an IOException

    public String read () throws IOException {
        String data = "";
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            myReader.close();
        return data;

    }

//    reads the file with read ()
//    it gives back every line from it's content between fromLine and toLine (both of them are included), and returns
//    these lines as a String. Take care because if fromLine is 1, it means the very first row in the file. Also, if fromLine is
//    1 and toLine is 1 also, we will read only the very first line.

    public String readLines () throws IOException {
        String[] text = read().split("\n");
        StringBuilder selectedLines = new StringBuilder();
        for (int i = fromLine-1; i < toLine; i++) {
            selectedLines.append(text[i] + "\n");
        }
        System.out.println(selectedLines.toString());

        return selectedLines.toString();
    }

}
