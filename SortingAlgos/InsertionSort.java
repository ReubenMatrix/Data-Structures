package SortingAlgos;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 1, 5, 2};
        insertion_sort(arr);

    }

    public static void insertion_sort(int[] arr){
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int j =i;
            while (j>0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        System.out.println("Sorted List: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    //Time Complexity: O(N²)
}
