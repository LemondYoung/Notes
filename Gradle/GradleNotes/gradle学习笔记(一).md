> gradle基本命令

```
demo：
task hello{
    doLast{
        println 'Hello World!'
    }
}


gradle -q [Task]  -> 执行当前文件夹下的build.gradle文件中Task任务
-q: 用于控制gradle日志的输出级别

---

gradle wrapper -> 统一团队的gradle版本
gradle wrapper --gradle-version [版本号] -> 用于指定使用的gradle版本
gradle wrapper --gradle-distribution-url -> 用于指定下载gradle发行版的url地址

---

gradle -[level] tasks -> 用于输出>=level的日志
默认：level -> lifecycle

level :
e -> error -> 错误消息
q -> quiet -> 重要消息
w -> warning -> 警告消息
l -> lifecycle -> 进度消息
i -> info -> 信息消息
d -> debug -> 调试消息

---

gradle -> 默认没有堆栈信息的输出
gradle -s 或者 --stacktrace -> 输出关键性的堆栈信息
gradle -S 或者 --full-stacktrace -> 输出全部的堆栈信息

---
【华丽分割线】
---

./gradlew -?  ->查看帮助
./gradlew -h  ->查看帮助
./gradlew -help  ->查看帮助

./gradlew tasks -> 查看所有可执行的Tasks
./gradlew help --task [task] -> 了解每一个Task的使用帮助

./gradlew --refresh-dependencies assemble -> 强制刷新依赖

./gradlew clean jar -> 多任务执行：先执行clean，然后在执行jar，空格区分

./gradlew connectCheck <=> ./gradlew cc -> 名称缩写

```