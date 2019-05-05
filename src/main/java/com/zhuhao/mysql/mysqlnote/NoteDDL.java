package com.zhuhao.mysql.mysqlnote;
/**
 * 	DDL数据库定义语言
 * 		操作数据库：
 *			创建：create database 数据库名称;
 *			删除：drop database 数据库名称;
 *			查看所有的数据库：show databases;
 *			切换或进入数据库：use 数据库名称;
 *
 *		操作表：
 *			创建表：create table 表名(字段描述, 字段描述, ...);
 *				字段描述：字段名称 字段类型 [约束]
 *			查询创建表：利用现有表中查询的数据创建一个新的表
 *				create table 新表 as select 字段1,字段2,字段3 from 原表;
 *
 *		修改表：alter table 表名...
 *			修改表名：alter table 旧表名 rename 新表名; rename table 原表名 to 新表名
 *			添加字段：alter table 表名 add [column] 字段描述 [after 字段名];
 *			修改字段名：alter table 表名 change 原字段名 新字段名 字段描述;
 *			修改字段描述：alter table 表名 modify 字段名称 字段类型 [约束];
 *			删除字段：alter table 表名 drop 字段名称
 *
 *			注意：
 *				1.若表中有数据，可能无法更改表数据结构
 *				2.使用change修改字段会覆盖所有字段描述
 *
 *		删除表：
 *			drop table 表名;
 *
 *		其他常用命令：
 *			查看表结构：desc 表名;
 *			查看建表语句：show create table 表名;
 *
 *	数据类型：
 *		数据类型：
 *		java				mysql				备注
 *
 *		byte				tinyint
 *		short				smallint
 *		int					int
 *		long				bigint
 *		char/String			varchar/char		varchar可变长度，mysql的方言；char固定长度
 *		boolean				tinyint/int			没有此类型，使用int类型代替
 *		float/double		float/double		注意：double(5,2)代表长度为5，小数位占2位，999.99
 *							decimal(10,2)		表示数字总长度10，小数位2位
 *		java.sql.Date		date				日期
 *		java.sql.Time		time				时间
 *		java.sql.Timestamp	timestamp			时间戳 若给定值为null，会把当前系统时间存入数据库
 *							datetime			日期+时间
 *		java.sql.Clob		text				长文本
 *		java.sql.Blob		blob				二进制
 *
 *	约束：
 *		作用：为了保证数据的有效性和完整性
 *		常用的约束：
 *			默认约束	default
 *
 *			唯一约束	unique
 *				注意：对null值不起作用，可以有多个null值；但是空字符串只能有一个。
 *
 *			非空约束	not null
 *
 *			主键约束	primary key(实体完整性)
 *				注意：唯一非空，一张表只能有一个主键，这个主键可以包含多个字段(联合主键)，一般使用与业务逻辑无关的字段
 *				方式1：建表的同时添加约束 格式：字段名称 字段类型 primary key
 *				方式2：建表的同时在约束区域(所有字段之后)添加约束 格式：primary key(字段1，字段2)
 *				方式3：建表之后，通过修改表结构添加约束 格式：alter table 表名 add [constraint] primary key(字段1,字段2...)
 *
 *			外键约束	foreign key(引用完整性)
 *				foreign key(外键列) references 主表(主键);
 *				alter table 多表名称 add [constraint] foreign key(外键名称) references 一表名称(主键);
 *				注意：
 *					添加外键约束后，主表中不能删除从表中已引用的数据
 *					从表中不能引用主表中不存在的数据
 *					外键类型一般与主键类型保持一致
 *
 *			自动编号	auto_increment
 *				要求：
 *					1.被修饰的字段类型支持自增，一般是int
 *					2.被修饰的字段必须是一个key，一般是primary key
 *
 *			检查约束	check(mysql不支持)
 *				age int check(age>18 and age<60)
 *
 * @author junki
 * @date 2019年4月29日
 */
public class NoteDDL {
}
