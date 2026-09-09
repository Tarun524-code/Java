class Solution {
    public long countCommas(long n) {
        int len = String.valueOf(n).length();
        long c = 0, p = 1;
        for (int i = 1; i < len; i++, p *= 10) {
            c += 9 * p * ((i - 1) / 3);
        }
        return c + (n - p + 1) * ((len - 1) / 3);
    }
}