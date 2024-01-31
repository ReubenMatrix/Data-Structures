package Arrays.EasyProblems;


/*
Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.

Example :
Input: prices = {1, 1, 0, 1, 1, 1}
Output: 3
Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.
 */

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr={1, 2, 4, 1, 1, 1, 6};
        int ans=Solution(arr);
        System.out.println(ans);

    }

    public static int Solution(int[] arr){
        int count=0;
        int max=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                count++;
            }else {
                count=0;
            }

            max=Math.max(max,count);
        }
        return max;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
}
