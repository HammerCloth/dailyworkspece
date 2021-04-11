package cn.syx.four;

/**
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 *
 * @author:syx
 * @date :2021/3/29 18:45
 * @version:v1.0
 */
public class Case1_Print2D {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 2, 2, 2, 1},
                {1, 2, 3, 2, 1},
                {1, 2, 2, 2, 1},
                {1, 1, 1, 1, 1},
        };
        print(matrix);
    }

    public static void print(int[][] matrix) {
        int leftUpRow = 0;
        int leftUpCol = 0;
        int rightDownRow = matrix.length - 1;
        int rightDownCol = matrix[0].length - 1;
        while (leftUpCol <= rightDownRow && rightDownRow <= rightDownCol) {
            for (int i = leftUpCol; i <= rightDownCol; i++) {
                System.out.print("\t" + matrix[leftUpRow][i]);
            }
            leftUpRow++;
            for (int i = leftUpRow; i <= rightDownRow; i++) {
                System.out.print("\t" + matrix[i][rightDownCol]);
            }
            rightDownCol--;
            for (int i = rightDownCol; i >= leftUpCol; i--) {
                System.out.print("\t" + matrix[rightDownRow][i]);
            }
            rightDownRow--;
            for (int i = rightDownRow; i >= leftUpRow; i--) {
                System.out.print("\t" + matrix[i][leftUpCol]);
            }
            leftUpCol++;
        }
    }
}
