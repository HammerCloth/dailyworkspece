package cn.syx.model;

/**
 * @author:syx
 * @date: 2021/4/6 14:20
 * @version:v1.0
 */
public class TestFactory {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Car c = SimpleFactory.getCar("cn.syx.model.Audi");
        c.run();
    }
}

interface Car {
    void run();
}

class Audi implements Car {
    @Override
    public void run() {
        System.out.println("°ÂµÏ");
    }
}

class BWM implements Car {
    @Override
    public void run() {
        System.out.println("±¦Âí");
    }
}

class SimpleFactory {
    public static Car getCar(String carName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(carName);
        Car obj = (Car) clazz.newInstance();
        return obj;
    }
}