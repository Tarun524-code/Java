class Solution {
    public int numDistinct(String s, String t) {
        int i = s.length();
        int j = t.length();
        int[][] dp = new int[i][j];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return f(s,t,i-1,j-1,dp);
    }
    private int f(String s, String t,int i, int j,  int[][] dp) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(i<j) return 0;
        if(dp[i][j]!= -1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) {
            return dp[i][j] = f(s,t,i-1,j-1,dp)+f(s,t,i-1,j,dp);
        }
        return dp[i][j] = f(s,t,i-1,j,dp);
    }
}