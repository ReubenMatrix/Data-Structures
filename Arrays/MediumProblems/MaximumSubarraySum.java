package Arrays.MediumProblems;

/*
Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Example:
Input: arr = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
 */

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        int ans=BruteSolution(arr);
        System.out.println(ans);

        int ans2=BetterSolution(arr);
        System.out.println(ans2);

        long ans3=OptimalSolution(arr);
        System.out.println(ans3);

    }

    public static int BruteSolution(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum=0;
                for (int k = i; k < j; k++) {
                    sum+=arr[k];
                }
                max=Math.max(max,sum);
            }
        }
        return max;
    }

    //Time Complexity: O(N³)
    //Space Complexity: O(1)

    public static int BetterSolution(int[] arr){
        int n= arr.length;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j = i; j < n; j++) {
                sum+=arr[j];
                max=Math.max(max,sum);
            }

        }
        return max;
    }
    //Time Complexity: O(N²)
    //Space Complexity: O(1)

    public static long OptimalSolution(int[] arr){
        long sum=0;
        long max=Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            sum+=arr[i];

            if(sum>max){
                max=sum;
            }

            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)

}
