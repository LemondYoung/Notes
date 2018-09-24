
在最底层，Java中的数据通过使用操作符来操作的

## 使用操作符

操作符作用于操作数，生成一个新值。另外，有些操作数可能会改变操作数自身的值，这被称为“副作用”。那些用来改变操作数的操作符，最普遍的用途就是用来产生副作用。但要记住，使用此类副作用生成的值，与使用没有副作用的操作符生成的值，没有什么区别

## 赋值

> 在对一个对象进行操作时，我们真正操作的是对象的引用。所以倘若“将一个对象赋值为另一个对象”，实际是将“引用”从一个地方赋值到另一个地方。这意味着：假如对对象使用c=d，那么c和d都指向原来只有d指向的那个对象。

Eg：

```Java
public class Thinking_03_0304 {
    public static void main(String args[]) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();

        t1.level = 9;
        t2.level = 47;

        System.out.println("1: t1.level：" + t1.level + "  ,  t2.level：" + t2.level);

        t1 = t2;

        System.out.println("2: t1.level：" + t1.level + "  ,  t2.level：" + t2.level);

        t1.level = 27;

        System.out.println("3: t1.level：" + t1.level + "  ,  t2.level：" + t2.level);

    }
}

class Tank {
    int level;

}

/**
 * 1: t1.level：9  ,  t2.level：47
 * 2: t1.level：47  ,  t2.level：47
 * 3: t1.level：27  ,  t2.level：27
 */

```

<!-- more --> 

关于上述的代码，逻辑图为一下所示：

![逻辑图](http://oj1wth4ml.bkt.clouddn.com/Thinking%20in%20java%20_%E6%93%8D%E4%BD%9C%E7%AC%A6_01.png)

在上述代码只能中，t1,t2创建了两个内存空间，但是经过t1=t2，将t1的引用指向t2，那么说，在经过t1.level=27的设置，同时也导致了t2的变化


## 算数操作符

> Thinking in java 第四版中41页的关于算数操作符的代码中，有一段关于随机数的解释：

通过在创建Random对象提供种子（用于随机数生成器的初始化值，随机数生成器对于特定的种子值总是产生相同的随机数序列），就可以在每次执行程序时都生成相同的随机数，因此其输出是可验证的

```java
Random random = new Random(47);
```

`数字47至今仍然被称为魔幻数字`

## 自动递增和递减

- 前缀递增表示：`++` 操作符位于变量或表达式的前面
- 后缀递增表示：`++` 操作符位于变量或表达式的后面
- 前缀递减表示：`--` 操作符位于变量或表达式的前面
- 后缀递减表示：`--` 操作符位于变量或表达式的后面

- 前缀递增和前缀递减（`++a`或`--a` ），会先执行运算，再生成值
- 后缀递增和后缀递减（`a++`或`a--` ），会先生成值，在执行运算

Eg：

```java
public class Thinking_03_0306 {
    public static void main(String args[]) {
        int i = 1;

        System.out.println("i：" + i);
        System.out.println("++i：" + ++i);
        System.out.println("i++：" + i++);

        System.out.println("i：" + i);

        System.out.println("--i：" + --i);
        System.out.println("i--：" + i--);

        System.out.println("i：" + i);

    }
}

/**
 * i：1
 * ++i：2
 * i++：2
 * i：3
 * --i：2
 * i--：2
 * i：1
 */
```


## 关系操作符

### 测试对象的等价性

> 关系操作符 ==  和 != 也适用于所有对象

```java

public class Thinking_03_030701 {
    public static void main(String args[]) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);

        System.out.println(n1 == n2);  //false
        System.out.println(n1 != n2);  //true

    }
}
```

上述：尽管两个对象的内容相同，但是对象的引用却不同，而==和!=比较的是对象的引用，如果相比较两个对象的内容相同，则应该使用特殊的方法equals()。

`equalse()默认的行为是比较引用，所有除非在自己的新类中覆盖equals()方法，否则不可能表现出我们希望的行为`

### 逻辑操作符

如果在应该使用String值的地方使用了布尔值，布尔值会自动转换成适当的文本形式

在逻辑操作符的时候主要&&的短路运算


## 按位操作符

> 按位操作符用来操作整数基本数据类型中的单个“比特”(bit)，即二进制位。按位操作符会对两个参数中对应的位执行布尔代数运算，并最终生成一个结果

- 按位操作符和逻辑操作符都是用了同样的符号，含义和逻辑操作符相同
- 我们将布尔类型作为一种单比特值对待，但是它不能执行按位`非`
- 对于布尔值，按位操作符具有与逻辑操作符一样的效果，知识他们不会中途`短路`
- 在移位操作符中，不能使用布尔运算

## 移位操作符

> 操作对象：二进制位
> 只可处理整数类型

### 规则
- 左移位操作符（<<）能按照操作符右侧指定的位数将操作符左边的操作数向左移动（在低位补0）
- `有符号`右移操作符（>>）则按照操作符右侧指定的位数将操作符左边的操作数向右移动
- `有符号`右移位操作符使用`符号扩展`：
 - 若符号为正，则在高位插0；
 - 若符号位负，则在高位插1；
- 增加一种`无符号`右移操作符（>>>），它使用`零扩展`，无论正负都在高位插0
