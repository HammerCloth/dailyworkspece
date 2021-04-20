package Day25;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用Stream方式进行以下若干操作步骤：
 * 1. 第一个队伍只要名字为3个字的成员姓名；
 * 2. 第一个队伍筛选之后只要前4个人；
 * 3. 第二个队伍只要姓张的成员姓名；
 * 4. 第二个队伍筛选之后不要前1个人；
 * 5. 将两个队伍合并为一个队伍；
 * 6. 根据姓名创建Student对象；Student类型包含name属性
 * 7. 打印整个队伍的Student对象信息。
 * @author:syx
 * @date: 2021/4/20 20:00
 * @version:v1.0
 */
public class Case8 {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("清风");
        one.add("陈玄风");
        one.add("梅超风");
        one.add("陆乘风");
        one.add("曲灵风");
        one.add("武眠风");
        one.add("冯默风");
        one.add("罗玉风");

        List<String> two = new ArrayList<>();
        two.add("宋远桥");
        two.add("俞莲舟");
        two.add("俞岱岩");
        two.add("张松溪");
        two.add("张翠山");
        two.add("殷梨亭");
        two.add("张声谷");

        Stream<String> stream = one.stream()
                                    .filter(str->str.length()==3)
                                    .limit(4);
        Stream<String> stream2 = two.stream()
                                    .filter(str->str.substring(0,1).equals("张"))
                                    .skip(1);

        Stream.concat(stream,stream2).map(Stuudent::new).forEach(System.out::println);
    }
}
class Stuudent {
    private String name;

    public Stuudent() {
    }

    public Stuudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Student {name='" + name + "'}";
    }
}
