package Arrays;

import java.util.HashSet;
import java.util.Scanner;

public class FindDuplicateNumber {
   /*
   ===============================================================
   Approach 1: Floyd's cycle Detection (slow - fast pointer )
   Constraints :
   - Array size = n+1
   - Numbers range = 1 to n.
   - At least one duplicate must exist
   Time complexity : O(n)
   space complexity : O(1)
   ===============================================================
    */
    public static int findDuplicate(int[] nums ){
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    /*
    ==============================================================
    Approach 2 : Hashset
    Constraints :
    - works for any integer array
    - Duplicate may or may not exist
    - Multiple Duplicate possible
    ==============================================================
     */
    public static int findDuplicateHashset(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for(int val : nums){
            if(set.contains(val)){
                return val;
            }
            set.add(val);
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array = ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter Array Elements = ");
        for (int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println("Choose approach :");
        System.out.println("1. Floyd cycle detection ");
        System.out.println("2. Hashset ");

        int choice = sc.nextInt();
        if(choice == 1 ){
            int result = findDuplicate(nums);
            System.out.println("Duplicate number = "+result);
        }else {
            int result = findDuplicateHashset(nums);
            if (result == -1) {
                System.out.println("No duplicate found ");
            } else {
                System.out.println("duplicate number = " + result);
            }
        }

        sc.close();

    }
}
