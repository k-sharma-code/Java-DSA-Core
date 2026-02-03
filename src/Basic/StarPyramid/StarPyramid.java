package Basic.StarPyramid;

import java.util.Scanner;

public class StarPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter n = ");
        int n = sc.nextInt();
        // nsp for spaces ans nst for stars
        int nsp = n-1, nst = 1;
        for(int i = 1 ; i<=n ; i++){
            for(int j = 1; j<=nsp ; j++){
                System.out.print("  ");
            }
            for(int k = 1 ; k<= nst ; k++){
                System.out.print("* ");
            }
            nsp--;
            nst+=2;
            System.out.println();
        }

    }
}
