import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Ling on 2015-08-19.
 */
public class Nuke2 {
    public static void main (String[] args) throws Exception {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter a string:");
        System.out.flush();
        String inputlines;
        inputlines = keyboard.readLine();
        System.out.println(removeCharAt(inputlines,1));
    }
    public static String removeCharAt (String s, int pos){
        return s.substring(0, pos) + s.substring(pos+1);
    }
}
