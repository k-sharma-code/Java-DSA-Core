package Arrays;

import java.util.Scanner;

public class TrappingRainWater {
    /*
    ================================================================
        APPROACH 1 : PREFIX - SUFFIX ARRAY
        Time complexity : O(n)
        Space complexity : O(n)
    ================================================================
    */

    public static int trapPrefixSuffix(int[] height ){
        int n = height.length;
        if(n <= 2) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        //Calculate leftMax array
        for(int i = 1 ; i < n ; i++){
            leftMax[i] = Math.max(leftMax[i-1] , height[i]);
        }

        //calculate rightMax array
        for(int i = n-2 ; i >= 0 ;i--){
            rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        }

        //calculate total trapped water
        int totalWater = 0;
        for(int i = 0 ; i < n ; i++){
            totalWater += Math.min(leftMax[i] , rightMax[i]) - height[i];
        }

        return totalWater;
    }

    /*
    =======================================================================
        APPROACH 2 : TWO POINTER
        Time complexity : O(n)
        Space complexity : O(1)
    =======================================================================
     */

    public static int trapTwoPointer(int[] height  ){
        int n = height.length;
        if(n <= 2) return 0;
        int water = 0;
        int left = 0 , right = n-1;
        int leftMax = 0 , rightMAx = 0;

        while(left < right){
            leftMax = Math.max(leftMax , height[left]);
            rightMAx = Math.max(rightMAx , height[right]);

            if(leftMax < rightMAx){
                water += leftMax - height[left];
                left++;
            }else{
                water += rightMAx - height[right];
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of = ");
        int n = sc.nextInt();

        int[] height = new int[n];
        System.out.print("Enter height of bars = ");
        for(int i = 0 ; i < n ; i++){
            height[i] = sc.nextInt();
        }

        int totalTrapWater1 = trapPrefixSuffix(height);
        int totalTrapWater2 = trapTwoPointer(height);

        System.out.println("Trapped water using prefix-suffix = "+totalTrapWater1);
        System.out.println("trapped water using two pointers = "+totalTrapWater2);

        sc.close();
    }
}
