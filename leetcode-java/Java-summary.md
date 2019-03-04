## 一、各种数值类型最大值和最小值
```java
fmax = Float.MAX_VALUE;
fmin = Float.MIN_VALUE;
dmax = Double.MAX_VALUE;
dmin = Double.MIN_VALUE;
bmax = Byte.MAX_VALUE;
bmin = Byte.MIN_VALUE;
cmax = Character.MAX_VALUE;
cmin = Character.MIN_VALUE;
shmax = Short.MAX_VALUE;
shmin = Short.MIN_VALUE;
imax = Integer.MAX_VALUE;
imin = Integer.MIN_VALUE;
lmax = Long.MAX_VALUE;
lmin = Long.MIN_VALUE;
```

## 二、字符串相关
### 1. String转其他类型
```JAVA
//int、long
public void test() {
    String sInt = "123";
    int s = Integer.parseInt(sInt);
    long ls = Long.parseLong(sInt);
    System.out.println(s + " " + ls);
}

//char[]
String str = new String("abcedfghig");
char[] chr  = str.toCharArray();
```

### 2. StringBuffer
StringBuffer类和String一样，也用来代表字符串，只是由于StringBuffer的内部实现方式和String不同，所以StringBuffer在进行字符串处理时，不生成新的对象，在内存使用上要优于String类。 所以在实际使用时，如果经常需要对一个字符串进行修改，例如插入、删除等操作，使用StringBuffer要更加适合一些。 在StringBuffer类中存在很多和String类一样的方法，这些方法在功能上和String类中的功能是完全一样的。 但是有一个最显著的区别在于，对于StringBuffer对象的每次修改都会改变对象自身，这点是和String类最大的区别。 另外由于StringBuffer是线程安全的，所以在多线程程序中也可以很方便的进行使用，但是程序的执行效率相对来说就要稍微慢一些。

#### 2.1 String 转 StringBuffer
```java
StringBuffer s = new StringBuffer("abc");
```

#### 2.2 append() 方法，将内容追加到StringBuffer末尾
```java
StringBuffer s = new StringBuffer("abc");
s.append("efg");
System.out.println(s.toString());
```

#### 2.3 deleteCharAt(int index) 方法，作用是删除指定位置的字符，然后将剩余的内容形成新的字符串，第一位为0。
s.delete(int start,int end) 该方法的作用是删除指定区间以内的所有字符，包含start，不包含end索引值的区间。
```java
StringBuffer s = new StringBuffer("abc");
s.append("efg");
s.deleteCharAt(2);
s.delete(0,2);
```

#### 2.4 insert(int offset, String str) 方法，作用是在StringBuffer对象中插入内容，然后形成新的字符串。例如：
```java
StringBuffer sb = new StringBuffer("TestString");
sb.insert(4,"hello");
System.out.println(sb.toString());
```

#### 2.5 reverse() 方法，作用是将StringBuffer对象中的内容反转，然后形成新的字符串。例如：
```java
StringBuffer sb = new StringBuffer("TestString");
sb.reverse();
System.out.println(sb.toString());  // ---> gnirtStseT
```

#### 2.6 setCharAt(int index, char ch) 方法，作用是修改对象中索引值为index位置的字符为新的字符ch。例如：
```java
StringBuffer sb = new StringBuffer("bc");
sb.setCharAt(1,'D');  // ---> sb = ”aDc”
```

## 三、数组
### 1.排序
Array.Sort() 快排
```java
public void test() {
    int[] arrayToSort = new int[] { 48, 5, 89, 80, 81, 23, 45, 16, 2 };
    System.out.println("排序前");
    for (int i = 0; i < arrayToSort.length; i++)
        System.out.println(arrayToSort[i]);
    // 调用数组的静态排序方法sort
    Arrays.sort(arrayToSort);
    System.out.println("排序后");
    for (int i = 0; i < arrayToSort.length; i++)
        System.out.println(arrayToSort[i]);
}
```

### 2.数组与list转换
#### 2.1 数组转list，调用Arrays.asList()方法：
```java
public static <T> List<T> asList(T... a) {
    return new ArrayList<>(a);
}
String[] strings = str.split(" ");
List<String> list = Arrays.asList(strings);
```

#### 2.2 list转数组
```java
List list = new ArrayList();
list.add("1");
list.add("2");
final int size =  list.size();
String[] arr = (String[])list.toArray(new String[size]);
```

## 四、数字
### 1.比大小
```java
Math.max(int a, int b); Math.max(float a, float b); Math.min(int a, int b);

public void testMain() throws Exception {
    int a = 100;
    int b = 200;

    System.out.println(Math.max(a,b));
    System.out.println(Math.min(a,b));
}
```

### 2.Hash
HashMap put返回值

leetcode 中 205. Isomorphic Strings这道题，在 discuss 中，有用到 map.put(key, value)的返回值，查看源码可以发现其**返回值为之前存进去key对应的value**。

