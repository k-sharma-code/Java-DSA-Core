package Sorting;

import java.util.Scanner;

public class SelectionSort {
    public static boolean isSorted(int[] arr,int n){
        for(int i = 0 ; i < n-1 ; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void selectionSort(int[] arr ,int n ){
        for(int i = 0 ; i < n-1 ; i++){
            int minIdx = i;
            for(int j = i+1 ; j < n ; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void print(int[] arr ){

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array = ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements = ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

       if(isSorted(arr,n)){
           System.out.print("Array was already sorted : ");
           print(arr);
       }else{
           selectionSort(arr,n);
           System.out.print("Sorted array  = ");
           print(arr);
       }

       sc.close();
    }

}
