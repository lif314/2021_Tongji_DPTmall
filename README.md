# Tongji SSE Design Pattern Project -- TMall

## Git协作流程

### 如何将本仓库拉到本地

执行 `git --version` 检查是否安装 git

`git config --global user.name "your name"`

`git config --global user.email "your github email"`

`git clone` 本仓库

### 新功能代码编写

`git branch {your branch name}`

`git checkout {your branch name}`

开始写代码、测试

### 代码合并到本地主分支

`git checkout main`

`git merge {your branch name}`

### 将未写完的代码暂存到远程分支

`git checkout {your branch name}`

`git add .` 或 `git add {file name 1} {file name 2} {file name n}`

`git commit -m "note on your code"`

`git push origin {your branch name}`

此时会在远程仓库新建一个分支，名称为{your branch name}

### 删除远程分支

`git push origin --delete {your branch name}`

**删除前请确保该分支功能已经开发完毕且同步到主分支**

### 继续未完成代码的编写

`git checkout main`

`git pull`

`git checkout {your branch name}`

`git merge main`

继续写代码

### 代码合并到远程主分支

`git checkout main`

`git merge {your branch name}`

`git add .`

`git commit -m "note on your code"`

`git push`

## Git协作规范

1. main分支只能进行push、pull和merge操作；

2. 为了避免误操作别人的分支，在新建自己的分支时，请加上自己名字首字母的前缀，例如 gtc.branch1；

3. 在写代码之前请确认自己所在的分支，可以通过 `git branch -l` 查看，或者 `git checkout {your branch name}` 直接切换到自己的分支；

4. 写代码之前请保持自己的分支与最新版本一致，操作参考“Git协作流程-继续未完成代码的编写”；

5. 请勿修改别人的代码，如需修改，请提交Issues或QQ私聊或线下交流；

6. commit message 规范，格式：<type>: <subject>

   1. feat：新功能
   2. fix：修bug
   3. style：代码格式变动
   4. refactor：重构（不是新功能，也不是修bug）
   5. merge：合并时使用

   例如：feat: 买家购买商品

   例如：refactor: 优化搜索性能

   我们应该只会用到这四个，subject中英文皆可，建议每次commit只涉及一个点的变动。

   

   
