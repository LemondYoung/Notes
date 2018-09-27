## 基本运算符

> expr 是一款表达式计算工具，使用它可以完成表达式的求值工作

```
#!/bin/bash

# 表达式和运算符之间要有空格
# 2 + 2  => OK
val = `expr 2 + 2 `
echo "两数之和为：$val"
```

---

## 算数运算符

> 乘号(*)前边必须加反斜杠(`\`)才能实现乘法运算；

` +` `-` `*` `/ `

`%` `=` `==` `!=`


```
#!/bin/bash

a=10
b=20

val=`expr $a + $b`
echo "a + b : $val"

val=`expr $a - $b`
echo "a - b : $val"

val=`expr $a \* $b`
echo "a * b : $val"

val=`expr $b / $a`
echo "b / a : $val"

val=`expr $b % $a`
echo "b % a : $val"

if [ $a == $b ]
then
   echo "a 等于 b"
fi
if [ $a != $b ]
then
   echo "a 不等于 b"
fi

```

---

## 关系运算符

- -eq : 检测两个数是否相等
- -ne : 检测两个数是否不相等
- -gt : 检测左边的数是否大于右边的
- -lt : 检测左边的数是否小于右边的
- -ge : 检测左边的数是否大于等于右边的
- -le : 检测左边的数是否小于等于右边的

```
#!/bin/bash

a=10
b=20

if [ $a -eq $b ]
then
   echo "$a -eq $b : a 等于 b"
else
   echo "$a -eq $b: a 不等于 b"
fi
if [ $a -ne $b ]
then
   echo "$a -ne $b: a 不等于 b"
else
   echo "$a -ne $b : a 等于 b"
fi
if [ $a -gt $b ]
then
   echo "$a -gt $b: a 大于 b"
else
   echo "$a -gt $b: a 不大于 b"
fi
if [ $a -lt $b ]
then
   echo "$a -lt $b: a 小于 b"
else
   echo "$a -lt $b: a 不小于 b"
fi
if [ $a -ge $b ]
then
   echo "$a -ge $b: a 大于或等于 b"
else
   echo "$a -ge $b: a 小于 b"
fi
if [ $a -le $b ]
then
   echo "$a -le $b: a 小于或等于 b"
else
   echo "$a -le $b: a 大于 b"
fi
```

---

## 布尔运算符

- `!` : 非运算
- `-o` : 或运算
- `-a` : 与运算

```
#!/bin/bash

a=10
b=20

if [ $a != $b ]
then
   echo "$a != $b : a 不等于 b"
else
   echo "$a != $b: a 等于 b"
fi
if [ $a -lt 100 -a $b -gt 15 ]
then
   echo "$a 小于 100 且 $b 大于 15 : 返回 true"
else
   echo "$a 小于 100 且 $b 大于 15 : 返回 false"
fi
if [ $a -lt 100 -o $b -gt 100 ]
then
   echo "$a 小于 100 或 $b 大于 100 : 返回 true"
else
   echo "$a 小于 100 或 $b 大于 100 : 返回 false"
fi
if [ $a -lt 5 -o $b -gt 100 ]
then
   echo "$a 小于 5 或 $b 大于 100 : 返回 true"
else
   echo "$a 小于 5 或 $b 大于 100 : 返回 false"
fi
```

---

## 逻辑运算符

- `&&` : 逻辑的AND
- `||` : 逻辑的OR

```
#!/bin/bash

a=10
b=20

if [[ $a -lt 100 && $b -gt 100 ]]
then
   echo "返回 true"
else
   echo "返回 false"
fi

if [[ $a -lt 100 || $b -gt 100 ]]
then
   echo "返回 true"
else
   echo "返回 false"
fi
```
---

## 字符串运算符

- `=` : 检测两个字符串是否相等 => 相等->true
- `!=` : 检测两个字符串是否相等 => 不相等->true
- `-z` : 检测字符串长度是否为0 => 为0 ->true
- `-n` : 检测字符串长度是否为0 => 不为0 ->true
- `str` : 检测字符串是否为空 => 不为空 ->true

```
#!/bin/bash

a="abc"
b="efg"

if [ $a = $b ]
then
   echo "$a = $b : a 等于 b"
else
   echo "$a = $b: a 不等于 b"
fi
if [ $a != $b ]
then
   echo "$a != $b : a 不等于 b"
else
   echo "$a != $b: a 等于 b"
fi
if [ -z $a ]
then
   echo "-z $a : 字符串长度为 0"
else
   echo "-z $a : 字符串长度不为 0"
fi
if [ -n "$a" ]
then
   echo "-n $a : 字符串长度不为 0"
else
   echo "-n $a : 字符串长度为 0"
fi
if [ $a ]
then
   echo "$a : 字符串不为空"
else
   echo "$a : 字符串为空"
fi
```
---

## 文件测试运算符

文件测试运算符用于检测 Unix 文件的各种属性

> 地址：http://www.runoob.com/linux/linux-shell-basic-operators.html