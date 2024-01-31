package Arrays.EasyProblems;


/*
Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

Example :
Input Format: arr[] = {2,2,1}
Result: 1
Explanation: In this array, only the element 1 appear once and so it is the answer.
 */

public class FindNumberThatAppearsOnce {
    public static void main(String[] args) {
        int[] arr={4,1,2,1,2};
        int ans=BruteSolution(arr);
        System.out.println(ans);
    }

    public static int BruteSolution(int[] arr){
        int n= arr.length;

        for (int i = 0; i < n; i++) {
            int num=arr[i];
            int count=0;

            for (int j = 0; j < n; j++) {
                if(arr[j]==num){
                    count++;
                }
            }

            if(count==1){
                return num;
            }
        }
        return -1;
    }
    //Time Complexity: O(N²)
    //Space Complexity: O(1)


}
