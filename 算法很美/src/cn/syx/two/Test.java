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
     * 小白上楼梯，楼梯有n阶，小白一次可以上1阶，2阶或者3阶
     * 实现一个方法，计算小白有多少种走完楼梯的方式
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
     * 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为
     * 数组的旋转。输入一个递增排序的数组的一个旋转，
     * 输出旋转数组的最小元素
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
     * 最长联系递增子序列
     */





}
