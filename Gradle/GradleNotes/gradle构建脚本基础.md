### Settings文件
> 定义了一个配置文件，用于初始化以及工程树的配置

```

include ':example'
project (':example').projectDir = new File(rootDir , 'dir1/dir2')


->
include ':bodySDK'
project(':bodySDK').projectDir = new File('../BodySDK/bodySDK')

==> 扩展
String curPath = '../QuickAs'

//创建一个列表
ArrayList<String> filterArrays = new ArrayList<>()
filterArrays.add("quickBase")

//遍历并且加载
file(curPath).eachDir{dir -> 
    if(filter(dir.name,filterArrays)){
        include dir.name
        project(":${dir.name}").projectDir = dir
    }
}

boolean filter(String filtername,ArrayList<String> lists) {
    for(String name:lists){
        if(name.equals(filtername)){
            return true
        }
    }
    return false
}

```

### Tasks
> Task是一个操作，一个原子性的操作，比如打个jar包，复制一份文件，编译一次Java代码，上传一个jar到Maven仓库等，这就是一个Task

### 创建一个Task

> Task 看着像一个关键字，其实它是Project对象的一个函数，原型为：create(String name ,Closure configureClosure)

```
//两种方式效果一样
task customTask1 {
    doFirst{
        println 'customTask1:doFirst'
    }
    doLast{
        println 'customTask1:doLast'
    }
}

tasks.create("customTask2"){
    doFirst{
        println 'customTask2:doFirst'
    }
    doLast{
        println 'customTask2:doLast'
    }
}

```

### 任务依赖

```
//单依赖
task ex35Hello << {
    println 'Hello'
}

task ex35Main (dependsOn: ex35Hello){
    doLast{
        println 'Main'
    }
}

->
> Task :ex35Hello
Hello

> Task :ex35Main
Main


//多依赖
task ex35Hello << {
    println 'Hello'
}

task ex35World << {
    println 'World'
}

task ex35MultiTask{
    dependsOn ex35Hello,ex35World
    doLast{
        println 'MultiTask'
    }
}

->
> Task :ex35Hello
Hello

> Task :ex35World
World

> Task :ex35MultiTask
MultiTask

```

### 任务间通过API控制和交互
> 创建一个任务和我们定义一个变量是一样的，变量名就是我们的任务名，类型为Task，我们可以通过任务名，使用Task的API访问它的方法等

```
task ex36Hello << {
    println 'dowList1'
}

ex36Hello.doFirst{
    println 'dowFirst'
}

ex36Hello.doLast{
    //运行后为TRUE，说明每个任务都是Project的一个属性
    println project.hasProperty('ex36Hello')
    println 'dowLast'
}

```
### 自定义属性
> Project和Task都允许用户添加额外的自定义属性，要添加额外的属性，通过应用所属对应的ext属性即可实现。添加之后可以通过ext属性对自定义属性读取和配置，如果要同时添加多个属性，可以ext代码块

```
//单一
ext.age = 18

//多个
ext{
    phone = 18 
    address = ''
}


task ex37CustomProperty << {
    println "年龄是：${age}"
    println "电话是：${phone}"
    println "地址是：${address}"
}

//说明
在Android项目中，我们一般使用它来自定义版本号和版本名称，把它们单独放到一个Gradle文件中。
```

### 脚本->代码  代码->脚本

> gradle文件可以与Grovvy，Java以及Gradle的任何语法一起使用，这样我们可以更加自由的去使用

```
// 捕获日期格式，生成APK的名字
def buildTime(){
    def date = new Date()
    def formattedDate = date.format('yyMMdd')
    return formattedDate
}

```