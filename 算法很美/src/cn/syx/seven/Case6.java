package cn.syx.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯：就是在自己做完一步的时候，交给下一步操作，然后自己再执行相反的操作
 * 平行：通过循环来做到平行操作
 * 回溯的算法：也就是多叉树的深度搜索
 * @author:syx
 * @date: 2021/4/14 22:09
 * @version:v1.0
 */
public class Case6 {
    public static void main(String[] args) {
        List<List<Character>> result = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        chars.add('A');
        chars.add('B');
        chars.add('C');
        f(result,chars,0);
        System.out.println(result.toString());
    }

    /**
     *
     * @param chars
     * @param k 0-chars.size()-1
     * @return
     */
    public static void f(List<List<Character>> result,List<Character> chars, int k){
      // 循环出口
        if (k==chars.size()-1){
            List<Character> cha = new ArrayList<>();
            cha.addAll(chars);
            result.add(cha);
            return;
        }
      // DFS
        for(int i=k;i<chars.size();i++){
            swap(chars,k,i);//操作
            f(result,chars,k+1);
            swap(chars,k,i);//回溯
        }
    }
    public static void swap(List<Character> chars,int k,int i){
        Character temp = chars.get(k);
        chars.set(k,chars.get(i));
        chars.set(i,temp);
        System.out.println(chars.toString());
    }
}
