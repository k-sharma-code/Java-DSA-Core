package Sorting;

import java.util.Scanner;

public class BubbleSort {
    public static boolean bubbleSort(int[] nums , int n ) {

        boolean alreadySorted = true;

        for(int i = 0 ; i < n - 1 ; i++){

           boolean isSwap = false;
           for(int j = 0 ; j < n - 1 - i ; j++){
                //ascending order
               if(nums[j] > nums[j+1]){
                   //swap
                   int temp= nums[j];
                   nums[j] = nums[j+1];
                   nums[j+1] = temp;
                   isSwap = true;
                   alreadySorted = false;
               }
           }
           //if no swap means array already sorted
           if(!isSwap) break;
        }
        return alreadySorted;
    }

    public static void print(int[] nums){
        for(int i = 0; i < nums.length ; i++){
            System.out.print(nums[i]+" ");
        }
    }

   public static void main(String[] args ) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter size of array = ");
       int n = sc.nextInt();

       int[] nums = new int[n];
       System.out.print("Enter elements of array = ");
       for(int i = 0 ; i < n ; i++){
           nums[i] = sc.nextInt();
       }

       boolean isSorted = bubbleSort(nums , n);

       if(!isSorted){
           System.out.print(" Sorted Array = ");
           print(nums);
       }else{
           System.out.print("Array was already sorted = ");
           print(nums);
       }

       sc.close();
    }
}
