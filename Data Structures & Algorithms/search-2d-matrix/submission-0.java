class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m-1;
        while(top <= bottom){
            int row = top+(bottom-top)/2;
            if(target < matrix[row][0]){
                bottom = row-1;
            }
            else if(target > matrix[row][n-1]){
                top = row+1;
            }
            else{
                break;
            }
        }  
        
        if(top > bottom){
            return false;
        }

        int row = top+(bottom-top)/2;
        int l=0, r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(target == matrix[row][mid]){
                return true;
            }
            else if(target < matrix[row][mid]){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return false;
    }
}
