package flect;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:syx
 * @date :2021/4/2 17:35
 * @version:v1.0
 */
public class TestAnnotation {
    public static void main(String[] args) {
        Class clazz = la.class;
        MyAnnotation annotation =(MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());
    }
}
@MyAnnotation("syx")
class la{
    @MyAnnotation("syx")
    private String info;
}
@Target({TYPE,FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String value();
}

