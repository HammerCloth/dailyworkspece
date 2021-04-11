package cn.syx.two;

/**
 * 想办法一次丢掉一半
 * @author:syx
 * @date:2021/3/8 18:15
 * @version:v1.0
 */
public class TestSearch01 {
    public static void main(String[] args){
        int[] x=new int[00000*10000];
        for(int i=0;i<x.length;i++){
            x[i] =i+1;
        }
        int target=10000*10000;
        long now = System.currentTimeMillis();
        int index = binarySearch(x,target,0, x.length-1);
        System.out.println(System.currentTimeMillis()-now+"ms");

        long now1 = System.currentTimeMillis();
        index = search(x,target);
        System.out.println(System.currentTimeMillis()-now+"ms");
    }
    /**
     * 顺序查找
     */
    public static int search(int[] arr,int target){
        for(int i=0;i< arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    /**
     * 二分查找
     */
    public static int binarySearch(int[] arr,int target,int left,int right){
        if(right<left){
            return -1;
        }
        int mid=(right+left)>>1;
        if(target==arr[mid]){
            return mid;
        }else if(target<arr[mid]){
            return binarySearch(arr,target,left,mid-1);
        }else{
            return binarySearch(arr,target,mid+1,right);
        }
    }
}
