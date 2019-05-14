package com.zhuhao.mysql.src.controller;

import com.zhuhao.mysql.src.service.AccountService;

import java.sql.SQLException;

/**
 *  控制层，用来与前端做交互
 *
 *  @author: zhuhao
 * @date: 2019/5/14 0014 9:18
 */
public class AccountController {

    static AccountService accountService =  new AccountService();

    // 支付的方法
    public static void pay(String from, String to, double money) throws SQLException {

        boolean result = accountService.pay(from, to, money);

        if(result){
            System.out.println("转账成功！");
        }else {
            System.out.println("转账失败！");
        }

    }

    public static void main(String[] args) throws SQLException {
        pay("小明", "红红", 1000);

        pay("小明", "张三", 1000);
    }

}
