package Arrays;

import java.util.Scanner;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        //find pivot
        for(int i = n-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        // swap pivot with just larger element
        if(pivot != -1){
            for(int j = n-1 ; j >= 0 ; j--){
                if(nums[j] > nums[pivot]){
                    swap(nums , pivot , j);
                    break;
                }
            }
        }
        // reverse suffix
        reverse(nums , pivot + 1 , n - 1 );
    }

    private static void swap(int[] nums , int st , int end) {
        int temp = nums[st];
        nums[st] = nums[end];
        nums[end] = temp;
    }

    private static void reverse(int[] nums , int left , int right){
        while(left < right){
            swap(nums , left++ , right--);
        }
    }

    public static void print(int[] nums) {
        System.out.print("Next Permutation = ");
        for(int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array = ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter Elements of array = ");
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }

        nextPermutation(nums);
        print(nums);

        sc.close();
    }
}
