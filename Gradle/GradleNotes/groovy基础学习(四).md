### 任务的创建

> 第一种方式

```
// 以一个任务名字创建任务

def Task ex41CreateTask1 = task(ex41CreateTask1)

ex41CreateTask1.doLast{
    println "创建方法原型为：Task task(String name) throws InvalidUserDataException"
}
```


> 第二种方式

```
// 以一个任务名字 + 一个对该任务配置的Map对象来创建任务

//相比第一种方式多了一个Map，下面是对起进行分组

def Task ex41CreateTask2 = task(ex41CreateTask2,group:BasePlugin.BUILD_GROUP)

ex41CreateTask2.doLast{
    println "创建方法原型为：Task task (Map<String,?> args ,String name) throws InvalidUserDataException"
    println "任务分组：${ex41CreateTask2.group}"
}

//type || overwrite || dependsOn || action || description || group

type：基于一个存在的Task来创建，和我们继承差不多，默认=>DefaultTask
overwrite：是否替换存在的Task，这个和type配合来使用，默认=>false
dependsOn：用于配置任务的依赖，默认=>[ ]
action：添加到任务中的一个Action或者一个闭包，默认=>null
description：用于配置任务的描述，默认=>null
group：用于配置任务的分组，默认=>null

```

> 第三种方式

```
//以一个任务名 + 闭包配置的方式

task ex41CreateTask3{
    description '演示任务创建'
    doLast{
        println "创建方法原型为：Task task(String name ,Closure configureClosure)"
        println '任务描述：${description}'
    }
}


//相似

task.create('ex41CreateTask4'){
    description ''
    doList{
        ...
    }
}

```

### 任务的访问

```
// 创建一个任务
task ex42AccessTask2

//访问任务
tasks ['ex42Accesstask2'].doLast{
    ...
}

//访问的时候，任务名就是「关键索引」
//[  ]在Groovy中是一个操作符 => a[b] 意思为：a.getAt(b) ==>源代码中最后调用：findByName(String name)

//访问方式：
「路径OR名字」tasks.findByPath(' ') || tasks.getByPath(' ')
「名字」tasks.findByName(' ') || tasks.getByName(' ')
```

### 任务的分组

```
//主要是对任务进行分类

def Task myTask = task ex43GroupTask
myTask.group = BasePlugin.BUILD_GROUP
myTask.description = '这是一个构建的引导任务'
myTask.doLast{
    println "group:${group},description:${description}"
}

> ./gradlew tasks

Build tasks
-----------
ex41CreateTask2
ex43GroupTask - 这是一个构建的引导任务

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Help tasks
----------

```

### <<操作符

```
// << 操作符在Gradle的Task上是doLast方法的短标记形式，也就是说<<等同于doLast
```

### 任务的执行分析

```
// 当我们执行一个task的时候，其实就是执行其拥有的actions列表，这个列表保存在Task对象实例中的actions成员变量中，其类型是一个List

private List<ContextAwareTaskAction> actions = new ArrayList<~>()

> 展示一个Task

def Task myTask = task ex45CustomTask(type: CustomTask)

myTask.doFirst{
    ...
}

myTask.doLast{
    ...
}

class CustomTask extends DefaultTask{
    @TaskAction
    def doSelf(){
        ...
    }
}

> 执行的顺序
1. ex45CustomTask
2. in doFirst
3. in doSelf
4. in doLast

> 分析
当创建ex45CustomTask的时候，Gradle会解析带有TaskAction标准的方法，并且将其添加到actions List中

然后执行到doFirst的时候，根据源代码，其实是将doLirst插入到list的0位置
然后执行到doLast的时候，根据源代码，其实是将doLast插入到list的最后的位置

```

### 任务排序「beta」

```
// 其实没有真正的任务排序功能，这个排序不像我们想象的通过设置优先级或者Order顺序实现
// 而是通过任务的shouldRunAfter 和 mustRunAfter 着两个方法
// ta们可以控制一个任务应该或者一定在某个任务之后执行

> 比如

// 必须先执行单元测试 => 进行打包 => 部署发布

taskB.showRunAfter(taskA) 表示taskB应该在taskA执行之后执行，可能被干预
taskB.mustRunAfter(taskA) 表示taskB必须在taskA执行之后执行，这个规则就比较严格

./gradlew taskA taskB

```

### 任务的启用和禁用

```
// 默认情况下：task.enabled = true 

// 任务禁用
task.enabled = false 

> 执行
task SKIPPED
```

### 任务的onlyIf判断

```
// 断言是一个条件表达式，Task有一个onlyIf方法，ta接收一个闭包作为参数
// 如果该闭包返回true，则该任务执行，否则跳过
// 比如控制程序哪些情况下可以打什么包，什么时候执行单元测试等

task myTask <<{
    ...
}

myTask.onlyIf{
    ...
}
```

### 任务规则

```
// 当我们执行，依赖一个不存在的任务时，Gradle会执行失败，失败信息是任务不存在
// 我们可以使用规则对其进行改进，当执行，依赖不存在的时候，不会执行失败，而是打印提示信息
// 提示任务不存在

tasks.addRunle("对该规则的一个描述，便于调试，查看等"){ String taskName ->
    task(taskName) << {
        println "该${taskName}任务不存在，请查证后再执行"
    }
}

task ex49RuleTask{
    dependsOn missTask
}
```