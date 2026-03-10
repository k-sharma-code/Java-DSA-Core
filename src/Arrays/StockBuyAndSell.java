package Arrays;

import java.util.Scanner;

public class StockBuyAndSell {
    public static int maxProfit(int[] prices ){

        int maxProfit = 0 ;
        int minPrice = prices[0];
        for (int i = 1 ; i < prices.length ; i++){
            if(prices[i] > minPrice){
                maxProfit = Math.max( maxProfit , prices[i] - minPrice);
            }
            minPrice = Math.min( minPrice , prices[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args){
        Scanner sC = new Scanner(System.in);
        System.out.print("Enter size of Array = ");
        int n = sC.nextInt();

        int[] prices = new int[n];
        System.out.print("Enter Prices = ");
        for (int i = 0 ; i < n ; i++){
            prices[i] = sC.nextInt();
        }

        int ans = maxProfit(prices);
        System.out.println("profit " + ans);

        sC.close();
    }
}