jdk源码注释 @return the previous value associated with key, ornull if there was no mapping forkey. (A null return can also indicate that the map previously associated null with key,if the implementation supports null values.)
```java
public void test() {
    Map<Character,Integer> m = new HashMap<>();
    System.out.println(m.put('a',2));
    System.out.println(m.put('b',3));
    System.out.println(m.put('a',1));
    System.out.println(m.put('a',5));
}

// ---> null null 2 1
```

## 五、常用的现成数据结构类
### 1.线性表（List接口，有序的 collection（也称为序列）。
此接口的用户可以对列表中每个元素的插入位置进行精确地控制。用户可以根据元素的整数索引（在列表中的位置）访问元素，并搜索列表中的元素。与 set 不同，列表通常允许重复的元素。）
* Stack，堆栈
* Vector, 动态数组
* ArrayList, 实现了List接口的动态数组
* LinkedList, List 接口的链接列表实现，包含队列、双端队列的API，同时实现Queue接口
```java
//Collections的reverse方法()、sort()方法

// reverse(list) 反转
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(3);
list.add(1);
list.add(2);
Collections.reverse(list);   // 使用Collections的reverse方法，直接将list反转
// ---> list = {2, 1, 3}

// sort() 升序排序
Collections.sort(list);   // ---> list = {1, 2, 3}

// 升序在反转就相当于降序
```

### 2.映射(Map接口，将键映射到值的对象。一个映射不能包含重复的键；每个键最多只能映射到一个值)
* Hashtable，此类实现一个哈希表，该哈希表将键映射到相应的值。任何非 null 对象都可以用作键或值。
* HashMap,基于哈希表的 Map 接口的实现。此实现提供所有可选的映射操作，并允许使用 null 值和 null 键。（除了非同步和允许使用 null 之外，HashMap 类与 Hashtable 大致相同。）
* LinkedHashMap，Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序，为插入顺序。
* TreeMap，基于红黑树，该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序，具体取决于使用的构造方法。

### 3.集合(Set接口是一个不包含重复元素的集合)
* HashSet，此类实现 Set 接口，由哈希表支持，元素存储迭代没有固定顺序
* LinkedHashSet，具有可预知迭代顺序的 Set 接口的哈希表和链接列表实现，顺序为插入顺序
* TreeSet，元素是内部排序的，使用元素的自然顺序对元素进行排序，或者根据创建 set 时提供的 Comparator 进行排序，具体取决于使用的构造方法。

### 4.优先队列
* PriorityQueue,一个基于优先级堆的无界优先级队列。优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序。元素小的优先级高，输出时先输出。实现Queue接口

### 5.其他常用的类，直接使用类中的静态方法
* 类Arrays，此类包含用来操作数组（比如排序和搜索）的各种方法。
* Math类，Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。
* Boolean,Byte,Short,Interger,Long,Double,Floate,Charcter等八种基本类型对应的包装类。

## 六、集合的Stack、Queue、Map的遍历
### 1.Map的遍历
```java
public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        // put值
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        //最简洁、最通用的遍历方式
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }  
    }
}
```

### 2.Queue队列的遍历
```java
public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedBlockingQueue<Integer>();
        //初始化队列
        for (int i = 0; i < 5; i++) {
            q.offer(i);
        }
        System.out.println("-------1-----");
        //集合方式遍历，元素不会被移除
        for (Integer x : q) {
            System.out.println(x);
        }
        System.out.println("-------2-----");
        //队列方式遍历，元素逐个被移除
        while (q.peek() != null) {
            System.out.println(q.poll());
        }
    }
}
```

### 3.Stack栈的遍历
```java
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }
        //集合遍历方式
        for (Integer x : s) {
            System.out.println(x);
        }
        System.out.println("------1-----");
        // 栈弹出遍历方式
        // while (s.peek()!=null) {     //不健壮的判断方式，容易抛异常，正确写法是下面的
        while (!s.empty()) {
            System.out.println(s.pop());
        }
        System.out.println("------2-----");
        // 错误的遍历方式
        // for (Integer x : s) {
        //        System.out.println(s.pop());
        // }
    }
}
```
在遍历集合时候，优先考虑使用foreach语句来做，这样代码更简洁些。

## 七、length,length(),size() 的使用与区别
length属性是==针对数组==说的，比如说你声明了一个数组，想知道这个数组的长度则用到了length这个属性。

length()方法是==针对字符串String==说的，如果想看这个字符串的长度则用到length()这个方法。

size()方法是==针对泛型集合泛型集合(Collection)如Set、List、Map==说的，如果想看这个泛型有多少个元素，就调用此方法来查看。数组没有size()方法。
```java
public static void main(String[] args) {
    String[] list = {"hello", "baidu"};
    String a = "hellobaidu";
    List<Object> array = new ArrayList();
    array.add(a);

    System.out.println(list.length);
    System.out.println(a.length());
    System.out.println(array.size());
}

// ---> 2  10  1
```

