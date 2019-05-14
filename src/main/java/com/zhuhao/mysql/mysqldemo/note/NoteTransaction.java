package com.zhuhao.mysql.mysqldemo.note;

/**
 *
 *		事务：
 *			1.概念
 *				事务是为了完成某一项工作或业务的一组步骤的集合。
 *				事务是一个完整的整体，不能拆分开。
 *				事务在数据库中的表现，就是一组sql语句完成某项功能。
 *				现有的实时交易系统必须使用事务处理，否则全部瘫痪。
 *				事务一般分为：单机事务，分布式事务。
 *
 *			2.特性(ACID)
 *				原子性(Atomicity)：事务是一个整体，不能分割。
 *				一致性(Consistency)：事务执行的结果只有两种，全部成功或者全部失败。不存在部分成功或部分失败的情况。
 *				隔离性(Isolation)：各个事务之间相互隔离，互不影响。
 *				持久性(Durability)：事务执行的结果可以永久保存到数据库或文件中。任何时候都可以查询事务执行的结果。
 *
 *			3.使用
 *				1.mysql默认事务是自动提交的
 *				2.可以设置事务提交的模式
 *					SET AUTOCOMMIT = 0;关闭
 *					SET AUTOCOMMIT = 1;开启
 *				3.事务使用方式
 *					开启事务：START TRANSACTION;或者BEGIN;
 *					提交事务：COMMIT;事务成功，事务的处理结果永久保存到数据库
 *					回滚事务：ROLLBACK;事务失败，回滚到事务开始之前的状态，注意自动增长不会回滚。
 *				4.事务只针对数据库中表的变动，不针对查询。
 *			4.隔离级别的安全问题
 *				读问题：脏读、不可重复读、幻读
 *				写问题：丢失更新（悲观锁、乐观锁）
 *			5.隔离级别
 *				Read Uncommitted 读未提交
 *				Read Committed 读已提交
 *				Repeatable Read 重复读
 *				Serializable 可串行化
 *
 * @author junki
 * @date 2019年5月7日
 */
public class NoteTransaction {
}
