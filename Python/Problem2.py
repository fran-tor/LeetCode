class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        patches=0
        i=0
        sumatory=0
        length=len(nums)
        while sumatory<n:
            if i<length and nums[i]<=sumatory+1:
                sumatory+=nums[i]
                i+=1
            else:
                patches+=1
                sumatory+=(sumatory+1)
        return patches