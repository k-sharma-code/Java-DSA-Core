package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] mat){
        if(mat.length == 0 || mat[0].length==0 ){
            return new ArrayList<>();
        }
        int m = mat.length;
        int n =mat[0].length;

        int stRow = 0, endRow = m-1;
        int stCol = 0, endCol = n-1;

        List<Integer> ans = new ArrayList<>();
        while(stRow <= endRow && stCol <= endCol){
            // top boundary
            for (int j = stCol; j <= endCol; j++){
                ans.add(mat[stRow][j]);
            }

            // Right boundary
            for (int i = stRow + 1; i <= endRow; i++){
                ans.add(mat[i][endCol]);
            }

            // bottom boundary
            for (int j = endCol-1; j >= stCol; j--){
                if(stRow == endRow) break;
                ans.add(mat[endRow][j]);
            }

            // Left boundary
            for (int i = endRow-1; i >= stRow+1; i--){
                if(stCol == endCol) break;
                ans.add(mat[i][stCol]);
            }
            stRow++; stCol++;
            endRow--; endCol--;
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows and cols :");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] mat = new int[m][n];
        System.out.println("Enter elements of matrix : ");
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        List<Integer> finalAns = spiralOrder(mat);
        for (int ele : finalAns){
            System.out.print(ele+" ");
        }

        sc.close();
    }
}
