package RecursionAndBacktracking;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void hanoi(int n, char a, char b,char c) { // a = source rod , b = helper rod , c = destination rod
        if(n==0) return ;

        // take n-1 disk from a to b via c
        hanoi(n-1,a,c,b);

        //largest from a to b
        System.out.println(a+"->"+c);

        //take n-1 disk from b to c via a
        hanoi(n-1,b,a,c);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disk = ");
        int n = sc.nextInt();

        hanoi(n,'A','B','C');

        sc.close();
    }
}
