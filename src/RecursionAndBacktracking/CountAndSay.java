package RecursionAndBacktracking;

import java.util.Scanner;

public class CountAndSay {
    public static String countAndSay(int n){
        // base case
        if( n== 1) return "1";

        String s = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();

        int i = 0, j= 0;

        while(j < s.length()) {

            if (s.charAt(i) == s.charAt(j)) {
                j++; // increment when characters are same
            } else {
                // calculating frequency
                int freq = j - i;
                ans.append(freq);
                ans.append(s.charAt(i));
                // // move 'i' to start of the next group
                i = j;

            }
        }
        // final append to handle the last consecutive group
        int freq = j - i;
        ans.append(freq);
        ans.append(s.charAt(i));

        return ans.toString();
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n = ");
        int n = sc.nextInt();

        if(n >= 1){

            String result = countAndSay(n);
            System.out.println("count and say Sequence at " + n + " = " + result);

        } else {

            System.out.println("Enter valid integer ");
        }

        sc.close();
    }
}
