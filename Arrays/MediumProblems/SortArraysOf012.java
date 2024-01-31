package Arrays.MediumProblems;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array consisting of only 0s, 1s, and 2s.
Write a program to in-place sort the array without using inbuilt sort functions.
( Expected: Single pass-O(N) and constant space)

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 */

public class SortArraysOf012 {
    public static void main(String[] args) {
        int[] arr={2, 1, 0 ,1 , 1, 2, 2, 0};
        int[] ans=BruteSolution(arr);
        System.out.println(Arrays.toString(ans));


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(1);
        System.out.println("Original List: " + list);
        BetterSolution(list);
        System.out.println("Sorted List: " +list);


        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(0);
        list1.add(2);
        list1.add(1);
        list1.add(0);
        list1.add(2);
        list1.add(1);
        System.out.println("Original List: " + list1);
        OptimalSolution(list1);
        System.out.println("Modified List: " + list1);

    }

    public static int[] BruteSolution(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
    //Time Complexity: O(N LogN)
    //Space Complexity: O(1)

    public static void BetterSolution(ArrayList<Integer> arr){
        int count0=0, count1=0, count2=0;
        int n= arr.size();

        for (int i = 0; i < n; i++) {
            if(arr.get(i)==0){
                count0++;
            }
            if (arr.get(i)==1){
                count1++;
            }
            if (arr.get(i)==2){
                count2++;
            }
        }

        for (int i = 0; i < count0; i++) {
            arr.set(i,0);
        }
        for (int i = count0; i <count0 + count1; i++) {
            arr.set(i,1);
        }
        for (int i =count0 + count1; i < n; i++) {
            arr.set(i,2);
        }
    }
    //Time Complexity: O(2N)
    //Space Complexity: O(1)

    public static void OptimalSolution(ArrayList<Integer> arr){
        int low=0, mid=0, high= arr.size()-1;

        while(mid<high){
            if(arr.get(mid)==0){
                int temp= arr.get(low);
                arr.set(low,arr.get(mid));
                arr.set(mid,temp);

                low++;
                mid++;
            } else if (arr.get(mid)==1) {
                mid++;
            }else {
                int temp= arr.get(mid);
                arr.set(mid,arr.get(high));
                arr.set(high,temp);

                high--;
            }
        }
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
}
