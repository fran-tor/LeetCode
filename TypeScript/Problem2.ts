function minPatches(nums: number[], n: number) {
    let patches=0
    let i =0 
    let sumatory=0
    const length= nums.length
    while (sumatory<n) {
        if (i<length && nums[i]<=sumatory+1){
            sumatory+= nums[i]
            i++
        }
        else {
            patches++
            sumatory+=(sumatory+1)
        }
    }
    return patches
};