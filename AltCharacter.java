import static org.junit.Assert.assertEquals;

import java.io.*;

import org.junit.Test;

public class AltCharacter {
    public static final int NUM_LETTERS = 26;

    static int alternateChars(String str, int length) {

        int[][] pair = new int[NUM_LETTERS][NUM_LETTERS];
        int[][] count = new int[NUM_LETTERS][NUM_LETTERS];

        for (int i = 0; i < length; i++) {
            char letter = str.charAt(i);
            int letterNum = letter - 'a';

            for (int col = 0; col < NUM_LETTERS; col++) {
                if (pair[letterNum][col] == letter) {
                count[letterNum][col] = -1;
                }
                if (count[letterNum][col] != -1) {
                    pair[letterNum][col] = letter;
                    count[letterNum][col]++;
                }
            }

            for (int row = 0; row < NUM_LETTERS; row++) {
                if (pair[row][letterNum] == letter) {
                    count[row][letterNum] = -1;
                }
                if (count[row][letterNum] != -1) {
                    pair[row][letterNum] = letter;
                    count[row][letterNum]++;
                }
            }
        }
     
        int max = 0;
        for (int row = 0; row < NUM_LETTERS; row++) {
            for (int col = 0; col < NUM_LETTERS; col++) {
                max = Math.max(max, count[row][col]);
            }
        }   
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result;
        
        if (l <= 1) {
            result = 0;
        }
        else {
            result = alternateChars(s, l);
        }

        System.out.println(result);

        bufferedReader.close();
    }
    
    @Test
    /*Here are my test cases using two strings of various lengths*/
    public void testAltChars() {
    	String s1 = "adbadbab";
    	int l1 = s1.length();
    	String s2 = "jeepejp";
    	int l2 = s2.length();
    	assertEquals(6, alternateChars(s1, l1));
    	assertEquals(4, alternateChars(s2, l2));
    	
    }
}