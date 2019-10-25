import java.util.HashMap;
import java.util.Map;


/**
 * map本省是数组和链表两部分组成
 * 数组下的的一个一个的值是有链表组成的
 *
 * 一下自定义一个节俭的hashmap
 */
public class MyHashMap {

    //默认初始化大小 16
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    //默认负载因子 0.75
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //临界值
    private int threshold;

    //元素个数
    private int size;

    //扩容次数
    private int resize;


    private HashEntry[] table;


    public MyHashMap ( ) {
        //初始化创建数组赋予数组大小
        table = new HashEntry[DEFAULT_INITIAL_CAPACITY];
        //计算临界值
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        //初始化默认元素个数
        size = 0;
    }

    /** add begin by chenshifeng   put操作*/

    private int index (Object key) {
        //根据key的hashcode和table长度取模计算key在table中的位置
        return key.hashCode() % table.length;
    }


    public void put ( Object key, Object value ) {

        //key为null时需要特殊处理，为简化实现忽略null值
        if ( key == null ) return ;
        int index = index(key);

        //遍历index位置的entry，若找到重复key则更新对应entry的值，然后返回
        HashEntry entry = table[index];
        while ( entry != null ) {
            if ( entry.getKey().hashCode() == key.hashCode() && (entry.getKey() == key
                    || entry.getKey().equals(key)) ) {
                entry.setValue(value);
                return;
            }
        }
        //若index位置没有entry或者未找到重复的key，则将新key添加到table的index位置
        add(index, key, value);
    }


    private void add(int index, Object key, Object value) {
        //将新的entry放到table的index位置第一个，若原来有值则以链表形式存放
        HashEntry entry = new HashEntry(key, value, table[index]);

        table[index] = entry;

        //判断size是否达到临界值，若已达到则进行扩容，将table的capacicy翻倍
        if (size++ >=threshold ) {
            resize(table.length * 2 );
        }
    }


    private void resize ( int capacity ) {

        if ( capacity <= table.length ) return ;

        HashEntry[] newTable = new HashEntry[capacity];

        //遍历原table，将每个entry都重新计算hash放入newTable中
        for ( int i = 0; i < table.length; i++ ) {

            HashEntry old = table[i];

            while ( old != null ) {
                HashEntry next = old.getNext();
                int index = index(old.getKey());
                //这步骤是为来复制null，为后续逻辑跳出循环
                old.setNext(newTable[index]);
                newTable[index] = old;
                old = next;
            }
        }

        //newtable 替table
        table = newTable;

        //修改临界值
        threshold = (int) (table.length * DEFAULT_LOAD_FACTOR);

        resize ++;
    }

    /** add end by chenshifeng   put操作*/


    public Object get (Object key) {

        if (key == null) return null;

        HashEntry entry = getEntry(key);

        return entry == null ? null : entry.getValue();
    }


    public HashEntry getEntry (Object key) {

        HashEntry entry = table[index(key)];

        while ( entry != null ) {

            if ( entry.getKey().hashCode() == key.hashCode()
                    && ( entry.getKey() == key || entry.getKey().equals(key)  ) ) {
                return entry;
            }
            entry = entry.getNext();
        }
        return null;
    }



    public void remove ( Object key ) {

        if ( key == null) return ;

        int index = index( key );

        HashEntry pre = null;

        HashEntry entry = table[index];

        while ( entry != null ) {

            if ( entry.getKey().hashCode() == key.hashCode()
                    && ( entry.getKey() == key || entry.getKey().equals(key)  ) ) {

                if (pre == null ) {
                    table[index] = entry.getNext();
                } else {
                    pre.setNext(entry.getNext());
                }
                //如果成功找到并删除，修改size
                size--;
                return ;
            }
            pre = entry;
            entry = entry.getNext();
        }

    }

    public boolean containsKey(Object key) {
        if (key == null) return false;
        return getEntry(key) != null;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        this.size = 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size:%s capacity:%s resize:%s\n\n", size, table.length, resize));
        for (HashEntry entry : table) {
            while (entry != null) {
                sb.append(entry.getKey() + ":" + entry.getValue() + "\n");
                entry = entry.getNext();
            }
        }
        return sb.toString();
    }






    public static void main(String[] args) {

//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("aa", "aaValue");
//
//        map.get("aa");
//        //删除操作，首先将key转换成hashcode，将hash道数组里面进行检索，找到数组下标，将指针往前面移动一位，数组长度减一
//        map.remove("aa");

        MyHashMap map = new MyHashMap();

        map.put("bb", "bvalue");

        map.put("1", "avalue");

        map.remove("1");

        System.out.println(map.toString());

    }






}




class HashEntry {

    private final Object key;
    private Object value;
    private HashEntry next;

    public HashEntry(Object key, Object value, HashEntry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public HashEntry getNext() {
        return next;
    }

    public void setNext(HashEntry next) {
        this.next = next;
    }
}








