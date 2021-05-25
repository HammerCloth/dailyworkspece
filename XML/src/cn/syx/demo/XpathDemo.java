package cn.syx.demo;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.XMLReader;

/**
 * @author:syx
 * @date: 2021/5/25 16:20
 * @version:v1.0
 */
public class XpathDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("XML/src/cn/syx/demo/student.xml");
        Element node = (Element) document.selectSingleNode("/students/student[@id='3']");
        String id = node.attributeValue("id");
        System.out.println(id);
    }
}
