import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class getDataUsingSCAN {

   public static void main(String[] args) {

	try {

      		// Instantiating Configuration class
      		Configuration config = HBaseConfiguration.create();

      		// Instantiating HTable class
      		HTable hTable = new HTable(config, "EMP");

		Scan scan = new Scan();
		scan.setCaching(20);

		//scan.addFamily(Bytes.toBytes("marks"));
		ResultScanner scanner = hTable.getScanner(scan);

		for (Result result = scanner.next(); (result != null); result = scanner.next()) {
		    Get get = new Get(result.getRow());
		    Result entireRow = hTable.get(get); 
		    //System.out.println(entireRow);

		    // Reading values from Result class object
		    byte [] tEMP_NO = entireRow.getValue(Bytes.toBytes("ED"),Bytes.toBytes("EMP_NO"));
		    byte [] tDEPT_NO = entireRow.getValue(Bytes.toBytes("ED"),Bytes.toBytes("DEPT_NO"));
		    byte [] tFNAME = entireRow.getValue(Bytes.toBytes("EM"),Bytes.toBytes("FNAME"));
		    byte [] tLNAME = entireRow.getValue(Bytes.toBytes("EM"),Bytes.toBytes("LNAME"));
		    byte [] tDATE_OF_BIRTH = entireRow.getValue(Bytes.toBytes("EM"),Bytes.toBytes("DATE_OF_BIRTH"));
		    byte [] tSALARY = entireRow.getValue(Bytes.toBytes("ER"),Bytes.toBytes("SALARY"));

		    // Printing the values
		    String emp_no = Bytes.toString(tEMP_NO);
		    String dept_no = Bytes.toString(tDEPT_NO);
		    String fname = Bytes.toString(tFNAME);
		    String lname = Bytes.toString(tLNAME);
		    String date_of_birth = Bytes.toString(tDATE_OF_BIRTH);
		    String salary = Bytes.toString(tSALARY);
                     
		    System.out.println("EMP_NO: " + emp_no + " DEPT_NO: " + dept_no + " FNAME: " + fname + " LNAME: " + lname + " DATE_OF_BIRTH: " + date_of_birth + " SALARY: " + salary);

		}

      		System.out.println("Table data retrieved");
      
      		// closing HTable
      		hTable.close();

	} catch (IOException e) {
		System.out.println("Failed to retrieve data: " + e.getMessage());
	}
   }
}
