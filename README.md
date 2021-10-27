# DPTmall
Design Pattern Tmall Implement

- a simple demo to review design patterns 
- a little XML database
- java + generic + reflection

## XML Little Database
- Proxy Pattern
- Composite Entity Pattern
- Data Access Object Pattern 


## 使用IDEA + Maven
- IDEA git使用 https://www.cnblogs.com/jajian/p/8471989.html
- 拉取项目：
`File` ---> `New`  ----> `Project from Version Control` ---> `URL`
有可能由于网络原因加载失败，多试几次就可以了
- 2021版的IDEA自带maven，刚开始会通过pom.xml文件加载依赖，不用管。
- 我使用的是java 11，自行改为你需要的版本，很简单
- 在resources目录下，将Xml.propertites文件中的Xmldb目录改为你系统上的目录，使用绝对路径会好点，不能存在中文路径(配置文件中不支持中文)

