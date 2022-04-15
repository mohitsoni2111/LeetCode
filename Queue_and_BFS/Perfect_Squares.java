// https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/

package Queue_and_BFS;

public class Perfect_Squares {
    public static int DP_numSquares(int n) {
        if(n<=3)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= n; i++){
            // Max value is i
            dp[i] = i;

            // Loop for min
            for(int x = 1; x <= Math.ceil(Math.sqrt(i)); x++){
                int temp = x * x;
                System.out.println("temp : " + temp);
                if(temp > i)
                    break;
                else {
                    System.out.println("dp[i] : " + dp[i]);
                    System.out.println("dp[i - temp] : " + dp[i - temp]);
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(DP_numSquares(6));
    }
}
