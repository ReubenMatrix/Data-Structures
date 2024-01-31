package Arrays.HardProblems;

import java.util.ArrayList;
import java.util.HashMap;

/*
 Given an array of N integers. Find the elements that appear more than N/3 times in the array.
 If no such element exists, return an empty vector.

Example :
Input Format: N = 5, array[] = {1,2,2,3,2}
Result: 2
Explanation: Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.
Therefore, the count of 2 is greater than N/3 times.
Hence, 2 is the answer.
 */

public class MajorityElementGreaterThanNby3 {
    public static void main(String[] args) {
        int[] arr={11, 11, 33, 33, 33, 11 };
        ArrayList<Integer> ans=BruteSolution(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }

        System.out.println();

        ArrayList<Integer> ans2=BetterSolution(arr);
        for (int i = 0; i < ans2.size(); i++) {
            System.out.print(ans2.get(i)+" ");
        }

        System.out.println();

        int[] arr2 = {11, 33, 33, 11, 33, 11};
        ArrayList<Integer> result = OptimalSolution(arr2);
        System.out.println(result);




    }

    public static ArrayList<Integer> BruteSolution(int[] arr){
        int n= arr.length;
        ArrayList<Integer> list=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(list.size()==0 || list.get(0)!=arr[i]){
                int count=0;
                for (int j = 0; j < n; j++) {
                    if(arr[i]==arr[j]){
                        count++;
                    }
                }

                if(count>n/3){
                    list.add(arr[i]);
                }
            }
            if (list.size()==2)
                break;
        }
        return list;
    }
    //Time Complexity:O(N²)
    //Space Complexity: O(1)

    public static ArrayList<Integer> BetterSolution(int[] arr){
        int n= arr.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();

        int min=(int)n/3+1;

        for (int i = 0; i < n; i++) {
            int val= map.getOrDefault(arr[i],0);
            map.put(arr[i],val+1);

            if(map.get(arr[i])==min){
                list.add(arr[i]);
            }
            if(list.size()==2)
                break;
        }
        return list;
    }
    //Time Complexity: O(N logN)
    //Space Complexity: O(N)

    public static ArrayList<Integer> OptimalSolution(int[] arr) {
        int n = arr.length-1;
        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && element2 != arr[i]) {
                count1 = 1;
                element1 = arr[i];
            } else if (count2 == 0 && element1 != arr[i]) {
                count2 = 1;
                element2 = arr[i];
            } else if (arr[i] == element1) {
                count1++;
            } else if (arr[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element1) {
                count1++;
            } else if (arr[i] == element2) {
                count2++;
            }
        }

        int min = (int) (n / 3) + 1;

        if (count1 > min) {
            list.add(element1);
        }
        if (count2 > min) {
            list.add(element2);
        }

        return list;
    }


}
