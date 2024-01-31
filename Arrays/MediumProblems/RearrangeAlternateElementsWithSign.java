package Arrays.MediumProblems;

import java.util.ArrayList;


/*
There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements.
Without altering the relative order of positive and negative elements,
you must return an array of alternately positive and negative values.

Example:
Input:
arr[] = {1,2,-4,-5}, N = 4
Output:
1 -4 2 -5
 */

public class RearrangeAlternateElementsWithSign {
    public static void main(String[] args) {
        int[] arr={1,2,-3,-1,-2,-3};
        int[] ans=BruteSolution(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }

        int[] arr2 = {1, -2, 3, -4, 5};
        ArrayList<Integer> result = OptimalSolution(arr2);
        System.out.println();
        System.out.println(result);

    }

    public static int[] BruteSolution(int[] arr){
        int n= arr.length-1;
        ArrayList<Integer> positives=new ArrayList<>();
        ArrayList<Integer> negatives=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(arr[i]>0){
                positives.add(arr[i]);
            }else {
                negatives.add(arr[i]);
            }
        }

        for (int i = 0; i < n/2; i++) {
            arr[2*i]=positives.get(i);
            arr[2*i+1]=negatives.get(i);
        }

        return arr;
    }
    //Time Complexity: O(N + N/2)
    //Space Complexity: O(N)

    public static ArrayList<Integer> OptimalSolution(int[] arr){
        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();
        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans.add(posIndex, arr[i]);
                posIndex += 2;
            } else {
                ans.add(negIndex, arr[i]);
                negIndex += 2;
            }
        }

        while (posIndex < n) {
            ans.add(arr[posIndex]);
            posIndex += 2;
        }

        while (negIndex < n) {
            ans.add(arr[negIndex]);
            negIndex += 2;
        }

        return ans;

    }
    //Time Complexity: O(N)
    //Space Complexity: O(N)
}
