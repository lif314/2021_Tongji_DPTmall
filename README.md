# 2021同济软件 设计模式项目

## 1. 项目说明
天猫购物平台





## 2. 项目成员


## 3. 设计模式介绍
- MVC模式



## 4. 项目展示






## 5. Git协作流程

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

   

   
