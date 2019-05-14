package com.zhuhao.mysql.mysqldemo.note;

/**
 * 	DQL：数据查询语言
 *		操作对象：记录
 *		关键词：select
 *		查询：
 *			select ... from 表名 where 条件 group by 分组字段 having 条件 order by 排序字段 asc|desc;
 *		排序：
 *			asc：升序(ascending) desc：降序
 *		聚合函数：
 *			对一列进行计算，返回值是一个值，忽略null值
 *			sum(),avg(),max(),min(),count();
 *			保留小数位：round(值,保留小数位)  例如：round(avg(price),2)
 *			表的记录条数：select count(*) from 表名;
 *		分组：
 *			group by
 *			一般和聚合函数联用，例如：select count(*) from 表名 group by 字段名;
 *		注意：
 *			where 和 having 区别：
 *				where 是对分组前的数据进行过滤
 *				having 是对分组后的数据进行过滤
 *				where 后面不能使用聚合函数 having可以
 *				having部分情况可以替代where，但是不推荐
 *
 * 	系统函数：
 *		1.日期相关函数
 *			NOW(),SYSDATE(),CURDATE(),CURTIME();
 *		2.聚合函数
 *			COUNT(expr)：统计个数
 *			AVG([DISTINCT] expr)：取平均值
 *			MAX(expr)/MIN(expr)/SUM(expr)
 *		3.字符串相关函数
 *			LENGTH(str)：获取长度
 *			CONCAT(str1,str2,...)：字符串连接
 *			SUBSTRING(str FROM pos FOR len)：下标从1开始
 *			SUBSTR(str FROM pos FOR len)：同上
 *			REPLACE(str,from_str,to_str)：字符串替换
 *			REVERSE(str)：字符串倒序
 *			LOWER(str)：
 *			UPPER(str)：
 *
 *	top ten问题：
 *		top ten：先排序，再获取限定数据
 *		mysql：ORDER BY , LIMIT m,n
 *		sqlserver：top m, ORDER BY
 *		oracle：ORDER BY, rownum
 *
 *	truncate 清空表
 *		格式：truncate 表名;
 *		清空表，重新创建一张空表
 *		truncate和delete from区别：
 *			delete属于DML语句，truncate属于DDL语句
 *			delete逐条删除，truncate直接清空表
 *
 *  dual是一种虚表，没有任何意义，使得我们的sql语句编写完整，从oracle移植
 *
 * @author junki
 * @date 2019年4月29日
 */
public class NoteDQL {
}
