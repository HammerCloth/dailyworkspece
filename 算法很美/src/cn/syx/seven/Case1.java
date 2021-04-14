package cn.syx.seven;

import org.junit.Test;

/**
 * 机器人走方格
 * @author:syx
 * @date: 2021/4/12 19:44
 * @version:v1.0
 */
public class Case1 {
    @Test
    public void test1(){
        int x=3;
        int y=3;
        System.out.println(save(x,y));

    }
    public static int save(int x,int y){
        if(x==1){
            return 1;
        }else if(y==1){
            return 1;
        }
        return save(x-1,y)+save(x,y-1);
    }
}
