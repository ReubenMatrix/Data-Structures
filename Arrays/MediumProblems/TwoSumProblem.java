package Arrays.MediumProblems;
/*
Given an array of integers arr[] and an integer target.
Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

Example :
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: [1, 3]
Explanation: arr[1] + arr[3] = 14. So, the answer is  [1, 3] .
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {
    public static void main(String[] args) {
        int[] arr={2, 6, 5, 8, 11};
        int[] ans=BruteSolution(arr,14);
        System.out.println("["+ ans[0]+" "+ans[1]+"]");


        int[] ans2=BetterSolution(arr,14);
        System.out.println("["+ ans2[0]+" "+ans2[1]+"]");

        System.out.println(OptimalSolution(arr, 13));

    }

    public static int[] BruteSolution(int[] arr,int target){
        int[] ans=new int[2];
        ans[0]=ans[1]=-1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }

        }
        return ans;
    }
    //Time Complexity: O(N²)
    //Space Coplexity: O(1)

    public static int[] BetterSolution(int[] arr,int target){
        int[] ans=new int[2];
        ans[0]=ans[1]=-1;

        HashMap<Integer, Integer> map=new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num=arr[i];
            int needed=target-arr[i];
            if(map.containsKey(needed)){
                ans[0]= map.get(needed);
                ans[1]=i;
            }

            map.put(arr[i],i);
        }
        return ans;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(N)


    public static String OptimalSolution(int[] arr, int target){
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;

        while (left<right){
            if(arr[left]+arr[right] == target){
                return "YES";
            } else if (arr[left]+arr[right] < target) {
                left++;
            }else {
                right--;
            }
        }
        return "NO";
    }
    //Time Complexity: O(N) + O(N LogN)
    //Space Complexity: O(1)

}
