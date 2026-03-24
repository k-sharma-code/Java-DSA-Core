package Sorting;

import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] arr, int st, int end){

        if(st == end) return;
        int mid = st + (end-st)/2;

        mergeSort(arr, st, mid); // left half
        mergeSort(arr, mid+1, end); // right half

        merge(arr, st, mid , end);

    }

    private static void merge(int[] arr, int st, int mid, int end){

        int[] temp = new int[end - st + 1];
        int i = st;
        int j = mid +1;
        int k = 0;

        // merge both halves
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        // left remaining elements
        while (i <= mid){
            temp[k++] = arr[i++];
        }

        // right remaining elements
        while(j <= end){
            temp[k++] = arr[j++];
        }

        // copy back to original array
        for (int idx = 0; idx < temp.length; idx++){
            arr[idx + st] = temp[idx];
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of Array = ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter Elements of array = ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n-1);
        for (int ele : arr){
            System.out.print(ele+" ");
        }

        sc.close();
    }
}
