package com.zhuhao.mysql.mysqlnote.jdbctest;

import com.zhuhao.mysql.mysqlnote.Entity.ChinaJob;
import com.zhuhao.mysql.mysqlnote.JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  主程序类中的的静态变量先于静态代码块初始化，其后进入主函数类(程序入口处)，
 *  其后根据静态函数的调用情况，才能选择性的初始化。
 *
 *  @author: zhuhao
 * @date: 2019/5/13 0013 9:12
 */
public class DemoJDBC02 {
    // 获取数据库连接
    static Connection connection = JDBCUtils.getConnect();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        select();
    }

    public static void test() throws SQLException {
        // 3.编写sql语句
        String sql = "desc china_job";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

    }

    public static void select() throws ClassNotFoundException, SQLException{

//        3.编写sql语句
        String sql = "select * from china_job";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ChinaJob chinaJob = ChinaJob.builder().id(resultSet.getLong("id"))
                    .province(resultSet.getString("province"))
                    .jobTitle(resultSet.getString("job_title"))
                    .companyName(resultSet.getString("company_name"))
                    .workingPlace(resultSet.getString("working_place"))
                    .salary(resultSet.getString("salary"))
                    .build();
            System.out.println(chinaJob);
        }

        // 7、释放资源
        JDBCUtils.closeAll(resultSet, preparedStatement, connection);
    }
}
