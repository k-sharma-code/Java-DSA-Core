package Arrays;

import java.util.Scanner;

public class MajorityElement {
    public static int majorityElement(int[] nums){
        int n = nums.length;

        int freq = 0 , ans = 0;

        for(int i = 0; i < n; i++){
            if(freq == 0){
                ans = nums[i];
            }
            if(ans == nums[i]){
                freq++;
            }else {
                freq--;
            }
        }

        //verification
        int count = 0;
        for(int ele : nums){
            if(ele == ans){
                count++;
            }
        }
        if(count > n/2) {
            return ans;
        }
        return -1; // if no majority element exists
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array : ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter elements : ");
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println("Majority Element = "+majorityElement(nums));

        sc.close();

    }
}
