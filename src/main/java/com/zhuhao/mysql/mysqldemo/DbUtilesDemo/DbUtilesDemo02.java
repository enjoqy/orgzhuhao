package com.zhuhao.mysql.mysqldemo.DbUtilesDemo;

import com.zhuhao.mysql.mysqldemo.JDBCUtils.JDBCUtils;
import com.zhuhao.mysql.src.Entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 *  @author: zhuhao
 * @date: 2019/5/14 0014 17:27
 */
public class DbUtilesDemo02 {
    Connection connection;

    public  List<Account> getList() throws SQLException {
        connection = JDBCUtils.getConnect();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from account";
        List<Account> accountList = queryRunner.query(connection, sql, new BeanListHandler<>(Account.class));
        return accountList;
    }

    public Account getById() throws SQLException {
        connection = JDBCUtils.getConnect();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from account where id = ?";
        Account account =  queryRunner.query(connection, sql, new BeanHandler<>(Account.class), new Object[]{2});
        return account;
    }

    public static void main(String[] args) throws SQLException {
//        System.out.println(new DbUtilesDemo02().getList());
        System.out.println(new DbUtilesDemo02().getById());
    }

}
