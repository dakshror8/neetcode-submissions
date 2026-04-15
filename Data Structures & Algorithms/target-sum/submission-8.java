class Solution {
    int[][] t;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, zeroCount = 0;
        for(int i : nums){
            if(i == 0) zeroCount++;
            else{
                sum += i;
            }
        }
        // target+sum should be positive and even
        if((target+sum) < 0 || (target+sum) % 2 != 0) return 0;
        int[] newArr = new int[nums.length - zeroCount];
        int idx = 0;
        for(int i : nums){
            if(i != 0){
                newArr[idx++] = i;
            }
        }
        int subsetSum = (target + sum) / 2;
        int res = countSubsetSum(newArr, subsetSum);

        return res * (int)Math.pow(2, zeroCount);
    }
    private int countSubsetSum(int[] arr, int sum){
        int n = arr.length;
        t = new int[n+1][sum+1];
        // Initialisation
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i == 0){
                    t[i][j] = 0;
                }
                if(j == 0){
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
