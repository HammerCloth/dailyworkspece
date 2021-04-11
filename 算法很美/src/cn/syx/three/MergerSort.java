package cn.syx.three;

import java.util.Arrays;

/**
 * @author:syx
 * @date:2021/3/12 18:05
 * @version:v1.0
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] a = new int[]{5,3,5,1,2,5,2,4,6,2,5,6,2,7,7,3,76,3};
        mergerSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void mergerSort(int[] arr,int begin,int end){
        int[] helper = new int[arr.length];
        if(begin<end){
            int mid = (begin+end)>>1;
            mergerSort(arr,begin,mid);
            mergerSort(arr,mid+1,end);
            merger(arr,helper,begin,mid,end);
        }
    }
    private static void merger(int[] arr,int[] helper,int begin,int mid,int end){
        //先把arr中的数据copy到helper中
        System.arraycopy(arr,begin,helper,begin,end-begin+1);
        //定义所需要的指针
        int left = begin;
        int right = mid+1;
        int current = begin;

        while(left<=mid&&right<=end){
            if(helper[left]<=helper[right]){
                arr[current]=helper[left];
                current++;
                left++;
            }else{
                arr[current]=helper[right];
                current++;
                right++;
            }
        }
        while(left<=mid){
            arr[current]=helper[left];
            current++;
            left++;
        }
    }
}

