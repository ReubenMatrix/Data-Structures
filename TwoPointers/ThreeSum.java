package TwoPointers;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example :
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1=BruteSolution(nums);
        List<List<Integer>> result2=OptimalSolution(nums);
        System.out.println("Triplets with sum 0 : "+result1);
        System.out.println("Triplets with sum 0 : "+result2);

    }

    public static List<List<Integer>> BruteSolution(int[] nums){
        List<List<Integer>> result=new ArrayList<>();

        Arrays.sort(nums);
        int n= nums.length;

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum=nums[i]+nums[j]+nums[k];

                    if(sum==0){
                        List<Integer> triplet= asList(nums[i],nums[j],nums[k]);
                        if(!result.contains(triplet)){
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }
    //Time Complexity:O(N³) + O(N Log N)
    //Space Complexity: O(N²)

    public static List<List<Integer>> OptimalSolution(int[] nums){
        List<List<Integer>> result=new ArrayList<>();

        Arrays.sort(nums);
        int n= nums.length;

        for (int i = 0; i < n-2; i++) {
            if(i>0 && nums[i]>nums[i+1]){
                continue;
            }

            int left=i+1;
            int right=n-1;

            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(asList(nums[i], nums[left], nums[right]));


                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum<0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }
    //Time Complexity: O(N²) +  O(N Log N)
    //Space Complexity:O(N²)




}
