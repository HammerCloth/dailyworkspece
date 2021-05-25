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
        //����������
        SAXReader reader = new SAXReader();
        //ͨ����������XML����ΪDOM����
        Document aDocument = reader.read("XML\\src\\cn\\syx\\demo\\student.xml");
        //ͨ��DOM�����ȡ��Ԫ��
        Element rootElement = aDocument.getRootElement();
        //ͨ����Ԫ�ػ�ȡ��Ԫ��
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