## 八、lamdba表达式排序
> 排序函数：返回1表示函数返回true，希望调整顺序；返回-1表示返回false，不希望调整顺序

### 1. Array.sort()
```java
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    @Test
    public void test1(){
        /**
         * Arrays.sort()使用
         */
        //被排序的字符串数组
        String[] months = {"January","February","March","April","May","June","July","August","September","October","December"};
        //按字符串长度排序
        //1.
        Arrays.sort(months, (a, b) -> Integer.signum(a.length() - b.length()));
        //2.
        Arrays.sort(months, Comparator.comparingInt(String::length));
        //3.
        Arrays.sort(months, (a, b) -> a.length() - b.length());
        //4.
        Arrays.sort(months,
                (String a, String b) -> { return Integer.signum(a.length() - b.length()); }
        );

        System.out.println(Arrays.toString(months));
    }
}
```

### 2. Collections.sort()
```java
public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(11, 3, 4));

		//利用lambda传入排序行为，下面两种方式都可以
		list.sort((Integer x, Integer y) -> x < y? 1 : -1);

		Collections.sort(list, (Integer x, Integer y) -> x < y? 1 : -1);

		System.out.println(list);
	}
}
```

## 九、Java集合常用方法
### 1. list
| 返回类型 | 方法名称                   | 说明                               |
| -------- | -------------------------- | ---------------------------------- |
| boolean  | add(Object obj)            | 加入元素，返回是否添加成功         |
| boolean  | clear()                    | 清除集合中的元素                   |
| boolean  | contains(Object obj)       | 查找集合中是否存在传入的元素       |
| Object   | get(int index)             | 获取指定位置的元素                 |
| boolean  | isEmpty()                  | 判断集合是否为空                   |
| Object   | remove(int index)          | 删除制定位置的元素，并返回该元素   |
| int      | size()                     | 获取集合大小                       |
| Object[] | toArray()                  | 将集合转换成一个数组               |
| Object   | set(int index, Object obj) | 替换指定位置的元素，返回旧元素     |
| boolean  | addAll(Collection c)       | 将collection的元素按顺序添加到末尾 | 

### 2. map
| 返回类型 | 方法名称                     | 说明                                                                  |
| -------- | ---------------------------- | --------------------------------------------------------------------- |
| Object   | put(Object key,Object value) | 加入元素，返回与此key关联的原有的value，不存在则返回null              |
| void     | clear()                      | 从集合中移除所有的元素                                                |
| boolean  | containsKey(Object key)      | 根据key从集合中判断key是否存在                                        |
| boolean  | containsValue(Object value)  | 根据value从集合中判断value是否存在                                    |
| Object   | get(Object key)              | 根据key返回key对应的值                                                |
| Set      | keySet()                     | 返回Map集合中包含的键集合                                             |
| Object   | remove(Object key)           | 从集合中删除key对应的元素，返回与key对应的原有value，不存在则返回null |
| int      | size()                       | 返回集合中的元素的数量                                                |

### 3. set
| 返回类型 | 方法名称             | 说明                            |
| -------- | -------------------- | ------------------------------- |
| boolean  | add(Object obj)      | 加入元素                        |
| void     | clear()              | 移除Set集合中所有元素           |
| boolean  | contains(Object obj) | 判断Set集合中是否包含指定元素   |
| boolean  | isEmpty()            | 判断Set集合是否为空             |
| Iterator | iterator()           | 返回Set集合中对元素迭代的迭代器 |
| boolean  | remove(Object obj)   | 从集合中删除元素                |
| Int      | size()               | 返回集合中的元素数量            |

### 4. stack
eg：Stack<Integer> st = new Stack<Integer>()

| 返回类型 | 方法名称               | 说明                                             |
| -------- | ---------------------- | ------------------------------------------------ |
| boolean  | empty()                | 测试堆栈是否为空。                               |
| Object   | peek()                 | 查看堆栈顶部的对象，但不从堆栈中移除它。         |
| Object   | pop()                  | 移除堆栈顶部的对象，并作为此函数的值返回该对象。 |
| Object   | push(Object element)   | 把项压入堆栈顶部。                               |
| int      | search(Object element) | 返回对象在堆栈中的位置，以 1 为基数              |

### 5. queue
eg：Queue<String> queue = new LinkedList<String>()

| 返回类型 | 方法名称              | 说明                                              |
| -------- | --------------------- | ------------------------------------------------- |
| boolean  | offer(Object element) | 添加一个元素并返回true 如果队列已满，则返回false  |
| Object   | poll()                | 移除并返问队列头部的元素 如果队列为空，则返回null |
| Object   | peek()                | 返回队列头部的元素 如果队列为空，则返回null       |

#### priorityQueue
```java
// 默认实现了一个最小堆。
Queue<Integer> priorityQueue = new PriorityQueue<>();

// 实现最大堆
Queue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val-o2.val;
    }
});
```
