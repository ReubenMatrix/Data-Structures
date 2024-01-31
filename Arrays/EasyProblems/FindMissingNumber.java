package Arrays.EasyProblems;


/*
Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N.
Find the number(between 1 to N), that is not present in the given array.

Example :
Input Format: N = 5, array[] = {1,2,4,5}
Result: 3
Explanation: In the given array, number 3 is missing. So, 3 is the answer.
 */


public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5, 7, 8};
        int ans=BruteSolution(arr);
        System.out.println(ans);

        int ans2=BetterSolution(arr);
        System.out.println(ans2);

        int ans3=OptimalSolution(arr);
        System.out.println(ans3);

    }

    public static int BruteSolution(int[] arr){
        int n= arr.length;

        for (int i = 1; i < n+1; i++) {
            int flag=0;
            for (int j = 0; j < n; j++) {
                if(arr[j]==i){
                    flag=1;
                }
            }
            if(flag==0){
                return i;
            }
        }

        return -1;
    }
    //Time Complexity: O(N²)
    //Space Comlexity: O(1)

    public static int BetterSolution(int[] arr){
        int n=arr.length;
        int[] hash=new int[n+1];

        for (int i = 0; i < n-1; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }
    //Time Complexity: O(2N)
    //Space Complexity: O(N)


    public static int OptimalSolution(int[] arr){
        int n= arr.length;

        int sum=n*(n+1)/2;

        int s=0;
        for (int i = 0; i < n-1; i++) {
            s+=arr[i];
        }

        int missingNum=sum-s;
        return missingNum;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
}
