package Day25;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 以下是某不知名机构评出的全球最佳影片及华人最佳影片前十名 ：
 * 全球
 * 　　1、 《教父》
 * 　　2、 《肖申克的救赎》
 * 　　3、 《辛德勒的名单》
 * 　　4、 《公民凯恩》
 * 　　5、 《卡萨布兰卡》
 * 　　6、 《教父续集》
 * 　　7、 《七武士》
 * 　　8、 《星球大战》
 * 　　9、 《美国美人》
 * 　　10、 《飞跃疯人院》
 * 华人
 * 　  1、 《霸王别姬》
 * 　　2、 《大闹天宫》
 * 　　3、 《鬼子来了》
 * 　　4、 《大话西游》
 * 　　5、 《活着》
 * 　　6、 《饮食男女》
 * 　　7、 《无间道》
 * 　　8、 《天书奇谭》
 * 　　9、 《哪吒脑海》
 * 　　10、 《春光乍泄》
 * 1、现将两个榜单中的影片名，分别按排名顺序依次存入两个ArrayList集合
 * 2、通过流的方式
 * 	1）打印全球影片排行榜中的前三甲影片名
 * 	2）打印华人影片排行榜中倒数5名的影片名
 * 	3）将两个排行榜中的前5名挑出来共同存入新的集合
 * 	4）定义电影Film类，以影片名为name创建Film对象并保存至集合，Film类型包含影片名属性
 * @author:syx
 * @date: 2021/4/20 20:23
 * @version:v1.0
 */
public class Case9 {
    public static void main(String[] args) {
        ArrayList<String> global = new ArrayList<>();
        global.add("《教父》");
        global.add("《肖申克的救赎》");
        global.add("《辛德勒的名单》");
        global.add("《公民凯恩》");
        global.add("《卡萨布兰卡》");
        global.add("《教父续集》");
        global.add("《七武士》");
        global.add("《星球大战》");
        global.add("《美国美人》");
        global.add("《飞跃疯人院》");

        ArrayList<String> china = new ArrayList<>();
        china.add("《霸王别姬》");
        china.add("《大闹天宫》");
        china.add("《鬼子来了》");
        china.add("《大话西游》");
        china.add("《活着》");
        china.add("《饮食男女》");
        china.add("《无间道》");
        china.add("《天书奇谭》");
        china.add("《哪吒脑海》");
        china.add("《春光乍泄》");
        /**
         * 2、通过流的方式
         *  * 	1）打印全球影片排行榜中的前三甲影片名
         *  * 	2）打印华人影片排行榜中倒数5名的影片名
         *  * 	3）将两个排行榜中的前5名挑出来共同存入新的集合
         *  * 	4）定义电影Film类，以影片名为name创建Film对象并保存至集合，Film类型包含影片名属性
         */
        global.stream().limit(3).forEach(System.out::println);
        china.stream().skip(5).forEach(System.out::println);
        Stream.concat(global.stream().limit(5),china.stream().limit(5)).map(Film::new).collect(Collectors.toSet());

    }

}
class Film{
    String name;

    public Film(String name) {
        this.name = name;
    }
}
