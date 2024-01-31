package Arrays.EasyProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/*
Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
The union of two arrays can be defined as the common and distinct elements in the two arrays.

Example :
Input:
n = 5,m = 5.
arr1[] = {1,2,3,4,5}
arr2[] = {2,3,4,4,5}
Output: {1,2,3,4,5}
 */

public class FindUnion {
    public static void main(String[] args) {
        int[] arr1={5, 6, 2, 8, 1, 9};
        int[] arr2={7, 5, 2, 9, 10};
        ArrayList <Integer> ans=new ArrayList<>();
        ans=BruteSolution(arr1, arr2);
        System.out.println(ans);

        ArrayList<Integer> ans2=new ArrayList<>();
        ans2=BetterSolution(arr1,arr2);
        System.out.println(ans2);

        ArrayList<Integer> ans3=new ArrayList<>();
        ans3=OptimalSolution(arr1,arr2);
        System.out.println(ans3);

    }

    public static ArrayList<Integer> BruteSolution(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> union=new ArrayList<>();

        int n= arr1.length;
        int m= arr2.length;

        for (int i = 0; i < n; i++) {
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1 );
        }
        for (int i = 0; i < m; i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i],0)+1);
        }

        union.addAll(map.keySet());

        return union;
    }
    //Time Complexity: O(M+N Log(M+N))
    //Space Complexity: O(M+N)

    public static ArrayList<Integer> BetterSolution(int[] arr1,int[] arr2){
        Set<Integer> st=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();

        int n= arr1.length;
        int m= arr2.length;

        for (int i = 0; i < n; i++) {
            st.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            st.add(arr2[i]);
        }

        list.addAll(st);
        return list;
    }
    //Time Complexity: O(M+N Log(M+N))
    //Space Complexity: O(M+N)


    public static ArrayList<Integer> OptimalSolution(int[] arr1, int[] arr2){
        ArrayList<Integer> list=new ArrayList<>();

        int n= arr1.length;
        int m= arr2.length;

        int i=0,j=0;
        while(i<n && j<m){
            if (arr1[i] <= arr2[j]) {
                if(list.size()==0 || list.get(list.size()-1)!=arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
            }else {
                if(list.size()==0 || list.get(list.size()-1)!=arr2[j]){
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<n){
            if(list.get(list.size()-1)!=arr1[i]){
                list.add(arr1[i]);
            }
            i++;
        }

        while(j<m){
            if(list.get(list.size()-1)!=arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }

        return list;
    }
    //Time Complexity: O(M+N)
    //Space Complexity: O(1)
}
