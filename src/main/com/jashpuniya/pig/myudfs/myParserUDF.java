/**
 * An Eval UDF Parser function for Multi Delimiter file having , and | as delimiters
 */
package myudfs;

import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.WrappedIOException;

/**
 * Parser function for Multi Delimiter file having , and | as delimiters
 *
 * @author Jash Puniya 
 *
 */
public class myParserUDF  extends EvalFunc<String>{

    public String exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0 || input.get(0) == null) {
            return null;
        }

        try {

            String strTuple = (String) input.get(0); 
            strTuple = strTuple.replaceAll("\\|", ","); 
            strTuple = strTuple.replaceAll("\\,", "\t"); 
            return strTuple;

        } catch (Exception e) {
            throw WrappedIOException.wrap("Caught exception processing input row ", e);
        }
    }
}
