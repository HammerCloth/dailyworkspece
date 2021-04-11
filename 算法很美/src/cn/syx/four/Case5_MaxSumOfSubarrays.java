package cn.syx.four;

/**
 * ����һ������matrix�����е�ֵ�����и�����0��
 * �����Ӿ�֤������ۼӺ�
 *
 * @author:syx
 * @date: 2021/4/6 20:23
 * @version:v1.0
 */
public class Case5_MaxSumOfSubarrays {
    public static void main(String[] args) {
        int[][] matrix = Util.get2D(1);
        Util.print2D(matrix);
        int max = 0;
        int sum = 0;
        for (int start = 0; start < matrix.length; start++) {
            //ȷ���˿�ʼ����
            int[] arr = matrix[start];
            sum = maxSumOfArr(arr);
            if (sum > max) {
                max = sum;
            }
            for (int add = start + 1; add < matrix.length; add++) {
                arr = plus(arr,matrix[add]);
                sum = maxSumOfArr(arr);
                if (sum > max) {
                    max = sum;
                }
            }

        }
        System.out.println(max);

    }

    public static int[] plus(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    public static int maxSumOfArr(int[] arr) {
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                sum = 0;//���С��0�������֮ǰ����ͣ�����һ�ο�ʼ
            } else if (sum > max) {
                max = sum;//����0�������ֵ�ȽϺ����¼�¼
            }
        }
        return max;
    }
}

