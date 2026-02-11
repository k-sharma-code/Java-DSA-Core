package Arrays;

import java.util.Scanner;

public class MaxProductSubarray {
    public static int maxProduct(int[] nums ) {
        // Initialize values using first element
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];
        // traversing array from 2nd element or 1st index
        for(int i = 1 ; i < nums.length ; i++){
            int current = nums[i];
            if(current < 0){ // if current element is negative then swap max and min
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(current , current * maxProd);
            minProd = Math.min(current , current * minProd);
            result = Math.max(maxProd , result);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size = ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter Array elements = ");
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }

        int ans = maxProduct(nums);
        System.out.print("Maximum Product Subarray = "+ans);

        sc.close();
    }
}
