package Arrays.MediumProblems;


/*
 You are given an array of prices where prices[i] is the price of a given stock on an ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example :
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and
sell on day 5 (price = 6), profit = 6-1 = 5.
 */

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        int ans=BruteSolution(arr);
        System.out.println(ans);

        int ans2=OptimalSolution(arr);
        System.out.println(ans2);

    }

    public static int BruteSolution(int[] arr){
        int n= arr.length;
        int maxProfit=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[j]>arr[i]){
                    maxProfit=Math.max(arr[j]-arr[i],maxProfit);
                }
            }
        }
        return maxProfit;
    }
    //Time Complexity: O(N²)
    //Space Complexity: O(1)

    public static int OptimalSolution(int[] arr){
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            minPrice=Math.min(minPrice, arr[i]);
            maxProfit=Math.max(maxProfit,arr[i]-minPrice);
        }
        return maxProfit;
    }
    //Time Complexity: O(N)
    //Space Complexity: O(1)
}
