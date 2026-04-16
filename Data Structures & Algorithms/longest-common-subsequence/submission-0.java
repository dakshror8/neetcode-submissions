class Solution {
    int[][] t;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        t = new int[m+1][n+1];

        // Initialisation
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[m][n];
    }

    // private int lcsRec(String x, String y, int i, int j){
    //     if(i < 0 || j < 0){
    //         return 0;
    //     }

    //     if(x.charAt(i) == y.charAt(j)){
    //         return 1 + lcsRec(x, y, i-1, j-1);
    //     }
    //     else{
    //         return Math.max(lcsRec(x, y, i-1, j), lcsRec(x, y, i, j-1));
    //     }
    // }

}
