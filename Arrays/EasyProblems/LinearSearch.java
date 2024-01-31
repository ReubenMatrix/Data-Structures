package Arrays.EasyProblems;


/*
Given an array, and an element num the task is to find if num is present in the given array or not.
If present print the index of the element or print -1.

Example :
Input: arr[]= 1 2 3 4 5, num = 3
Output: 2
Explanation: 3 is present in the 2nd index
 */


public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={6, 8, 4, 9, 2, 3};
        int ans=Solution(arr,2);
        System.out.println(ans);
    }

    public static int Solution(int[] arr,int num){
        int n= arr.length-1;

        for (int i = 0; i < n; i++) {
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }
}
