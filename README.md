# ExcelTools简介

Excel导入导出工具。基于Springboot开发，集成了Easypoi。实现了从数据库（Oracel，MySQL，SQL Server等）读取数据，导出成单sheet和多sheet的便捷工具。拿来即用！

参见开发文档：<https://opensource.afterturn.cn/doc/easypoi.html#12>



## 1、创建SpringBoot项目引入Easypoi启动器（依赖）

~~~ java
<!--EasyPoi导入导出-->
<dependency>
	<groupId>cn.afterturn</groupId>
	<artifactId>easypoi-spring-boot-starter</artifactId>
	<version>4.0.0</version>
</dependency>
~~~

## 2、MySQL执行test.sql导入测试数据

## 3、正常书写mvc三层架构，项目结构如下图所示。








