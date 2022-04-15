// https://leetcode.com/contest/biweekly-contest-74/problems/minimum-white-tiles-after-covering-with-carpets/
package biweekly_74;

public class Q4_Minimum_White_Tiles_After_Covering_With_Carpets {
    public static int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int[][] dp = new int[floor.length() + 1][numCarpets + 1];
        for (int i = 1; i <= floor.length(); i++) {
            for (int j = 0; j <= numCarpets; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + floor.charAt(i - 1) - '0',
                        j > 0 ? i - carpetLen < 0 ? 0 : dp[i - carpetLen][j - 1] : Integer.MAX_VALUE);
                System.out.println(dp[i][j]);
            }
        }
        return dp[floor.length()][numCarpets];
    }
    public static void main(String[] args){
        String floor = "10110101";
        int numCarpets = 2;
        int carpetLen = 2;
        int result = minimumWhiteTiles(floor, numCarpets, carpetLen);
        System.out.println(result);
    }
}
