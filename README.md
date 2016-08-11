# iyoga

项目概述：基于面向对象的思想，完成创建会员及开办不同种类会员卡的业务，提供了基础的GUI，以及简单的数据库插入, 检错功能。

- lib目录下存放项目的一些依赖包
- config.properties包含数据库连接时的配置参数
- log4j.properties包含对日志方法的一些配置
- sql目录下 
	- firTaskMysql.sql是任务1的数据库建表语句
	- secTaskMysql.sql是任务2的数据库建表语句
- src目录下
	- log中存放日志文件
	- /com/asiainfo/iyoga
		- bean: 模型层
		- common: 存放一些公共方法
		- control: 控制层
		- dao: 数据操作层
		- service: 业务逻辑的接口
		- serviceImpl: 业务逻辑的实现
		- test: 单元测试模块
