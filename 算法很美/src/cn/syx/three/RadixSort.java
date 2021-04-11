package cn.syx.three;


import com.sun.xml.internal.ws.message.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**基数排序
 * @author:syx
 * @date: 2021/3/19 19:37
 * @version:v1.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,34,23466,12,323,4};
        int maxRadix = getMaxRadix(arr);
        for (int i=1;i<=maxRadix;i++) {
            for (int num:arr) {
                putNum(num,i);
            }
            putInArray(list,arr);
            clear();
        }
        System.out.println(Arrays.toString(arr));



    }
    //创造10个桶
    //根据不同的位数放入对应的桶中
    //再从桶中吐出来到原来的数组
    static List<List> list = new ArrayList<>();
    static{
        for(int i=0;i<10;i++){
            List<Integer> set = new ArrayList<>();
            list.add(set);
        }
    }
    private static void clear(){
        for(List lis:list){
            lis.clear();
        }
    }
    //放入桶中
    private static void putNum(int num,int radix){
        StringBuilder str = new StringBuilder(String.valueOf(num));
        str.reverse();
        System.out.println(str);
        char[] chars = str.toString().toCharArray();
        char check;
        if(radix>chars.length){
            check = '0';
        }else{
            check = chars[radix-1];
        }
        switch(check){
            case '0':
                list.get(0).add(num);
                break;
            case '1':
                list.get(1).add(num);
                break;
            case '2':
                list.get(2).add(num);
                break;
            case '3':
                list.get(3).add(num);
                break;
            case '4':
                list.get(4).add(num);
                break;
            case '5':
                list.get(5).add(num);
                break;
            case '6':
                list.get(6).add(num);
                break;
            case '7':
                list.get(7).add(num);
                break;
            case '8':
                list.get(8).add(num);
                break;
            case '9':
                list.get(9).add(num);
                break;
        }
    }
    private static int getMaxRadix(int[] nums){
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            if (max<nums[i]) {
                max=nums[i];
            }
        }
        int radix = 1;
        while((max=max/10)!=0){
            radix++;
        }
        return radix;
    }
    //顺位将桶中的数字，重新放入数组中
    private static void putInArray(List<List> list,int[] num){
        int index = 0;
        Iterator iter = list.listIterator();
        while (iter.hasNext()) {
            List<Integer> buket = (ArrayList)iter.next();
            Iterator itero = buket.listIterator();
            while(itero.hasNext()) {
                num[index++] = (int)itero.next();
            }
        }

    }


}
