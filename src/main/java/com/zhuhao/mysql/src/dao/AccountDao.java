package com.zhuhao.mysql.src.dao;

import com.zhuhao.mysql.src.Entity.Account;
import com.zhuhao.mysql.src.JDBCUtils.JDBCUtils;
import com.zhuhao.mysql.src.service.AccountService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao持久化层，与数据库做交互
 *
 * @author: zhuhao
 * @date: 2019/5/14 0014 9:26
 */
public class AccountDao {

    Connection connection;

    // 查询一张表，将查询的内容放到一个list集合中
    public List<Account> getList(String tableName) throws SQLException {
        connection = JDBCUtils.getConnect();

        String sql = "select * from " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Account> accountList = new ArrayList<>();
        while (resultSet.next()) {
            Account account = Account.builder().id(resultSet.getLong("id"))
                    .AccountName(resultSet.getString("account_name"))
                    .AccountBalance(resultSet.getDouble("account_balance"))
                    .build();
            accountList.add(account);
        }
        JDBCUtils.closeAll(resultSet, preparedStatement, null);
        return accountList;
    }

    // 根据id查询一张表中的一条记录
    public Account getOneById(String tableName, long id) throws SQLException {
        connection = JDBCUtils.getConnect();

        String sql = "select * from " + tableName + " where id = " + id + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = new Account();
        while (resultSet.next()) {
            account = Account.builder().id(resultSet.getLong("id"))
                    .AccountName(resultSet.getString("account_name"))
                    .AccountBalance(resultSet.getDouble("account_balance"))
                    .build();
        }
        JDBCUtils.closeAll(resultSet, preparedStatement, null);
        return account;
    }

    // 根据字段的名字，查询一条记录
    public Account getOneByAccountName(String tableName, String accountName) throws SQLException {
        connection = JDBCUtils.getConnect();

        String sql = "select * from " + tableName + " where account_name = \"" + accountName + "\"";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = new Account();
        while (resultSet.next()) {
            account = Account.builder().id(resultSet.getLong("id"))
                    .AccountName(resultSet.getString("account_name"))
                    .AccountId(resultSet.getString("account_id"))
                    .AccountBalance(resultSet.getDouble("account_balance"))
                    .build();
        }
        JDBCUtils.closeAll(resultSet, preparedStatement, null);
        return account;
    }

    // 插入一条数据
    public int create(String tableName, Account account) throws SQLException {
        connection = JDBCUtils.getConnect();

        String sql = "insert into " + tableName + "(account_name, account_id, account_balance) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, account.getAccountName());
        preparedStatement.setString(2, account.getAccountId());
        preparedStatement.setDouble(3, account.getAccountBalance());
        int result = preparedStatement.executeUpdate();
        JDBCUtils.closeAll(null, preparedStatement, null);

        return result;
    }

    // 更新一条数据
    public int update(String tableName, Account account) throws SQLException {
        connection = JDBCUtils.getConnect();

        String sql = "update " + tableName + " set account_name = ?, account_id = ? , account_balance = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, account.getAccountName());
        preparedStatement.setString(2, account.getAccountId());
        preparedStatement.setDouble(3, account.getAccountBalance());
        preparedStatement.setLong(4, account.getId());
        int result = preparedStatement.executeUpdate();
        JDBCUtils.closeAll(null, preparedStatement, null);

        return result;
    }

    // 根据传入的id删除一条数据
    public int delete(String tableName, Long id) throws SQLException {
        connection = JDBCUtils.getConnect();

        String sql = "delete from  " + tableName + " where id = " + id;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int result = preparedStatement.executeUpdate();
        JDBCUtils.closeAll(null, preparedStatement, null);

        return result;
    }

/*    public static void main(String[] args) throws SQLException {
        Account account = new Account();
//        account.setId(3L);
        account.setAccountName("张三");
        account.setAccountId("8888");
        account.setAccountBalance("10000");
//        System.out.println(new AccountDao().getList("account"));
//        System.out.println(new AccountDao().getOneById("account", 1));
//        System.out.println(new AccountDao().create("account", account));
//        System.out.println(new AccountDao().update("account", account));
        System.out.println(new AccountDao().delete("account", 4L));
    }*/

}
