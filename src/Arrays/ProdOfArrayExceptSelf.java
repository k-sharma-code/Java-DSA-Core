package Arrays;

import java.util.Scanner;

public class ProdOfArrayExceptSelf {
    public static int[] productOfArrExceptSelf(int[] arr){
        int n = arr.length;
        int[] result = new int[n];

        // prefix product
        result[0] = 1;
        for (int i = 1 ; i < n ; i++){
            result[i] = result[i-1] * arr[i-1];
        }

        //suffix product
        int suffix = 1 ;
        for (int i = n-1 ; i >= 0 ; i--){
            result[i] *= suffix;
            suffix *= arr[i];
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array = ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements of Array = ");
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int[] ans = productOfArrExceptSelf(arr);
        for(int ele : ans){
            System.out.print(ele+" ");
        }

        sc.close();
    }
}
