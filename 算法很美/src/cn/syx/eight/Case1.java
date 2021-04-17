package cn.syx.eight;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ���ཻ����
 * ����ʹ�õ���̰���㷨����ʹ��̰���㷨ʱ������Ҫ��ȷ��ĿҪ������Ҫһ�����Ž⣬z
 * Ȼ����Ҫ������β����ҵ��ֲ����Ž⣬�ⲿ���ǲ��ò²����֤�ķ�ʽ
 * �����Ļ�����̰�ľͱ������ѧ�����а��յ�ʱ��ʹ�þͿ��������㷨���ٶ�
 * ����Ҳ�п���û�й��Ƶ������������������
 * @author:syx
 * @date: 2021/4/17 9:51
 * @version:v1.0
 */
public class Case1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ��������n
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        // ��������n����������ÿ������Ŀ�ʼʱ��
        for (int i=0;i<n;i++){
            int start = sc.nextInt();
            jobs[i] = new Job(start);
        }
        // ��������n����������ÿ������Ľ���ʱ��
        for (Job job:jobs){
            job.setEnd(sc.nextInt());
        }
        // �������jobs������
        // ���ݽ���ʱ������jods��������
        Arrays.sort(jobs);
        //todo Ȼ����м����������
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
    // ����job����ʵ��comparable�ӿ�
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


