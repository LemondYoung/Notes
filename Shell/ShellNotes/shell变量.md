## shell变量

### 第一个脚本

```
#! /bin/bash
echo "Hello World !"
```

> 作为可执行的脚本

```
#使脚本具有权限
chmod +x ./test.sh  

#执行脚本
./test.sh 
```

### 变量

#### 定义变量

- 变量名不加美元符号
- 变量名和等号之间不能有空格
- 命名只能使用英文字母，数字和下划线，首个字符不能以数字开头
- 中间不能有空格，可以使用下划线（_）
- 不能使用标点符号

```
#将 /etc 下目录的文件名循环出来
for file in `ls /etc`
或
for file in $(ls /etc)
```

#### 使用变量

> 推荐给所有变量加上花括号

使用一个定义过的变量，只要在变量名前面加美元符号即可

```
your_name="qinjx"
echo $your_name
echo ${your_name}
```

变量名外面的花括号是可选的，加不加都行，加花括号是为了帮助解释器识别变量的边界

```
for skill in Ada Coffe Action Java; do
    echo "I am good at ${skill}Script"
done
```

#### 只读变量

使用 readonly 命令可以将变量定义为只读变量，只读变量的值不能被改变
```
#!/bin/bash
myUrl="http://www.google.com"
readonly myUrl

myUrl="http://www.runoob.com"
```

#### 删除变量

使用 unset 命令可以删除变 -> unset 命令不能删除只读变量

```
unset variable_name
```

#### 变量类型

- 局部变量
  - 局部变量在脚本或命令中定义
  - 仅在当前shell实例中有效
  - 其他shell启动的程序不能访问局部变量
- 环境变量
  - 所有的程序，包括shell启动的程序，都能访问环境变量
  - 有些程序需要环境变量来保证其正常运行
  - 必要的时候shell脚本也可以定义环境变量
- shell变量
  - shell变量是由shell程序设置的特殊变量
  - shell变量中有一部分是环境变量
  - 有一部分是局部变量

---

### Shell 字符串

字符串可以用单引号，也可以用双引号，也可以不用引号

> 单引号

- 单引号字符串的限制
  - 单引号里的任何字符都会原样输出，单引号字符串中的变量是无效的
  - 单引号字串中不能出现单独一个的单引号（对单引号使用转义符后也不行），但可成对出现，作为字符串拼接使用

```
str='this is a string'
```

> 双引号

- 双引号的优点
  - 双引号里可以有变量
  - 双引号里可以出现转义字符

```
your_name='runoob'
str="Hello, I know you are \"$your_name\"! \n"
echo $str
```

#### 字符串操作

```
# 获取字符串长度
string="abcd"
echo ${#string} # 输出 4

# 提取子字符串
string="runoob is a great site"
echo ${string:1:4} # 输出 unoo

# 查找子字符串
string="runoob is a great site"
echo `expr index "$string" io`  # 输出 4
# 以上脚本中 ` 是反引号，而不是单引号 '，不要看错了哦。

```

---

### Shell数组

#### 定义数组

```
数组名=(值1 值2 ... 值n)
```

#### 读取数组

```
${数组名[下标]}
# 使用 @ 符号可以获取数组中的所有元素
```

#### 获取数组的长度

```
# 取得数组元素的个数
length=${#array_name[@]}
# 或者
length=${#array_name[*]}
# 取得数组单个元素的长度
lengthn=${#array_name[n]}
```

---

### Shell注释

#### 单行注释

使用`#`

#### 多行注释

```
:<<EOF
注释内容...
注释内容...
注释内容...
EOF


:<<'
注释内容...
注释内容...
注释内容...
'

:<<!
注释内容...
注释内容...
注释内容...
!

```