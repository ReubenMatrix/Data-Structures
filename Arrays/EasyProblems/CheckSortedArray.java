package Arrays.EasyProblems;

/*
Given an array of size n, write a program to check if the given array is sorted or not.
If the array is sorted then return True, Else return False.

Example :
Input: N = 5, array[] = {1,2,3,4,5}
Output: True.
Explanation: The given array is sorted i.e
Every element in the array is smaller than or equals to its next values, So the answer is True.
 */

public class CheckSortedArray {
    public static void main(String[] args) {
      int[] arr={6,4,2,9,8,7};
      boolean ans=BruteSolution(arr);
      System.out.println(ans);

      boolean ans2=OptimalSolution(arr);
        System.out.println(ans2);
    }

    public static Boolean BruteSolution(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[i]){
                    return false;
                }
            }
        }
        return true;
    }
    //Time Complexity: O(N²)
    //Space Complexity: O(1)

    public static boolean OptimalSolution(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
}
