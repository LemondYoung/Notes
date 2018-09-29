> Shell 也可以包含外部脚本

```
. fileName #注意点和文件名之间有空格

# 或

source fileName
```

> test1.sh

```
#!/bin/bash

word = "Hello"
```

> test2.sh

```
#!/bin/bash

#使用.号来引入test1.sh文件
../test1.sh

#或者使用source
# source ./test1.sh

echo "$word"
```

