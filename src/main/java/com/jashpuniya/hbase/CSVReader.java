import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "empdata.csv";
        String line = "";
        String cvsSplitBy = ",";
	int lineNo = -1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
	        lineNo++;
                String[] emprec = line.split(cvsSplitBy);
                //System.out.println("Line No: " + lineNo + " Emp No : " +  emprec[0]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
