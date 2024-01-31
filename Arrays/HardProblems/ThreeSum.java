package Arrays.HardProblems;

import java.util.*;

/*
Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero.
In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i,
and their sum is equal to zero.

Example :
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k
 */

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = BruteSolution(arr);
        System.out.println(ans);

    }

    public static List<List<Integer>> BruteSolution(int[] arr){
        int n= arr.length;
        Set<List<Integer>> set=new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = i; k < j; k++) {
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> list= Arrays.asList(arr[i],arr[j],arr[k]);
                        list.sort(null);
                        set.add(list);
                    }
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>(set);
        return ans;
    }

}
