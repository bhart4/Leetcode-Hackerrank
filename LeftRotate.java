import java.util.Scanner;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class LeftRotate {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int numbers[] = new int[n];
        for (int numbers_i = 0; numbers_i < n; numbers_i++) {
            numbers[numbers_i] = in.nextInt();
        }
        in.close();
        
        for (int i = 0; i < d; i++) {
        	shiftLeft(numbers, n);
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
	}
	
	public static int[] shiftLeft(int arr[], int n) {
		int temp = arr[0];

		for (int i = 0; i < n-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[n-1] = temp;
		return arr;
	}

    
    @Test
    /*Here are my test inputs using two different arrays of various lengths with various d values, 
     exemplified in the first example by calling shiftLeft twice, as the algorithm would for d=2  */
    public void testLeftRotate() {
    	int[] input1 = {1,2,3,4,5,6};
    	int[] expectedOutput1 = {3,4,5,6,1,2};
    	int[] temp = shiftLeft(input1, 6);
    	int[] methodOutput1 = shiftLeft(temp, 6);
    	assertArrayEquals(expectedOutput1, methodOutput1);
    	
    	int[] input2 = {4,6,7};
    	int[] expectedOutput2 = {6,7,4};
    	int[] methodOutput2 = shiftLeft(input2, 3);
    	assertArrayEquals(expectedOutput2, methodOutput2);
    }
}
