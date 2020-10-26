import java.util.Arrays;

public class TaskScheduler {

    public static int taskScheduler(char[] tasks, int n) {
        int[] nums = new int[26];
        int max = nums[25];
        int max_count = 0;
        for (int i = 0; i < tasks.length; i ++) {
            nums[tasks[i] -'A'] ++;
        }
        Arrays.sort(nums);
        for (int i = 25; i >= 0; i --) {
            if (nums[i] == max) {
                max_count ++;
            }
        }
        return Math.max(tasks.length,  (max - 1) * (n + 1) + max_count);
    }

    // the following main method tests two different inputs not in original example
    public static void main(String[] args) {
        char[] tasks1 = new char[]{'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(taskScheduler(tasks1,2));
        
        char[] tasks2 = new char[] {'B', 'O', 'B'};
        System.out.println(taskScheduler(tasks2,0));
    }
}