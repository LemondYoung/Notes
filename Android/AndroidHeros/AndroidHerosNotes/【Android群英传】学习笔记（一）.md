【Android群英传】学习笔记（一）
---

> 本系列博客为笔者在学习《Android群英传》的学习总结

---

> Android相关工具镜像连接：`http://www.androiddevtools.cn/`

---

## Dalvik与ART

> Dalvik包含了一整套的Android运行环境虚拟机，每个App都会分配Dalvik虚拟机来保证互相之间不受干扰，并保持独立运行。它的特点是在运行时编译。打个比方，就好比你买一辆可折叠的自行车，平时总是折叠的，只有骑得时候，才需要组装起来用。

> 在Android 5.X 版本开始，ART模式已经取代了Dalvik，ART采用安装时就进行编译，这就好比你买了辆组装好的自行车，装好就可以骑了。

> 当然，对在虚拟机环境中运行大部分App来说，他们都运行着同样的代码

> `上述内容来自《Android 群英传》 徐宜生-编著 `


---

## ADB

> ADB: Android Debug Bridge : Android调试桥，担当手机与电脑的“脐带”

### ADB常用命令

- 显示系统中全部的Android平台：android list targets

- 安装Apk程序之Install：adb install -r 应用程序.apk

- 安装Apk程序之Push：adb push `<local>` `<remote>`

- 向手机写入文件：adb push `<local>` `<remote>`

- 从手机获取文件：adb pull `<local>` `<remote>`

- 查看Log：adb shell

- 查看系统盘符：adb shell df

- 输出所有已安装的应用：adb shell pm list packages -f

- 模拟按键输入：adb shell input keyevent x (x:是执行Keyevent的Code ，可在网上查到对应的Code)

- 模拟滑动输入：adb shell input touchscreen `<x1>` `<y1>` `<x2>` `<y2>`

- 启动一个Activity：adb shell am start -n ` 包名 + 类名 `

- 录制屏幕：adb shell screenrecord `<local>`

- 重新启动：adb reboot

