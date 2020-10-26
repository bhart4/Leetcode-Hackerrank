import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;

public class Steps {
	
	public static int climbStairs(int n) {
		int prevPrev = 1;  // base case for n=0
		int prev = 1; // base case for n=1
		int result = 1;  // just to handle n=0 and n=1

		for (int i=2; i<=n; i++) {
			result = prevPrev + prev;
			prevPrev = prev;
			prev = result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int test1 = climbStairs(4);
		System.out.println(test1);
		if (test1 == 5) {
			System.out.println("Test 1 passes");
		}
		else {
			System.out.println("Test 1 fails");
		}
		
		int test2 = climbStairs(10);
		System.out.println(test2);
		if (test2 == 89) {
			System.out.println("Test 2 passes");
		}
		else {
			System.out.println("Test 2 fails");
		}
	}

	public void testClimbStairs() {
		int test1 = climbStairs(4);
		int test2 = climbStairs(10);
    	assertEquals(5, test1);
    	assertEquals(89, test2);
    	
    }
}