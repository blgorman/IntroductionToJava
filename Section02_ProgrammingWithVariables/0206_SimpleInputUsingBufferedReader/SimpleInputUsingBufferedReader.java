//import java.io.BufferedReader;
import java.io.*;
/**
 * Get input from user with Buffered Reader.
 * @author Brian
 */
public class SimpleInputUsingBufferedReader {

    public static void main(String[] args){
        //note we are "wrapping" the InputStreamReader which wraps the System.in
        //InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String name = null;
        System.out.println("Please enter your name: ");
        
        try {
        	name = br.readLine();
            System.out.printf("Your name is: %s\n", name);
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
