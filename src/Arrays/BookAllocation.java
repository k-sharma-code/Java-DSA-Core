package Arrays;

import java.util.Scanner;

public class BookAllocation {
    public static int allocateBook(int[] arr, int m){

        int n = arr.length;
        if( n < m) return -1;

        int sum = 0 , maxElement = 0;
        for (int ele : arr){
            sum += ele;
            maxElement = Math.max(maxElement , ele);
        }

        int st = maxElement , end = sum; // range of possible ans
        int ans = -1;

        while(st <= end){

            int mid = st + (end - st)/2;

            if(isValid(arr, mid, m)){ // left
                ans = mid;
                end = mid - 1;
            }else{ //right
                st = mid +1;
            }
        }

        return ans;
    }

    private static boolean isValid(int[] arr, int maxAllowedPages, int m){

        int student = 1 , pages = 0;

        for (int i = 0; i < arr.length; i++){
            if(arr[i] > maxAllowedPages) return false;

            if(pages + arr[i] <= maxAllowedPages){
                pages += arr[i];
            }else{
                student++;
                pages = arr[i];
            }
        }

        return student <= m;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array = ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter no: of Pages in each Book = ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter no: of Student = ");
        int m = sc.nextInt();

        System.out.println(allocateBook(arr,m));

        sc.close();
    }
}
