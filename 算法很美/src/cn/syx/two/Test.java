package cn.syx.two;

/**
 * @author:syx
 * @date:2021/3/9 15:56
 * @version:v1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {1,1,1,0,1};
        System.out.println(reverse(a,a.length-1));
    }
    /**
     * С����¥�ݣ�¥����n�ף�С��һ�ο�����1�ף�2�׻���3��
     * ʵ��һ������������С���ж���������¥�ݵķ�ʽ
     */
    public static int bai(int n){
        if(n==0) {
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return bai(n-1)+bai(n-2)+bai(n-3)+1;
    }
    /**
     * ��ת�������С����
     * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ
     * �������ת������һ����������������һ����ת��
     * �����ת�������СԪ��
     */
    public static int reverse(int[] arr,int right){
        if(arr[right]<arr[0]){
            return reverse(arr,right-1);
        }else{
            return arr[right+1];
        }
    }
    public static int reverse(int[] arr){
        int begin = 0;
        int end = arr.length-1;
        if(arr[begin]<arr[end]){
            return arr[begin];
        }
        while(begin+1<end){
            int mid = (begin+end)>>1;
            if(arr[mid]<=arr[end]){
                end=mid;
            }else{
                begin = mid;
            }
        }
        return arr[end];
    }
    /**
     * ���ϵ����������
     */





}
