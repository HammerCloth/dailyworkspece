package cn.syx.seven;

import cn.syx.four.Util;

import java.util.Arrays;

/**
 * 求数独
 *
 * @author:syx
 * @date: 2021/4/15 16:26
 * @version:v1.0
 */
public class Case7DFS01 {
    public static void main(String[] args) {
        int[][] program = {
                {0, 0, 5, 3, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 7, 0, 0, 1, 0, 5, 0, 0},
                {4, 0, 0, 0, 0, 5, 3, 0, 0},
                {0, 1, 0, 0, 7, 0, 0, 0, 6},
                {0, 0, 3, 2, 0, 0, 0, 8, 0},
                {0, 6, 0, 5, 0, 0, 0, 0, 9},
                {0, 0, 4, 0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 9, 7, 0, 0}
        };
        DFS(program,0,0);
    }

    /**
     * 深度搜索求解
     * 对于数独求解来说，每次填写一个数时就会改变状态，当发现进行不下去就辉回溯，然后再次进行搜索
     * @param program 9*9矩阵
     * @param x       0-8
     * @param y       0-8
     */
    private static void DFS(int[][] program, int x, int y) {
        //出口
        if (x == 9) {
            Util.print2D(program);
            System.exit(0);
        }
        if (program[x][y] == 0) {
            for (int i = 1; i < 10; i++) {
                if (check(program, x, y, i)) {
                    program[x][y] = i;//操作
                    DFS(program, x, y);
                }
            }
            program[x][y] = 0;//回溯
        } else {
            DFS(program, x + (y + 1) / 9, (y + 1) % 9);
        }
    }

    /**
     * 确认1-9是否可以填写
     *
     * @param program 9*9矩阵
     * @param x       0-8
     * @param y       0-8
     * @return boolean true、false
     */
    private static boolean check(int[][] program, int x, int y, int aim) {
        //检查同行和同列
        boolean flag = true;
        for (int i = 0; i < 9; i++) {
            if (program[x][i] == aim || program[i][y] == aim) {
                return false;
            }
        }
        //检查同一个小九宫格
        for (int i = ((x / 3) * 3); i < ((x / 3 + 1) * 3); i++) {
            for (int j = ((y / 3) * 3); j < ((y / 3 + 1) * 3); j++) {
                if (program[i][j] == aim) {
                    return false;
                }
            }
        }
        return flag;
    }
}
