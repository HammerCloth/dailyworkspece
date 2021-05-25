package cn.syx.demo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:syx
 * @date: 2021/5/25 15:32
 * @version:v1.0
 */
public class Demo {
    public static void main(String[] args) throws DocumentException {
        //创建解析器
        SAXReader reader = new SAXReader();
        //通过解析器将XML解析为DOM对象
        Document aDocument = reader.read("XML\\src\\cn\\syx\\demo\\student.xml");
        //通过DOM对象获取根元素
        Element rootElement = aDocument.getRootElement();
        //通过更元素获取子元素
        List<Element> elements = rootElement.elements();
        List<Student> list = new ArrayList<>();
        for(Element element:elements){
            String id = element.attributeValue("id");
            String age = element.elementText("age");
            String name = element.elementText("name");
            Student student = new Student(name,id,age);
            list.add(student);
        }
        System.out.println(list.toString());
    }
}
