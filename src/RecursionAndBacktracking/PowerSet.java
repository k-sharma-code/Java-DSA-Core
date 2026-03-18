package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PowerSet {
    public static List<String> allPossibleStrings(String s) {
        List<String> list = new ArrayList<>();
        subsets("", s, 0, list);
        Collections.sort(list);

        return list;
    }

    private static void subsets(String ans, String s, int idx, List<String> list) {
        //base case
        if (idx == s.length()) {

            if (!ans.isEmpty()) {
                list.add(ans);
            }
            return;
        }

        char ch = s.charAt(idx);
        // pick
        subsets(ans + ch, s, idx + 1, list);
        // skip
        subsets(ans, s, idx + 1, list);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String = ");
        String s = sc.nextLine();

        List<String> result = allPossibleStrings(s);

        System.out.println(result);

        sc.close();
    }
}
