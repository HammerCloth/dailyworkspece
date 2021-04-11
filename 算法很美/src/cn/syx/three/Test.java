package cn.syx.three;

import java.util.*;

/**
 * @author:syx
 * @date: 2021/3/12 18:26
 * @version:v1.0
 */
public class Test {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{321,3,32};
        f(a);
    }
    /**
     * 调整数组顺序使得奇数位于偶数的前面：
     * 输入一个整数数组，调整数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分。要求时间的复杂度为O(N)
     */
    public static void oddEvenSort(int[] arr){
        int odd = 0;
        int even = arr.length-1;
        // the even in the left
        while(even>=odd){
            while(arr[odd]%2==1){
                odd++;
            }
            while(arr[even]%2==0){
                even--;
            }
            if(even>odd){
                int temp = arr[even];
                arr[even] = arr[odd];
                arr[odd] = temp;
            }
        }
    }
    /**
     * 第k个元素：
     * 以尽量高的效率求出一个乱序数组中按数值顺序的第k个元素值
     */
    public static int selectK(int arr[] ,int k,int begin,int end){
        int mid = partition(arr,begin,end);//下标
        int midLev = mid-begin+1;//主元是第几个元素
        if(midLev==k){
            return arr[mid];
        }else if(midLev>k){//在左边
            return selectK(arr,k,begin,mid-1);
        }else{
            return selectK(arr,k-midLev,mid+1,end);
        }
    }
    private static int partition(int arr[],int left,int right) {
        int pivot = arr[left];
        int bigger = right;
        int pr = left+1;

        while(pr<=bigger) {
            if(arr[pr]<=pivot){
                pr++;
            }else{
                swap(arr,pr,bigger);
                bigger--;
            }
        }
        swap(arr,left,bigger);
        return bigger;
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
    /*最小可用ID：
    * 在非负数组（乱序）中找到最小可分配的ID（从1开始编号），
    * 数据量1000000*/
    public static int minFreeID(int[] arr,int left,int right){
        if(left>right){
            return right+2;
        }
        int midIndex = left+((right-left)>>1);//求出数组中间位置下标
        int midvalue = selectK(arr,midIndex-left+1,left,right);//求出排序在中键位置的数
        int pivot = midIndex+1;//期望在中间位置的值
        if (pivot==midvalue){
            /*左侧紧密*/
            return minFreeID(arr,midIndex+1,right);
        } else {
            return minFreeID(arr,left,midIndex-1);
        }

    }
    /**
     * 两书之和
     * 在排序数组中找和的因子
     * 给定已排序数组arr和k，不重复打印arr中所有相加和为k的不降序二元组
     */
    public static List<int[]> TwoNumSum(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        List<int[]> list = new ArrayList<>();
        while(left<right){
            if((arr[left]+arr[right])==k){
                int[] couple = new int[]{arr[left],arr[right]};
                list.add(couple);
                left++;
            }else if((arr[left]+arr[right])>k){
                right--;
            }else if((arr[left]+arr[right])<k){
                left++;
            }
        }
        return list;
    }
    /**
     * 前k个数
     * 求海量数据（正整数）按照逆序排列的前k个数，因为数据量太大，无法全部存储在内存中
     * 只能一个个从网络上或者磁盘上读取数据
     * 不限制用户输入数据的个数，用户输入数据后点击回车，
     * 输入-1后结束输入
     * 然后用户输入k，代表为求topk
     * 请输出topk，并且用空格分隔
     */
    /**
     * 数组能排成的最小数
     * 输入一个正整数数组，把数组李所有整数拼接起来排成一个数，打印出能
     * 拼接出的所有数字中最小的一个
     */
    public static void f(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = o1 + "" + o2;
                String b = o2 + "" + o1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
        }
        System.out.println(sb);
    }
    /**
     * 数组的包含
     * 输入两个字符串，请判断str1中所有的字符是否都存在str2中
     */
    public static boolean contiansAll(String s1,String s2){
        char[] b = s2.toCharArray();
        Arrays.sort(b);
        for(int i=0;i<s1.length();i++){
            char[] a = s1.toCharArray();
            int index = Arrays.binarySearch(b,a[i]);
            if(index<0){
                return false;
            }
        }
        return true;
    }





}
