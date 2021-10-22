class Solution {
    double M = 1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        double[][] dp = new double[n][fuel+1];
        dp[start][fuel] = 1;
        
        for (int f = fuel; f >= 0; f--) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == i) continue;
                    int gas = Math.abs(locations[i] - locations[j]);
                    if (f + gas <= fuel) {
                        dp[i][f] = (dp[i][f] + dp[j][f+gas]) % M;
                    }
                }
            } 
        }
        double res = 0;
        for (int f = 0; f <= fuel; f++) {
            res = (res + dp[finish][f]) % M;
        }
        return (int)res;
    }   
}
