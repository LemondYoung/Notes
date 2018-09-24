【Android群英传】学习笔记（二）
---

> 在本篇笔记中，小编将记录关于Android Studio使用过程的小技巧

> 在下面文章为Android Studio 简称As

### ① 使用Android Studio第一次创建项目等待时间很长？

- 原因：
> 在Android Studio第一次创建项目的时候之所以时间长，原因就是As在下载gradle的相关配置文件

- 解决方法：
在用户的配置文件中有这个文件夹：
![](http://images2015.cnblogs.com/blog/653583/201609/653583-20160902090457136-1359250032.png)

这串奇怪的数字是随机生成的，然后我们去[AndroidDev](http://www.androiddevtools.cn/)中下载对应的Gradle文件
![](http://images2015.cnblogs.com/blog/653583/201609/653583-20160902091424933-262938567.png)

下载完成后，把对应的版本号的gradle.zip复制到上述的文件夹下就可以，不用解压，复制zip就可以，然后在As运行的时候程序会自动解压这个zip，这样我们就实现了偷梁换柱的作用了

重启As之后，在创建新工程就只需要下载一些jcenter的依赖包，这些都很小，应该很快就下载好

### ②导入他人的As项目卡慢？
- 原因：
> 卡慢的原因是在与Gradle版本不一致原因导致，在导入他人的Gradle时候，由于版本不一致，As会去下载他人版本的Gradle版本，这样的话，让我们的等到时间就变长了

- 解决方法：
我们使用我的本地的As创建一个新的项目，然后复制我们项目中的`gradle`和`build.gradle`
![](http://images2015.cnblogs.com/blog/653583/201609/653583-20160902092344121-1921837241.png)

然后替换他人项目的这两个文件即可

---

### 相关文章推荐：
- [AS-->创建项目(慢)和打开项目(慢)等需要注意的问题](http://blog.csdn.net/angcyo/article/details/52229283)
