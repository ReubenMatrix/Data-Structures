package Arrays.EasyProblems;

import java.util.Arrays;

/*
Given an array, we have to find the largest element in the array.

Example :
Input: arr[] = {2,5,1,3,0};
Output: 5
Explanation: 5 is the largest element in the array.
 */

public class LargestElementInArray {
    public static void main(String[] args) {
       int[] arr={8,2,9,1,34,23,90};
       int ans=BruteSolution(arr);
       System.out.println(ans);

       int ans2=OptimalSolution(arr);
       System.out.println(ans2);
    }

    static int BruteSolution(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
    //Time Complexity: O(N LogN)
    //Space Complexity: O(N)


    static int OptimalSolution(int[] arr){
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
}
