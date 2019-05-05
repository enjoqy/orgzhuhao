package com.zhuhao.mysql.mysqlnote;

/*
 *
 * 	一、数据库
 * 		1.定义：Database简称DB，web项目中的DataSource，数据的仓库，实现数据的持久化和管理。
 * 		2.分类：
 * 			早期分类分为三种层次式数据库、网络式数据库、关系型数据库；
 * 			近期分类分为两种，关系型数据库和非关系型数据库(NOSQL：Not Only SQL);
 * 				1.关系型数据库：用二维表描述复杂的结构化数据
 * 					MySQL，Oracle、SQLServer
 * 				2.非关系型数据库：是传统关系型数据库的补充
 * 					1.键值存储形式：Redis
 * 					2.列存储形式：HBase
 * 					3.文档存储形式：MongoDB
 * 	二、MySQL数据库
 * 		1.服务的启动与关闭
 * 			net start mysql
 * 			net stop mysql
 * 		2.登录数据库
 * 			mysql -hlocalhost -P3306 -uroot -proot
 * 		3.退出数据库
 * 			exit、quit
 * 		4.目录
 * 			数据库的安装目录：C:\Program Files\MySQL\MySQL Server 5.7
 * 			数据库的文件目录：C:\ProgramData\MySQL\MySQL Server 5.7\Data
 * 	三、SQL
 * 		1.定义：Structured Query Language结构化查询语言，定义了一套数据库操作语言规范，
 * 				适用于绝大部分数据库。每种数据库具体操作有所区别，被称为数据库的“方言”。
 * 		2.通用语法：
 * 			1.SQL语句不区分大小写，关键字建议使用大写。
 * 			2.单行多行都可以，每一条语句以分号结尾。
 * 			3.注释：
 * 				1.单行注释：-- 注释内容
 * 				2.多行注释：/ * 注释内容 * /
 * 				3.mysql的单行注释：	# 注释内容
 * 		3.SQL语句分类
 * 			1.DDL：数据定义语言
 * 				操作对象：数据库、表
 * 				关键字：create、alter、drop、show...
 * 			2.DML：数据操作语言
 * 				操作对象：数据、记录、元组
 * 				关键字：insert、update、delete
 * 			3.DQL：数据查询语言
 * 				操作对象：数据、记录、元组
 * 				关键字：select、from、where...
 * 			4.DCL：数据控制语言
 * 				操作对象：数据库、用户
 * 				关键字：grant、remoke...
 * 			5.TCL：事务控制语言
 * 				操作对象：数据库
 * 				关键字：commit、rollback、savepoint
 *
 *
 * 	注：“与数据库无关”、“数据库无关性”
 *
 * @author junki
 * @date 2019年4月29日
 */
public class Note {
}
