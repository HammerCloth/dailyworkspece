package cn.syx.four;

/**
 * 给定一个N*N的矩阵，在这个矩阵中，只有0和1两种值，
 * 返回边框全是1的最大正方形的边长长度
 *
 * @author:syx
 * @date: 2021/4/6 19:09
 * @version:v1.0
 */
public class Case4_MaxEdge {
    public static final int MAX_LEVEL = 5;
    public static int[][] matrix = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1},
            {0, 1, 1, 1, 1}
    };

    public static void main(String[] args) {
        int[][][] help = helpMatrix(matrix);
        Util.print2D(help[0]);//向下
        System.out.println("***********************************************");
        Util.print2D(help[1]);//向右
        System.out.println("***********************************************");
        int finalValue = 0;
        for (int N = MAX_LEVEL; N >= 1; N--) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    if (check(help, row, col, N)) {
                        if (checkDown(help, row, col + N - 1, N) && checkright(help, row + N - 1, col, N)) {
                            if (finalValue < N) {
                                finalValue = N;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(finalValue);

    }

    //辅助矩阵初始化
    public static int[][][] helpMatrix(int[][] matrix) {
        int[][][] helpMri = new int[2][matrix.length][matrix[0].length];
        //初始化
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k < 2; k++) {
                    helpMri[k][i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {


                    int down = 0;
                    //向下
                    for (int row = i, col = j; row < matrix.length; row++) {
                        if (matrix[row][col] == 1) {
                            helpMri[0][i][j]++;
                        } else {
                            break;
                        }
                    }
                    //向右
                    for (int row = i, col = j; col < matrix[0].length; col++) {
                        if (matrix[row][col] == 1) {
                            helpMri[1][i][j]++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return helpMri;
    }

    public static Boolean check(int[][][] help, int row, int col, int N) {
        if (help[0][row][col] >= N && help[1][row][col] >= N) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean checkDown(int[][][] help, int row, int col, int N) {
        if (help[0][row][col] >= N && row < matrix.length && col < matrix[0].length) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean checkright(int[][][] help, int row, int col, int N) {
        if (help[1][row][col] >= N && row < matrix.length && col < matrix[0].length) {
            return true;
        } else {
            return false;
        }
    }


}
