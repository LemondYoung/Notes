> 显示普通字符串

```
echo "Hello"
```

> 显示转义字符

```
echo "\"Hello"\"

->
"Hello"
```

> 显示变量

```
#!/bin/bash
read name 
echo "$name It is a test"

-> sh test.sh
OK #标准输入
OK It is a test #输出
```

> 显示换行

```
echo -e "OK \n" # -e 开启转义
echo "It is a test"

->
OK

It is a test
```

> 显示不换行

```
#!/bin/sh
echo -e "OK \c" #-e 开启转义 \c 不换行
echo "It is a test"

->
OK It is a test
```

> 显示结果定向至文件

```
echo "It is a test" > myfile
```

> 原样输出字符串，不进行转义或取变量（用单引号）

```
echo '$name\"'

->
$name\
```

> 显示命令执行结果

```
echo `date`

->
Thu Jul 24 10:08:46 CST 2014
```