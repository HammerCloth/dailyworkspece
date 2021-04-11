package cn.syx.three;

import java.util.Arrays;

/**
 * @author:syx
 * @date: 2021/3/14 16:53
 * @version:v1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,7,3,4,5,6,7};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 造小顶堆；
     */
    public static void minHeap(int[] arr){
        int n = arr.length;
        for(int i=(n/2-1);i>=0;i--){
            minHeapFixDown(arr,i, arr.length);
        }
    }
    private static void minHeapFixDown(int[] arr,int i,int n){
        // 找到左右孩子
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        // 如果左孩子已经越界，则为叶子节点
        if(leftChild >= n){
            return;
        }
        int min = leftChild;
        if(rightChild < n&&arr[leftChild]>arr[rightChild]){
             min =rightChild;
        }
        // 进行比较
        if(arr[i]>arr[min]){
            swap(arr,i,min);
            minHeapFixDown(arr,min,n);
        }
        // 进行递归
    }
    private static void swap(int[] arr,int a,int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
    /**
     * 造大顶堆
     */
    public static void maxHeap(int[] arr){
        int n = arr.length;
        for (int i = n/2-1;i>=0;i--) {
            maxHeapFixDown(arr,i,arr.length);
        }
    }
    private static void maxHeapFixDown(int[] arr,int i,int n){
        int left = 2*i+1;
        int right = 2*i+2;
        if (left>=n) {
            return;//结束
        }
        int max = left;
        if(right<n&&arr[left]<arr[right]){
            max = right;
        }
        if(arr[max]>arr[i]){
            swap(arr,max,i);
            maxHeapFixDown(arr,max,n);
        }
    }
    /**
     * 堆排序
     */
    public static void heapSort(int[] arr){
        //先进行堆化
        minHeap(arr);
        for (int n=arr.length-1;n>0;n--) {
            //对调处于堆顶和堆尾部的元素
            swap(arr,0,n);
            // 对变小的堆进行优化
            minHeapFixDown(arr,0,n);
        }

    }

}
