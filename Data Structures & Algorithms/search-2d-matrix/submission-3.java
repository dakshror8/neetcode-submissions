class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // find right row to search
        int l=0, r=m-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(target > matrix[mid][n-1]){
                l = mid+1;
            }
            else if(target < matrix[mid][0]){
                r = mid-1;
            }
            else{
                l = mid;
                break;
            }
        }
        int row = l;
        l = 0;
        r = n-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(target > matrix[row][mid]){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return false;
    }
}
