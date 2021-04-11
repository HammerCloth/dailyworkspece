package cn.syx.hashmap;

/**
 * 自定义一个hashmap
 * 加入toString
 * 增加get方法
 * @author:syx
 * @date:2021/3/8 16:01
 * @version:v1.0
 */
public class SyxHashMap<K,V> {
    Node<K,V>[] table;
    private int size;

    public int getSize() {
        return size;
    }

    public SyxHashMap() {
        table = new Node[16];
        /* 长度一定的是2的整数次蜜 */
    }

    public void put(K key,V value){
        /*定义了新的节点*/
        Node<K,V> node = new Node<>();
        node.setHash(myHash(key.hashCode(), table.length));
        node.setKey(key);
        node.setValue(value);
        /*与数组关联*/
        Node<K,V> temp = table[node.getHash()];
        if(temp==null){
            table[node.getHash()]=node;
            size++;
        }else{
            while(!(temp.getKey().equals(node.getKey()))&&temp.getNext()!=null) {
                temp = temp.getNext();
            }
            if (temp.getKey().equals(node.getKey())){
                temp.setValue(node.getValue());
            }
            if(temp.getNext()==null&&!(temp.getKey().equals(node.getKey()))){
                temp.setNext(node);
                size++;
            }
        }
    }

    private int myHash(int v,int length){
        return v&(length-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for(int i=0;i< table.length;i++){
            Node<K,V> temp = table[i];
            while(temp!=null){
                sb.append("<"+temp.getKey()+">"+":"+temp.getValue()+" ,");
                temp = temp.getNext();
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public V get(K key){
        int hash = myHash(key.hashCode(), table.length);
        if(table[hash]!=null){
            Node<K,V> temp = table[hash];
            while(temp!=null){
                if(temp.getKey().equals(key)) {
                    return (V)temp.getValue();
                }else{
                    temp=temp.getNext();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SyxHashMap<Integer,String> m1 = new SyxHashMap<>();
        m1.put(10,"aa");
        m1.put(10,"cc");
        m1.put(96,"bb");
        m1.put(15,"dd");
        System.out.println(m1);
        System.out.println(m1.getSize());
        System.out.println(m1.get(10));
        System.out.println(m1.get(96));

    }
}
