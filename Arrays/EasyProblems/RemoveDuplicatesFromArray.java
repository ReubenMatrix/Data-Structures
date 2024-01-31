package Arrays.EasyProblems;
import java.util.HashSet;

/*
 Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once.
 The relative order of the elements should be kept the same.

Example :

Input: arr[1,1,2,2,2,3,3]
Output: arr[1,2,3,_,_,_,_]
Explanation: Total number of unique elements are 3, i.e[1,2,3] and
Therefore return 3 after assigning [1,2,3] in the beginning of the array.
 */

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] arr={1,5,3,2,5,4};

        int ans=BruteSolution(arr);
        for(int i=0;i<ans;i++){
            System.out.print(arr[i]+" ");
        }

        int ans2=OptimalSolution(arr);
        for (int i = 0; i < ans2; i++) {
            System.out.print(arr[i]+"");
        }
    }

    static int BruteSolution(int[] arr){
        HashSet<Integer> set=new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int k= set.size();
        int j=0;

        for(int x:set){
            arr[j++]=x;
        }
        return k;
    }
    //Time Complexity: O((N logN) + N)
    //Space Complexity: O(N)

    public static int OptimalSolution(int[] arr){
        int i=0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=arr[i]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
}
