package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {

        List<String> ans = new ArrayList<>();

        generate(n, 0, 0, "", ans);

        return ans;
    }

    private static void generate(int n, int left, int right, String current, List<String> ans) {

        // Base Case
        if (right == n) {
            ans.add(current);
            return;
        }

        // Add '(' if we still have left brackets available
        if (left < n) {
            generate(n, left + 1, right, current + "(", ans);
        }

        // Add ')' only if it keeps the sequence valid
        if (right < left) {
            generate(n, left, right + 1, current + ")", ans);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pairs: ");
        int n = sc.nextInt();

        List<String> result = generateParentheses(n);

        System.out.println("Valid Parentheses Combinations:");

        for(String str : result){
            System.out.println(str);
        }

        sc.close();
    }
}
