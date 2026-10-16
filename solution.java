public class RobotGridPaths {
    public static int uniquePaths(int m, int n, int[][] blocked) {
        int[][] dp = new int[m][n];
        if (blocked[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (blocked[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) dp[i][j] += dp[i-1][j];
                    if (j > 0) dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] blocked = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(uniquePaths(3,3,blocked)); // Output: 2
    }
}
