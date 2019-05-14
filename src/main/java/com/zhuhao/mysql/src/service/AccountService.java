package com.zhuhao.mysql.src.service;

import com.zhuhao.mysql.src.Entity.Account;
import com.zhuhao.mysql.src.JDBCUtils.JDBCUtils;
import com.zhuhao.mysql.src.dao.AccountDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * service层，用来写业务逻辑的
 *
 * @author: zhuhao
 * @date: 2019/5/14 0014 9:24
 */
public class AccountService {

    private AccountDao accountDao = new AccountDao();

    public boolean pay(String from, String to, double money) {
        Connection connection = JDBCUtils.getConnect();

        // 关闭事务自动提交（开启事务）
        try {
            connection.setAutoCommit(false);
            Account fromAccount = accountDao.getOneByAccountName("account", from);
            fromAccount.setAccountBalance(fromAccount.getAccountBalance() - money);
            accountDao.update("account", fromAccount);

            Account toAccount = accountDao.getOneByAccountName("account", to);
            toAccount.setAccountBalance(toAccount.getAccountBalance() + money);
            accountDao.update("account", toAccount);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        JDBCUtils.closeAll(null,null, connection);
        return true;
    }

}
