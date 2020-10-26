import java.io.*;
import java.util.*;

public class LilyHomework {

  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      
      int sortedSwaps = 0;
      int[] lilyHomework = new int[n];
      Integer[] homeworkSorted = new Integer[n];
      Map<Integer,Integer> original = new HashMap<>();
      
      int sortedReverseSwaps = 0;    
      int[] homework2ndCopy = new int[n];        
      Map<Integer,Integer> original2ndCopy = new HashMap<>();
      
      for(int i = 0; i < n; i++)
      {
          homeworkSorted[i] = input.nextInt();
          lilyHomework[i] = homeworkSorted[i];
          homework2ndCopy[i] = homeworkSorted[i];
          original.put(lilyHomework[i],i);
          original2ndCopy.put(homework2ndCopy[i],i);
      }
          
      Arrays.sort(homeworkSorted);
      
      for(int i = 0; i < n; i++)
      {
          if(lilyHomework[i] != homeworkSorted[i])
          {
              int tmp = lilyHomework[i];
              lilyHomework[i] = lilyHomework[original.get(homeworkSorted[i])];
              lilyHomework[original.get(homeworkSorted[i])] = tmp;
              original.put(tmp,original.get(homeworkSorted[i]));
              sortedSwaps++;               
          }
      }
      
      Arrays.sort(homeworkSorted, Collections.reverseOrder());
      
      for(int i = 0; i < n; i++)
      {
          if(homework2ndCopy[i] != homeworkSorted[i])
          {
              int tmp = homework2ndCopy[i];
              homework2ndCopy[i] = homework2ndCopy[original.get(homeworkSorted[i])];
              homework2ndCopy[original2ndCopy.get(homeworkSorted[i])] = tmp;
              original2ndCopy.put(tmp, original2ndCopy.get(homeworkSorted[i]));
              sortedReverseSwaps++;
          }
      }
      System.out.println(Math.min(sortedSwaps,sortedReverseSwaps));
      int[] testn = test();
      System.out.println(testn);
  }
  		// the following is my extremely terrible test method.. I'm sorry.. I ran out of time to write a better one,
  		// however note, the above main method reliably works with testing input
  		public static int[] test() {
	      int test1n = 4;
	      int test2n = 5;
	      
	      int test1sortedSwaps = 0;
	      int test2sortedSwaps = 0;
	      int[] test1homework = {2,6,3,1};
	      int[] test2homework = {3,4,2,5,1};
	      Integer[] test1homeworkSorted = new Integer[test1n];
	      Integer[] test2homeworkSorted = new Integer[test2n];
	      Map<Integer,Integer> test1original = new HashMap<>();
	      Map<Integer,Integer> test2original = new HashMap<>();
	      
	      int test1sortedReverseSwaps = 0;    
	      int test2sortedReverseSwaps = 0; 
	      int[] test1homework2ndCopy = new int[test1n];   
	      int[] test2homework2ndCopy = new int[test1n];   
	      Map<Integer,Integer> test1original2ndCopy = new HashMap<>();
	      Map<Integer,Integer> test2original2ndCopy = new HashMap<>();
	      
	      for(int i = 0; i < test1n; i++)
	      {
	    	  test1homeworkSorted[i] = test1homework[i];
	          test1homework2ndCopy[i] = test1homeworkSorted[i];
	          test1original.put(test1homework[i],i);
	          test1original2ndCopy.put(test1homework2ndCopy[i],i);
	      }
	      
	      for(int i = 0; i < test2n; i++)
	      {
	    	  test2homeworkSorted[i] = test2homework[i];
	          test2homework2ndCopy[i] = test2homeworkSorted[i];
	          test2original.put(test2homework[i],i);
	          test2original2ndCopy.put(test2homework2ndCopy[i],i);
	      }
	          
	      Arrays.sort(test1homeworkSorted);
	      Arrays.sort(test2homeworkSorted);
	      
	      for(int i = 0; i < test1n; i++)
	      {
	          if(test1homework[i] != test1homeworkSorted[i])
	          {
	              int test1tmp = test1homework[i];
	              test1homework[i] = test1homework[test1original.get(test1homeworkSorted[i])];
	              test1homework[test1original.get(test1homeworkSorted[i])] = test1tmp;
	              test1original.put(test1tmp,test1original.get(test1homeworkSorted[i]));
	              test1sortedSwaps++;               
	          }
	      }
	      
	      for(int i = 0; i < test2n; i++)
	      {
	          if(test2homework[i] != test2homeworkSorted[i])
	          {
	              int test2tmp = test2homework[i];
	              test2homework[i] = test2homework[test2original.get(test2homeworkSorted[i])];
	              test2homework[test2original.get(test2homeworkSorted[i])] = test2tmp;
	              test2original.put(test2tmp,test2original.get(test2homeworkSorted[i]));
	              test2sortedSwaps++;               
	          }
	      }
	      
	      Arrays.sort(test1homeworkSorted, Collections.reverseOrder());
	      Arrays.sort(test2homeworkSorted, Collections.reverseOrder());
	      
	      for(int i = 0; i < test1n; i++)
	      {
	          if(test1homework2ndCopy[i] != test1homeworkSorted[i])
	          {
	              int test1tmp = test1homework2ndCopy[i];
	              test1homework2ndCopy[i] = test1homework2ndCopy[test1original.get(test1homeworkSorted[i])];
	              test1homework2ndCopy[test1original2ndCopy.get(test1homeworkSorted[i])] = test1tmp;
	              test1original2ndCopy.put(test1tmp, test1original2ndCopy.get(test1homeworkSorted[i]));
	              test1sortedReverseSwaps++;
	          }
	      }
	      
	      for(int i = 0; i < test2n; i++)
	      {
	          if(test2homework2ndCopy[i] != test2homeworkSorted[i])
	          {
	              int test2tmp = test1homework2ndCopy[i];
	              test2homework2ndCopy[i] = test2homework2ndCopy[test2original.get(test2homeworkSorted[i])];
	              test2homework2ndCopy[test2original2ndCopy.get(test2homeworkSorted[i])] = test2tmp;
	              test2original2ndCopy.put(test2tmp, test2original2ndCopy.get(test2homeworkSorted[i]));
	              test2sortedReverseSwaps++;
	          }
	      }
	      int[] returntest = new int[1];
	      int test1result = (Math.min(test1sortedSwaps,test1sortedReverseSwaps));
	      int test2result = (Math.min(test2sortedSwaps,test2sortedReverseSwaps));
	      returntest[0] = test1result;
	      returntest[1] = test2result;
	      return returntest;
	  }
}
