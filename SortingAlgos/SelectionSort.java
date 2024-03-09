package SortingAlgos;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 4, 1, 8};
        selection_sort(arr);

    }

    public static void selection_sort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            System.out.print("Iteration " + (i+1) + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }

        System.out.println("Sorted List: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    //Time Complexity: O(N²)
}
