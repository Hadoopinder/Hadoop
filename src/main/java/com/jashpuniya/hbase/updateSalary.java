import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class updateSalary {

   public static void main(String[] args) {

	try {

      		// Instantiating Configuration class
      		Configuration config = HBaseConfiguration.create();

      		// Instantiating HTable class
      		HTable hTable = new HTable(config, "EMP");

      		// Instantiating Put class
      		// accepts a row name.
      		Put p = new Put(Bytes.toBytes("row5")); 

      		p.add(Bytes.toBytes("ER"),Bytes.toBytes("SALARY"),
      		Bytes.toBytes("3200"));
      
      		// Saving the put Instance to the HTable.
      		hTable.put(p);
      		System.out.println("Salary updated");
      
      		// closing HTable
      		hTable.close();
	} catch (IOException e) {
		System.out.println("Trouble updating salary: " + e.getMessage());
	}
   }
}
