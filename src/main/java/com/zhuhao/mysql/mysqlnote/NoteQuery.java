package com.zhuhao.mysql.mysqlnote;

/**
 *	多表操作
 *
 *		一、创建多表，可以描述出表与表之间的关系
 *
 *			常见关系：
 *				一对一：一夫一妻
 *				一对多：用户和订单，分类和商品
 *				多对多：订单和商品，老师和学生
 *			E-R图可以描述实体与实体之间的关
 *				矩形表示实体
 *				椭圆表示属性
 *				菱形表示关系
 *
 *			一对多：
 *				在开发中，我们将一方称之为主表或一表，多方称之为从表或多表，
 *				为了表示一对多个关系，一般会在从表添加一个字段，字段名称自定义(建议:主表名称_id)
 *				为保证数据的有效性和一致性，在多表添加外键约束
 *			多对多：
 *				在开发中，我们一般引入一张中间表，在中间表中存放两张表的主键，
 *				一般还会把这两个主键设置成中间表的联合主键，将多对多转换成两个一对多
 *				为保证数据的有效性和一致性，在中间表添加两个外键约束
 *
 *		二、多表查询
 *
 *			1.内连接([inner] join)：查询两个表公共的部分
 *				SELECT * FROM 表1 t1,表2 t2 WHERE t1.主键 = t2.外键 AND [条件];
 *				SELECT * FROM 表1 t1 [INNER] JOIN 表2 t2 ON t1.主键 = t2.外键 AND [条件];
 *			2.外连接
 *				1.左外连接(left [outer] join)：以左表为主，右表为从，右表中没有对应数据为null
 *					SELECT * FROM 主表 t1 LEFT [OUTER] JOIN 从表 t2 ON t1.主键 = t2.外键 AND [条件];
 *				2.右外连接(right [outer] join)：以右表为主，左表为从，左表中没有对应数据为null
 *					SELECT * FROM 从表 t1 RIGHT [OUTER] JOIN 主表 t2 ON t1.主键 = t2.外键 AND [条件];
 *				3.全连接(full join)：没有主次关系，显示所有内容，mysql不支持
 *					SELECT * FROM 表1 t1 FULL JOIN 表2 t2 ON t1.主键 = t2.外键 AND [条件];
 *				4.交叉表连接(cross join)：笛卡儿积，两表数据的乘法
 *					SELECT * FROM 表1 CROSS JOIN 表2;
 *				5.关联连接(union)：多个查询结果的关联，对查询结果进行堆积，列数要相同，数据类型可以转换
 *					SELECT 列1,列2 FROM 表1 UNION SELECT 列1,列2 FROM 表2;
 *
 *		三、子查询：
 *			1.概念：
 *				sql语句中嵌套sql语句，不仅仅是查询。可以出现在sql语句的任何地方。
 *				可以操作的sql语句有：insert update delete select
 *				子查询可以用在单表操作，也可以用在多表操作中。
 *			2.形式
 *				1.select后面：一行一列
 *					SELECT (SELECT COUNT(*) FROM employee) count1,(SELECT COUNT(*) FROM salary) count2;
 *				2.from后面：多行多列，必须要有别名，是一个虚表/临时表，作为后续的过滤条件。
 *					SELECT * FROM (SELECT id,name,sex,age FROM employee) t1;
 *				3.where后面：只能有一个结果，除非是哟个any和all
 *					SELECT * FROM employee WHERE id >= (SELECT id FROM employee WHERE age = 38);
 *				4.in后面
 *					SELECT * FROM employee WHERE id in(SELECT DISTINCT eid FROM salary);
 *				5.exists后面：只要子查询有一条以上的记录(与内容无关)，就会执行父查询
 *					SELECT * FROM employee t1 WHERE EXISTS(SELECT DISTINCT eid FROM salary t2 WHERE t1.id = t2.eid);
 *				6.insert值里面
 *				7.update set/where后面
 *				8.delete from/where后面
 *					特别注意，update/delete和子查询不能是同一张表，需要将子查询结果创建为临时表，再嵌套查询。
 *
 * @author junki
 * @date 2019年5月5日
 */
public class NoteQuery {
}
