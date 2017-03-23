import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
     
public class createEMPTable {
      public static void main(String[] args) {
	try {
        	HBaseConfiguration hconfig = new HBaseConfiguration(new Configuration());
        	HTableDescriptor htable = new HTableDescriptor("EMP"); 
        	htable.addFamily( new HColumnDescriptor("ED"));
        	htable.addFamily( new HColumnDescriptor("EM"));
        	htable.addFamily( new HColumnDescriptor("ER"));
        	System.out.println( "Connecting..." );
        	HBaseAdmin hbase_admin = new HBaseAdmin( hconfig );
        	System.out.println( "Creating Table..." );
        	hbase_admin.createTable( htable );
        	System.out.println("Done!");
        } catch (IOException ioe ) {
	       System.out.println("Trouble creating table: " + ioe.getMessage());
        }
      }
}
