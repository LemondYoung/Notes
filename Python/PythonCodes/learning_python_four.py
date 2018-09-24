#dict : 字典
d = {'Michael': 95, 'Bob': 75, 'Tracy': 85} #定义一个字典，字典文件为dict >>简称 d
print(d['Michael'])
print("Bob" in d) #判断key是否存在

s=set([1,2,3])
print(s)

q=set([1,1,1,2,2,2,3,3])
print(q)

a="abc"
print(a.replace("a","A"))
print(a)

c="abc"
b=a.replace("a","A")
print(b)
print(a)

#对于不变对象来说，调用对象自身的任意方法，
#也不会改变该对象自身的内容。
#相反，这些方法会创建新的对象并返回，这样，就保证了不可变对象本身永远是不可变的