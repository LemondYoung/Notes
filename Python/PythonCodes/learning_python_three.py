names = ["monster","lyy","lover"]
for name in names:
	print(name)

sum = 0 
for x in [1,2,3,4,5,6,7,8,9,10]:
  sum=sum+x
print(sum)

list(range(5))
print(list)

#循环是让计算机做重复任务的有效的方法。
#break语句可以在循环过程中直接退出循环，而continue语句可以提前结束本轮循环，并直接开始下一轮循环。这两个语句通常都必须配合if语句使用。
#要特别注意，不要滥用break和continue语句。break和continue会造成代码执行逻辑分叉过多，容易出错。大多数循环并不需要用到break和continue语句，上面的两个例子，都可以通过改写循环条件或者修改循环逻辑，去掉break和continue语句。
#有些时候，如果代码写得有问题，会让程序陷入“死循环”，也就是永远循环下去。这时可以用Ctrl+C退出程序，或者强制结束Python进程。
