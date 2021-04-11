package cn.syx.object;

import java.io.Serializable;

/**
 * @author:syx
 * @date:2021/3/18 15:42
 * @version:v1.0
 */
public class Goods implements Serializable {
    private final static long serialVersionUID = 2L;
    private int price;
    private String name;
    private transient int sale;//表示不需要序列化

    public Goods(int price, String name, int sale) {
        this.price = price;
        this.name = name;
        this.sale = sale;
    }

    public Goods() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", sale=" + sale +
                '}';
    }
}
