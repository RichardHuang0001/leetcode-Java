package 矩阵;

public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        boolean[] row = new boolean[m],col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    row[i]= true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(row[i]){
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0;j< n;j++){
            if(col[j]){
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
