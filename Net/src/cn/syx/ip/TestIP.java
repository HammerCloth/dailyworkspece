package cn.syx.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:
 * IPV4:4��������ÿһ��������һ���ֽڣ��޷��ţ�0-255
 *     192.164.13.175
 * IPV6:128λ
 * @author:syx
 * @date:2021/3/22 19:55
 * @version:v1.0
 */
public class TestIP {
    public static void main(String[] args) {
        InetAddress ben,bai,here;
        byte[] ujs = {(byte)192,(byte)163,15,6};

        {
            try {
                ben = InetAddress.getLocalHost();
                bai = InetAddress.getByName("p.ujs.edu.cn");
                here = InetAddress.getByAddress(ujs);
                System.out.println(ben);
                System.out.println(bai);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }



}
