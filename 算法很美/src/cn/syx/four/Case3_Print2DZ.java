package cn.syx.four;

/**
 * @author:syx
 * @date: 2021/3/29 19:43
 * @version:v1.0
 */
public class Case3_Print2DZ {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 2, 2, 2, 1},
                {1, 2, 3, 2, 1},
                {1, 2, 2, 2, 1},
                {1, 1, 1, 1, 1},
        };
        z(matrix);
    }

    public static void z(int[][] matrix) {
        int r = 0;
        int c = 0;
        boolean l2r = true; //-->
        while (r < matrix.length && c < matrix[0].length) {
            if (l2r) {
                System.out.print(matrix[r][c] + "\t");
                //现在在第一行，只能向右走
                if (r == 0 && c < matrix[0].length - 1) {
                    c++;
                    l2r = !l2r;
                } else if (r > 0 && c == matrix[0].length - 1) {
                    r--;
                    l2r = !l2r;
                } else {
                    r--;
                    c++;
                }

            } else {
                System.out.print(matrix[r][c] + "\t");
                if (c == 0 && r < matrix.length - 1) {
                    r++;
                    l2r = !l2r;
                } else if (r == matrix.length - 1) {
                    r++;
                    l2r = !l2r;
                } else {
                    r++;
                    c--;
                }
            }

        }

    }
}
