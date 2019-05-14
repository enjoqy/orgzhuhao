package com.zhuhao.mysql.mysqldemo.note;

/**
 * 	DML数据操作语言
 *		插入：
 *			默认插入全部字段：
 *				insert into 表名 values(字段值1,字段值2...);
 *			插入指定的字段：
 *				insert into 表名(字段名1,字段名2...) values(字段值1,字段值2...);
 *			插入多行数据：
 *				insert into 表名 values(字段值1,字段值2...),(字段值1,字段值2...),(字段值1,字段值2...);
 *
 *			注意：
 *				1.字段值的顺序和选择的字段名的顺序保持一致
 *				2.字段名可以省略，字段值必须和定义的字段顺序保持一致
 *				3.插入字符串一般使用单引号，数字可以省略
 *				4.一般使用values关键字，value其实也可以
 *				5.主键是自动编号，不推荐手动插入
 *				6.插入数据不可违反约束规则
 *		修改：
 *			update 表名 set 字段名1=字段值1,字段名2=字段值2...[where 条件];
 *		删除：
 *			delete from 表名 [where 条件];
 *		注意：
 *			1.通过delete from清空表，自动编号不受影响
 *			2.删除表数据前要备份，删除语句最好加条件
 *			3.清空表推荐truncate，效率高，自动编号会初始化
 *
 * @author junki
 * @date 2019年4月29日
 */
public class NoteDML {
}
