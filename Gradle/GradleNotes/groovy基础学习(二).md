> groovy是基于JVM虚拟机的一种动态语言，其完全兼容java，又在此基础上增加了很多的动态类型和灵活的特征，支持闭包，DSL，是一门非常灵活的动态脚本语言

### 字符串

> 在groovy中，分号不是必须的；单引号和双引号都可以定义一个字符串常量，不同的是单引号标记的是纯粹的字符串常量，而不是对字符串里的表达式做运算，但是双引号可以

```
task printStringClass << {
    def str1 = '单引号'
    def str2 = "双引号"

    println "单引号定义的字符串类型："+str1.getClass().name
    println "双引号定义的字符串类型："+str2.getClass().name
}

> Task :printStringClass
单引号定义的字符串类型：java.lang.String
双引号定义的字符串类型：java.lang.String

---

task printStringVar << {
    def name = "张三"

    println '单引号的变量计算：${name}'
    println "双引号的变量计算：${name}"
}

> Task :printStringVar
单引号的变量计算：${name}
双引号的变量计算：张三

=> 从以上可以看出单引号没有运算能力，它只是一个常量字符串
```


### 集合
> groovy完全兼容Java的集合，并且进行了扩展，常见的集合有：List,Set,Map和Queue

```
task printList << {
    def numList = [1,2,3,4,5,6]
    println numList.getClass().name

    println numList[1] //访问第二个元素
    println numList[-1] //访问最后一个元素
    println numList[-2] //访问倒数第二个元素
    println numList[1..3] //访问第二个到第四个元素

    numList.each{
        println it //it代表正在迭代的元素
    }
}

//对于集合，Groovy还提供了诸如collect find findAll等便捷的方法
```

### Map和Java很像，也是Key Value对应的关系

```
task printlnMap << {
    def map1 = ['width':1024,'height':768]
    println map1.getClass().name

    println map1['width']
    println map1.height

    map1.each{
        println "Key:${it.key},Value:${it.value}"
    }
}

> Task :printlnMap
java.util.LinkedHashMap
1024
768
Key:width,Value:1024
Key:height,Value:768
```

### 方法

> 括号可以省略

```
task invokeMethod << {
    method1(1,2)
    method1 1,2
}

def method1 (int a , int b ){
    println a + b
}

> Task :invokeMethod
3
3
```

### return 是可以不写的

> 在Groovy中，我们定义了有返回值的方法时，return语句不是必需的。当没有return的时候，Groovy会把方法执行过程中的最后一句代码作为其返回值

```
task printMethodReturn << {
    def add1 = method2 1,2
    def add2 = method2 5,3
    println "add1: ${add1},add2: ${add2}"
}

def method2 (int a , int b ){
    if(a>b){
        a
    }else{
        b
    }
}

> Task :printMethodReturn
add1: 2,add2: 5
```

### 代码块是可以作为参数传递的

> 代码块-一段被花括号包围的代码，其实就是所谓的闭包。Groovy是允许其作为参数传递的，但是结合我们上述讲的方法的特征来用，最后的基于闭包的方法调用就会非常优雅，易读

```
//呆板的写法
numList.each({println it})

//格式化
numList.each({
    println it
})

//Groovy规定，如果方法的最后一个参数是闭包，可以放到方法外面
numList.each(){
    println it
}

//然后方法可以省略
numList.each{
    println it
}

```

### JavaBean

> 在例子中，我们可以看到我们并没有定义age变量，但是一样可以通过p.age获取到该值，这是因为定义了getAge()方法，我们不能修改age的值，因为我们没有定义setter方法

```
task helloJavaBean << {
    Person p = new Person()

    println "名字是：${p.name}"
    p.name = "张三"
    println "名字是：${p.name}"
    println "年龄是：${p.age}"
}

class Person{
    private String name
    public int getAge(){
        12
    }
}
```