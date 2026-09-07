class Solution {
    public static final int mod = 1000000007;
    public int distinctSubseqII(String s) {
        int end[] = new int[26];
        int total = 0;
        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            int oldtotal = total;
            int Newsubseq = (oldtotal + 1 - end[idx]+mod)%mod;
            total = (total+Newsubseq)%mod;
            end[idx] = (end[idx]+Newsubseq)%mod;
        }
        return total;
    }
}