import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;



public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        Set<Character> set = new HashSet<Character>();
        for (char c : s1.toCharArray()) {
            set.add(c);
        }
        String common = "NO";
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                common = "YES";
                break;
            }
        }
    return common;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            String result = twoStrings(s1, s2);

            System.out.println(result);
            br.close();
        }
    }
    
    @Test
    /*Here are my test cases using four strings of various lengths, testing results that
     * would be YES and NO
     */
    public void testTwoStrings() {
    	String s1 = "after";
    	String s2 = "before";
    	String s3 = "giraffe";
    	String s4 = "no";
    	assertEquals("YES", twoStrings(s1, s2));
    	assertEquals("NO", twoStrings(s3, s4));
    	
    }
}
