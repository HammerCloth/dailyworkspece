package cn.syx.hashmap;

/**
 * 节点类，用与hashmap
 * @author:syx
 * @date:2021/3/8 16:02
 * @version:v1.0
 */
public class Node<K,V> {
    private int hash;
    private K key;
    private V value;
    private Node<K,V> next;

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K,V> getNext() {
        return next;
    }

    public void setNext(Node<K,V> next) {
        this.next = next;
    }
}
