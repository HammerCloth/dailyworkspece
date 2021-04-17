package cn.syx.eight;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 不相交区间
 * 这里使用的是贪心算法，在使用贪心算法时，首先要明确题目要求是需要一个最优解，z
 * 然后需要分析如何才能找到局部最优解，这部分是采用猜测加验证的方式
 * 这样的话采用贪心就变成了玄学，在有把握的时候使用就可以提升算法的速度
 * 但是也有可能没有估计到其他情况而出现问题
 * @author:syx
 * @date: 2021/4/17 9:51
 * @version:v1.0
 */
public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 程序输入n
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        // 程序输入n个数，代表每个任务的开始时间
        for (int i=0;i<n;i++){
            int start = sc.nextInt();
            jobs[i] = new Job(start);
        }
        // 程序输入n个数，代表每个任务的结束时间
        for (Job job:jobs){
            job.setEnd(sc.nextInt());
        }
        // 将其读入jobs数组中
        // 根据结束时间排序将jods数组排序
        Arrays.sort(jobs);
        //todo 然后进行计数，输出答案
        Job result = jobs[0];
        int count = 1;
        for (int i=1;i<jobs.length;i++){
            if (jobs[i].start>result.end){
                result = jobs[i];
                count++;
            }
        }
        System.out.println(count);
    }
    // 创建job对象，实现comparable接口
    static class Job implements Comparable<Job>{
        int start;
        int end;

        public Job(int start) {
            this.start = start;
        }

        public Job(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public int compareTo(Job o) {
            return this.end-o.end;
        }
    }

    }


