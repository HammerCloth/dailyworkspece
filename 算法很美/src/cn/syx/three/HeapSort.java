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
     * ��С���ѣ�
     */
    public static void minHeap(int[] arr){
        int n = arr.length;
        for(int i=(n/2-1);i>=0;i--){
            minHeapFixDown(arr,i, arr.length);
        }
    }
    private static void minHeapFixDown(int[] arr,int i,int n){
        // �ҵ����Һ���
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        // ��������Ѿ�Խ�磬��ΪҶ�ӽڵ�
        if(leftChild >= n){
            return;
        }
        int min = leftChild;
        if(rightChild < n&&arr[leftChild]>arr[rightChild]){
             min =rightChild;
        }
        // ���бȽ�
        if(arr[i]>arr[min]){
            swap(arr,i,min);
            minHeapFixDown(arr,min,n);
        }
        // ���еݹ�
    }
    private static void swap(int[] arr,int a,int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
    /**
     * ��󶥶�
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
            return;//����
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
     * ������
     */
    public static void heapSort(int[] arr){
        //�Ƚ��жѻ�
        minHeap(arr);
        for (int n=arr.length-1;n>0;n--) {
            //�Ե����ڶѶ��Ͷ�β����Ԫ��
            swap(arr,0,n);
            // �Ա�С�Ķѽ����Ż�
            minHeapFixDown(arr,0,n);
        }

    }

}
