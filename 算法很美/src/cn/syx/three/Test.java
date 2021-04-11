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
     * ��������˳��ʹ������λ��ż����ǰ�棺
     * ����һ���������飬�������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
     * ���е�ż��λ������ĺ�벿�֡�Ҫ��ʱ��ĸ��Ӷ�ΪO(N)
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
     * ��k��Ԫ�أ�
     * �Ծ����ߵ�Ч�����һ�����������а���ֵ˳��ĵ�k��Ԫ��ֵ
     */
    public static int selectK(int arr[] ,int k,int begin,int end){
        int mid = partition(arr,begin,end);//�±�
        int midLev = mid-begin+1;//��Ԫ�ǵڼ���Ԫ��
        if(midLev==k){
            return arr[mid];
        }else if(midLev>k){//�����
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
    /*��С����ID��
    * �ڷǸ����飨�������ҵ���С�ɷ����ID����1��ʼ��ţ���
    * ������1000000*/
    public static int minFreeID(int[] arr,int left,int right){
        if(left>right){
            return right+2;
        }
        int midIndex = left+((right-left)>>1);//��������м�λ���±�
        int midvalue = selectK(arr,midIndex-left+1,left,right);//����������м�λ�õ���
        int pivot = midIndex+1;//�������м�λ�õ�ֵ
        if (pivot==midvalue){
            /*������*/
            return minFreeID(arr,midIndex+1,right);
        } else {
            return minFreeID(arr,left,midIndex-1);
        }

    }
    /**
     * ����֮��
     * �������������Һ͵�����
     * ��������������arr��k�����ظ���ӡarr��������Ӻ�Ϊk�Ĳ������Ԫ��
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
     * ǰk����
     * �������ݣ��������������������е�ǰk��������Ϊ������̫���޷�ȫ���洢���ڴ���
     * ֻ��һ�����������ϻ��ߴ����϶�ȡ����
     * �������û��������ݵĸ������û��������ݺ����س���
     * ����-1���������
     * Ȼ���û�����k������Ϊ��topk
     * �����topk�������ÿո�ָ�
     */
    /**
     * �������ųɵ���С��
     * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ����
     * ƴ�ӳ���������������С��һ��
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
     * ����İ���
     * ���������ַ��������ж�str1�����е��ַ��Ƿ񶼴���str2��
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
