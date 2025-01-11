class Solution {
    public int minPatches(int[] nums, int n) {
        int patches=0;
        int i=0;
        long sumatory=0;
        int length= nums.length;
        while (sumatory<n) {
            if (i<length && nums[i]<=sumatory+1){
                sumatory+= nums[i];
                i++;
            } else {
                patches++;
                sumatory+=(sumatory+1);
            }
        }
        return patches;
    }
}