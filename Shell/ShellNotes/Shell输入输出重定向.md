- command > file 将输出重定向到file
- command < file 将输入重定向到file
- command >> file 将输出以追加的方式重定向到file
- n > file 将文件的描述符为n的文件重定向到file
- n >> file 将文件描述符为n的文件以追加的方式重定向到file
- n >&m 将输出文件m和n合并
- n <&m 将输入文件m和n合并
- << tag 将开始标记tag和结束标记tag之间的内容作为输入

> 需要注意的是文件描述符 0 通常是标准输入（STDIN），1 是标准输出（STDOUT），2 是标准错误输出（STDERR）

### /dev/null 文件

> 如果希望执行某个命令，但又不希望在屏幕上显示输出结果，那么可以将输出重定向到 /dev/null：

```
command > /dev/nul
```

> 如果希望屏蔽 stdout 和 stderr，可以这样写：

```
command > /dev/null 2>&1
```

注意：0 是标准输入（STDIN），1 是标准输出（STDOUT），2 是标准错误输出（STDERR）