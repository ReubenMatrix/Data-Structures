package SortingAlgos;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1, 5, 8};
        bubble_sort(arr);

    }

    public static void bubble_sort(int[] arr){
        int n = arr.length;

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            System.out.print("Iteration " + (n - i) + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();

        }

        System.out.println("Sorted List:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    //Time Complexity: O(N²)
}
