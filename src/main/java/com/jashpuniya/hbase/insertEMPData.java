import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class insertEMPData{

   public static void main(String[] args) {

        String csvFile = "empdata.csv";
        String line = "";
        String cvsSplitBy = ",";
        int lineNo = -1;

	try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

      		// Instantiating Configuration class
      		Configuration config = HBaseConfiguration.create();
      		// Instantiating HTable class
      		HTable hTable = new HTable(config, "EMP");

		while ((line = br.readLine()) != null) {

                	lineNo++;
                	String[] emprec = line.split(cvsSplitBy);



      			// Instantiating Put class
      			// accepts a row name.
      			Put p = new Put(Bytes.toBytes("row"+lineNo)); 

      			// adding values using add() method
      			// accepts column family name, qualifier/row name ,value
      			p.add(Bytes.toBytes("ED"),
      			Bytes.toBytes("EMP_NO"),Bytes.toBytes(emprec[0]));

      			p.add(Bytes.toBytes("ED"),
      			Bytes.toBytes("DEPT_NO"),Bytes.toBytes(emprec[1]));

      			p.add(Bytes.toBytes("EM"),
      			Bytes.toBytes("FNAME"),Bytes.toBytes(emprec[2]));

      			p.add(Bytes.toBytes("EM"),
      			Bytes.toBytes("LNAME"),Bytes.toBytes(emprec[3]));

      			p.add(Bytes.toBytes("EM"),
      			Bytes.toBytes("DATE_OF_BIRTH"),Bytes.toBytes(emprec[4]));

      			p.add(Bytes.toBytes("ER"),
      			Bytes.toBytes("SALARY"),Bytes.toBytes(emprec[5]));

      
      			// Saving the put Instance to the HTable.
      			hTable.put(p);
                }

      		System.out.println("data inserted");
      
      		// closing HTable
      		hTable.close();
	} catch (IOException e) {
		System.out.println("Failed to insert data: " + e.getMessage());
	}
   }
}
