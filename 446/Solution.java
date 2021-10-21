class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; ++i) dp[i] = new HashMap<>();
        
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long delta = (long)nums[i] - (long)nums[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int cnt = dp[j].getOrDefault(delta, 0);
                dp[i].put(delta, dp[i].getOrDefault(delta, 0) + cnt + 1);
                ans += cnt;
            }
        }
        return ans;
    }  
}