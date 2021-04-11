package cn.syx.three;

import java.util.Arrays;

/**
 * @author:syx
 * @date:2021/3/11 17:07
 * @version:v1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{9, 3, 4, 6, 2, 3, 6, 2, 6};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = partition2(arr, begin, end);
            quickSort(arr, begin, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int sp = begin + 1;
        int bigger = end;

        while (sp <= bigger) {
            if (arr[sp] <= arr[begin]) {
                sp++;
            } else {
                int temp = arr[bigger];
                arr[bigger] = arr[sp];
                arr[sp] = temp;
                bigger--;
            }
        }

        int temp = arr[bigger];
        arr[bigger] = arr[begin];
        arr[begin] = temp;
        return bigger;

    }

    private static int partition2(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int left = begin + 1;
        int right = end;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }

        swap(arr, begin, right);
        return right;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}

