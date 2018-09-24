# 函数
print(abs(100))
print(max(1,2,3,4))
a=abs;
print(a(-2))  #这里标识给abs起了个别名
print(help(abs))

#在函数定义的时候，要用“def”定义。依次写出函数名、括号、括号中的参数、和冒号“：”
#然后在缩进块中编写函数体，函数返回用return返回

def my_abs(x):
	if not isinstance(x,(int,float)):
		raise TypeError("bad operand type")
	if x>0:
		return x
	else:
	    return -x

# from 文件名 import 方法名 
# 表示在命令中导入这个方法
# 默认为2,，调用方式：power(2)  power(2,3)
# 默认参数 ：默认参数必须使用不变的对象
def power(x,n=2):
	s=1
	while n>0:
		n=n-1
		s=s*x
	return s