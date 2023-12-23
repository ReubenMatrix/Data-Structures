package TwoPointers;/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2]
 */




public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result1 = BruteSolution(numbers, target);
        int[] result2=OptimalSolution(numbers,target);

        System.out.println("Indices of the two numbers: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("["+result2[0]+", " +result2[1]+"]");
    }

    public static int[] BruteSolution(int[] nums,int target){
        int[] result=new int[2];
        for (int i = 0; i < nums.length-1 ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    result[0]=i+1;
                    result[1]=j+1;
                }
            }
        }
        return result;
    }
    //Time Complexity: O(N²)
    //Space Complexity:O(1)


    public static int[] OptimalSolution(int[] nums,int target){
        int left=0;
        int right= nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            } else if (sum<target) {
                left++;
            }else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
}
