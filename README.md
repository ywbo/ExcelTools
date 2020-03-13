# ExcelTools简介

Excel导入导出工具。基于Springboot开发，集成了Easypoi。实现了从数据库（Oracel，MySQL，SQL Server等）读取数据，导出成单sheet和多sheet，以及固定Excel模板导出的便捷工具。拿来即用！

### 欢迎star fork watch

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

## 3、mvc三层架构，下载项目即可看到。结构如下图所示。

![1584067140276](C:\Users\yuwen\AppData\Roaming\Typora\typora-user-images\1584067140276.png)

## 4、目前开发情况说明

	### (1) 只是单/多 sheet导出Excel。

### (2) 导入和导出基本差不多。后期抽时间把导出做完。

### (3) 目前有这样的需求，计划做一个查询界面，按照一定的条件查询到结果，导出到Excel模板中。正在开发中...



---

## 5、还在不断完善中，共同进步！有好的意见或者建议欢迎issue...








