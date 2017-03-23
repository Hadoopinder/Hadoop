import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.client.Delete;

public class deleteEMP {

   public static void main(String[] args) {

	try {

      		// Instantiating Configuration class
      		Configuration config = HBaseConfiguration.create();

      		// Instantiating HTable class
      		HTable table = new HTable(config, "EMP");

		// Instantiating Delete class
		Delete delete = new Delete(Bytes.toBytes("row3"));

		// deleting the data
		table.delete(delete);

      		System.out.println("Employee record deleted");
      
      		// closing HTable
      		table.close();

	} catch (IOException e) {
		System.out.println("Trouble deleting employee: " + e.getMessage());
	}
   }
}
