package cn.syx.four;

/**
 * @author:syx
 * @date: 2021/3/29 19:32
 * @version:v1.0
 */
public class Util {
    public static void main(String[] args) {
        print2D(get2D(9));
    }

    public static void print2D(int[][] martix) {
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[i].length; j++) {
                System.out.print(martix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] get2D(int index) {
        switch (index) {
            case 1:
                return new int[][]{
                        {1, 1, 1, 1, 1},
                        {1, 2, 2, 2, 1},
                        {1, 2, 3, 2, 1},
                        {1, 2, 2, 2, 1},
                        {1, 1, 1, 1, 1},
                };
            case 2:
                return new int[][]{
                        {2, 1, 1, 6, 1},
                        {1, 3, 6, 2, 1},
                        {1, 2, 3, 9, 1},
                        {1, 2, 4, 2, 4},
                        {1, 1, 5, 1, 1},
                };
            case 0:
                return new int[][]{
                        {2, 1, 1, 6, 1},
                        {1, 3, 0, 2, 1},
                        {1, 0, 3, 9, 1},
                        {1, 2, 4, 0, 4},
                        {1, 1, 5, 1, 0},
                };
            default:
                return new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                };
        }
    }

    public static void swap2D(int[][] martix, int aRow, int aCol, int bRow, int bCol) {
        int temp = martix[aRow][aCol];
        martix[aRow][aCol] = martix[bRow][bCol];
        martix[bRow][bCol] = temp;
    }

}
