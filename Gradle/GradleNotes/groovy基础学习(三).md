> 闭包是Groovy的一个非常重要的特征，可以说是DSL的基础。闭包可以使代码灵活，轻量，可复用，再也不用像Java一样动不动就用一个类了。虽然Java后来有了匿名内部类，但是一样的冗余不灵活

### 什么使闭包？
ref : https://www.zhihu.com/question/34210214

> 一个持有外部环境变量的函数就是闭包

```
我叫独孤求败，我在一个山洞里，里面有世界上最好的剑法，还有最好的武器。我学习了里面的剑法，拿走了最好的剑。离开了这里。我来到这个江湖，快意恩仇。但是从来没有人知道我这把剑的来历，和我这一身的武功。。。那山洞就是一个闭包，而我，就是那个山洞里唯一一个可以与外界交汇的地方。这山洞的一切对外人而言就像不存在一样，只有我才拥有这里面的宝藏！

作者：哦嚯
链接：https://www.zhihu.com/question/34210214/answer/140436901
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

```

### 初始闭包

> customEach只有一个参数，用于接收一个闭包（代码块），那么闭包使如何执行的呢？跟一对括号就可以执行了。 

```
//补充：闭包把代码块传输过去
//方法用closure去接收
//接收后 =>closure(i) => println it
task helloClosure << {
    //使用我们自定义的闭包
    customEach{
        println it
    }
}

def customEach(closure){
    //模拟一个有10个元素的集合，开始迭代
    for(int i in 1..10){
        closure(i)
    }
}

> Task :helloClosure
1
2
3
4
5
6
7
8
9
10
```

### 向包传递参数

```
task helloClosure << {
     eachMap{k,v ->
        println "${k} is ${v}"
    }
}


def eachMap(closure){
    def map1 = ["name":"张三","age":18]
    map1.each{
        closure(it.key,it.value)
    }
}

> Task :helloClosure
name is 张三
age is 18

```

### 闭包委托

> Groovy闭包的强大之处在于它支持闭包方法的委托，Groovy的闭包有`thisObject` `owner` `delegate`三个属性，当你在闭包内调用方法时，由它们来确定使用哪个对象来处理。默认下`delegate`和`owner`是相等的，但是`delegate`是可以被修改的，这个功能是非常强大的，Gradle中的闭包的很多功能都是通过修改`delegate`实现的

```

task helloDelegate << {
    new Delegate().test{
        println "thisObject:${thisObject.getClass()}"
        println "owner:${owner.getClass()}"
        println "delegate:${delegate.getClass()}"

        method1()
        it.method1()
    }
}

def method1(){
    println "Context this:${this.getClass()} in root"
    println "method1 in root"
}

class Delegate{
    def method1(){
        println "Delegate this: ${this.getClass()} in Delegate"
        println "method1 in Delegate"
    }

    def test(Closure<Delegate> closure){
        closure(this)
    }
}

> Task :helloDelegate
thisObject:class build_5vdl3sj39nu1udhjdv961fn4b
owner:class build_5vdl3sj39nu1udhjdv961fn4b$_run_closure10
delegate:class build_5vdl3sj39nu1udhjdv961fn4b$_run_closure10
Context this:class build_5vdl3sj39nu1udhjdv961fn4b in root
method1 in root
Delegate this: class Delegate in Delegate
method1 in Delegate

```

> 可以发现，thisObject的优先级最高，默认情况下，优先使用thisObject来处理闭包中调用的方法，如果有，则执行。从输出中我们也可以看到，thisObject其实就是这个构建脚本的上下文，它和脚本中的this对象是相同的；从例子中也可以证明delegate和owner是相等的，它们的优先级是owner要比delegate高，所以闭包内方法的处理顺序是：`thisObject > owner > delegate`

### DSL

```
DSL (Domain Specific Language)的中文意思是领域特定语言，说白了就是专门关注某一领域的语言，它在于专，而不是全，所以才叫领域特定的，而不是像Java这种通用全面的语言

Gradle就是一门DSL，它是给予Groovy的，专门解决自动化构建的DSL

```