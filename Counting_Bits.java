class Solution {
    public int[] countBits(int num) {
        int[] counts = new int[num + 1];
    for (int i = 0; i<=num ; i++) {
      if(i%2 != 0) {
        counts[i]  = counts[i/2]+1;
      } else {
          counts[i] = counts[i/2];
      }
    }
    return counts;
   }
}
