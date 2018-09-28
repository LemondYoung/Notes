### if 

```
if condition
then
    command1
    command2
    ...
    commandN
fi

```

### if else

```
if condition
then
    command1
    command2
    ...
    commandN
else
    command
fi

```

### if else-if else

```
if condition
then
    command1
elif condition2
then
    command2
else
    commandN
fi
```

```
a=10
b=20
if [ $a == $b ]
then
   echo "a 等于 b"
elif [ $a -gt $b ]
then
   echo "a 大于 b"
elif [ $a -lt $b ]
then
   echo "a 小于 b"
else
   echo "没有符合的条件"
fi
```

```
num1=$[2*3]
num2=$[1+5]
if test $[num1] -eq $[num2]
then
    echo '两个数字相等!'
else
    echo '两个数字不相等!'
fi

```

---

### for循环

```
for var in item1 item2 ... itemN
do
    command1
    command2
    ...
    commandN
done
```

```
# in列表是可选的，如果不用它，for循环使用命令行的位置参数

for loop in 1 2 3 4 5
do
    echo "The value is: $loop"
done
```

### while

```
while condition
do
    command
done
```

```
echo '按下 <CTRL-D> 退出'
echo -n '输入你最喜欢的网站名: '
while read FILM
do
    echo "是的！$FILM 是一个好网站"
done
```

### 无限循环

```
while : # while true || for(( ; ;))
do
    command
done
```

### until循环

- until 循环执行一系列命令直至条件为 true 时停止。
- until 循环与 while 循环在处理方式上刚好相反。
- 一般 while 循环优于 until 循环，但在某些时候—也只是极少数情况下，until 循环更加有用

```
until condition
do
    command
done
```

### case

> Shell case语句为多选择语句。可以用case语句匹配一个值与一个模式，如果匹配成功，执行相匹配的命令

```
case 值 in
模式1)
    command1
    command2
    ...
    commandN
    ;;
模式2）
    command1
    command2
    ...
    commandN
    ;;
esac
```

```
echo '输入 1 到 4 之间的数字:'
echo '你输入的数字为:'
read aNum
case $aNum in
    1)  echo '你选择了 1'
    ;;
    2)  echo '你选择了 2'
    ;;
    3)  echo '你选择了 3'
    ;;
    4)  echo '你选择了 4'
    ;;
    *)  echo '你没有输入 1 到 4 之间的数字'
    ;;
esac
```

### break命令

> break命令允许跳出所有循环（终止执行后面的所有循环）

### continue

> 不会跳出所有循环，仅仅跳出当前循环

### esac

> 它需要一个esac（就是case反过来）作为结束标记，每个case分支用右圆括号，用两个分号表示break