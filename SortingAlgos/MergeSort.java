package SortingAlgos;

import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={4,2,3,8,6,1};
        merge_sort(arr,0, arr.length-1);

        System.out.println("Sorted List:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void merge_sort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int mid = (low + high)/2;
        merge_sort(arr, low, mid);
        merge_sort(arr,mid+1,high);
        merge(arr,low, mid, high);
    }


    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    //Time Complexity: O(N logN)

}
