package TwoPointers;/*
You are given an integer array height of length n. There are n vertical lines drawn such that
the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
 */

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights={1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result1=BruteSolution(heights);
        int result2=OptimalSolution(heights);
        System.out.println("Maximum Area: "+result1);
        System.out.println("Maximum Area: "+result2);

    }

    public static int BruteSolution(int[] heights){
        int maxArea=0;

        for (int i = 0; i < heights.length-1 ; i++) {
            for (int j = i+1; j < heights.length; j++) {
                int h=Math.min(heights[i],heights[j]);
                int w=j-i;
                int area= h*w;
                maxArea=Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
    //Time Complexity:O(N²)
    //Space Complexity: O(1)

    public static int OptimalSolution(int[] heights){
        int maxArea=0;
        int left=0;
        int right=heights.length-1;

        while(left<right){
            int h=Math.min(heights[left],heights[right]);
            int w=right-left;
            int area=h*w;
            maxArea=Math.max(maxArea,area);

            if(heights[left]<heights[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(1)
}
