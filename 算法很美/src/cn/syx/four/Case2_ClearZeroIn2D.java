package cn.syx.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 对数组中0存在的行和列进行清零
 *
 * @author:syx
 * @date:2021/3/29 19:18
 * @version:v1.0
 */
public class Case2_ClearZeroIn2D {
    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {1, 2, 3, 4},
                {1, 0, 4, 5},
                {3, 4, 0, 6},
                {1, 2, 3, 4},
        };
        clear(martix);
    }

    public static void clear(int[][] martix) {
        Util.print2D(martix);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        List<Index> indexList = new ArrayList<>();
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[i].length; j++) {
                if (martix[i][j] == 0) {
                    Index zero = new Index(i, j);
                    indexList.add(zero);
                }
            }
        }
        for (Index zero : indexList) {
            for (int i = 0; i < martix[zero.row].length; i++) {
                martix[zero.row][i] = 0;
            }
            for (int i = 0; i < martix.length; i++) {
                martix[i][zero.col] = 0;
            }
        }
        Util.print2D(martix);

    }

}

class Index {
    int row;
    int col;

    public Index(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
