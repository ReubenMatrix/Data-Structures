package Arrays.EasyProblems;
import java.util.Arrays;

/*
Given an array, find the second largest element in the array.
Print ‘-1’ in the event that either of them doesn’t exist.

Example :
Input: [1,2,4,7,7,5]
Output: Second Smallest : 2
	Second Largest : 5
Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2
 */

public class SecondLargestElementInArray {
    public static void main(String[] args) {
       int[] arr={6, 3, 4, 2, 9, 1};
       int ans=BruteSolution(arr);
       System.out.println(ans);

        int ans2=OptimalSolution(arr);
        System.out.println(ans2);
    }

    public static int BruteSolution(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-2];
    }
    //Time Complexity: O(N LogN)
    //Space Complexity: O(N)

    public static int OptimalSolution(int[] arr){
        int largest=Integer.MIN_VALUE;
        int SecondLargest=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            largest=Math.max(largest,arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>SecondLargest && arr[i]!=largest){
                SecondLargest=arr[i];
            }
        }
        return SecondLargest;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)

}
