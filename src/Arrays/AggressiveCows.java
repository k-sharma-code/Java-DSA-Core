package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static int getDistance(int[] stalls , int c){
        Arrays.sort(stalls);
        int n = stalls.length;

        int st = 1 , end = stalls[n-1] - stalls[0] ;
        int ans = -1;

        while(st <= end){ // O(log(range)*n)
            int mid = st + (end - st)/2;

            if (isPossible(stalls, c, mid)) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] stalls , int c , int minAllowedDist){
        int cows = 1, lastStallPos = stalls[0];

        for (int i = 1; i < stalls.length; i++){
            if (stalls[i]-lastStallPos >= minAllowedDist){
                cows++;
                lastStallPos = stalls[i];
            }

            if(cows == c) return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array = ");
        int n = sc.nextInt();

        int[] stalls = new int[n];
        System.out.print("Enter position of each stall = ");
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        System.out.print("Enter number of Cows = ");
        int c = sc.nextInt();

        System.out.println(getDistance(stalls , c));

        sc.close();
    }
}
