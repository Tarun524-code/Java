class Solution {
    public int firstUniqueFreq(int[] nums) {
       int maxVal = 0;
       for(int num : nums) {
        if(num > maxVal) maxVal = num;
       }
       int arr[] = new int[maxVal+1];
       for(int num : nums) arr[num] += 1;
       int freq[] = new int[nums.length+1];
       for(int num : arr) freq[num] += 1;
       for(int n : nums) {
        if(freq[arr[n]]==1) return n;
       }
       return -1;
    }
}