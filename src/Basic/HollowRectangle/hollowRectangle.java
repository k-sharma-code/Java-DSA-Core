package Basic.HollowRectangle;

import java.util.Scanner;

public class hollowRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Rows = ");
        int m = sc.nextInt();
        System.out.print("Enter number of Cols = ");
        int n = sc.nextInt();

        for(int i = 1; i<=m ; i++){ // outer loop
            for(int j = 1 ; j<=n ; j++){ // inner loop
                if(i==1 || i==m || j==1 || j==n){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
