
public class SubArray {
	public static int maxSubArray(int[] A) {
	    int max = Integer.MIN_VALUE, sum = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (sum < 0) 
	            sum = A[i];
	        else 
	            sum += A[i];
	        if (sum > max)
	            max = sum;
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		int[] test1 = {1,2,3,4,5};
		int test1result = maxSubArray(test1);
		System.out.println(test1result);
		if (test1result == 15) {
			System.out.println("Test 1 passes");
		}
		else {
			System.out.println("Test 1 fails");
		}
		int[] test2 = {2,-5,6,7,-2};
		int test2result = maxSubArray(test2);
		System.out.println(test2result);
		if (test2result == 13) {
			System.out.println("Test 2 passes");
		}
		else {
			System.out.println("Test 2 fails");
		}
	}
}
