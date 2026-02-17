package Sorting;

import java.util.Scanner;

public class InsertionSort {
    public static boolean insertionSort(int[] nums , int n){
        //flag to detect if any shifting happens
        boolean shifted = false ;
        for(int i = 1 ; i < n ; i++){
            //store current element
            int current = nums[i];
            //index of previous element
            int prev = i - 1;

            while(prev >= 0 && nums[prev] > current){

                //shift element to the right
                nums[prev + 1] = nums[prev];
                prev--;
                shifted = true;
            }
            //insert current element at its correct position.
            nums[prev + 1] = current;
        }
        return shifted;
    }

    public static void print(int[] nums , int n){
        for(int i = 0; i < n ; i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array = ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter Array elements = ");
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }

        boolean changed = insertionSort(nums , n);
        if(!changed){
            System.out.print("Array was already sorted = ");
            print(nums , n);
        }else{
            System.out.print("Sorted Array = ");
            print(nums , n);
        }

        sc.close();
    }
}
