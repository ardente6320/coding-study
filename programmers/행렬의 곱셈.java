class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] matrix = new int[arr1.length][arr2[0].length];
        
        for(int r =0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++){
                for(int i = 0; i<arr2.length; i++){
                    matrix[r][c] += arr1[r][i] * arr2[i][c];
                }
            }
        }
        
        return matrix;
    }
}
