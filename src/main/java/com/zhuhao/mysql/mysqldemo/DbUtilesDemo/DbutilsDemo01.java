package com.zhuhao.mysql.mysqldemo.DbUtilesDemo;

import com.zhuhao.mysql.src.JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: zhuhao
 * @date: 2019/5/14 0014 11:10
 */
public class DbutilsDemo01 {

    static Connection connection;

    // 使用Dbutiles创建一个插入方法
    public static int insert() throws SQLException {
        connection = JDBCUtils.getConnect();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into account(account_name, account_id, account_balance) values (?, ?, ?)";
        int result = queryRunner.update(connection, sql, new Object[]{"兰兰", "1111", "10000"});
        return result;
    }

    // 使用Dbutiles创建一个更新的方法
    public static int update() throws SQLException {
        connection = JDBCUtils.getConnect();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update account set account_name = ?, account_id = ?, account_balance = ? where id = ?";
        int result = queryRunner.update(connection, sql, new Object[]{"王五", "1212", 10000, 1});
        return result;
    }

    // 使用Dbutiles创建一个删除的方法
    public static int delete() throws SQLException {
        connection = JDBCUtils.getConnect();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from account where id = ?";
        int result = queryRunner.update(connection, sql, new Object[]{6});
        return result;
    }

    public static void main(String[] args) throws SQLException {
//        insert();
//        update();
        delete();
    }
}
