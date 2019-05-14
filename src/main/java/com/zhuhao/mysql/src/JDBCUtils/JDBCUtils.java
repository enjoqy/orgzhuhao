package com.zhuhao.mysql.src.JDBCUtils;

import com.zhuhao.mysql.src.Entity.Account;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 工具类
 *
 * @author: zhuhao
 * @date: 2019/5/13 0013 10:51
 */
public final class JDBCUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 将连接绑定到线程
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private JDBCUtils() {
    }

    static {
        //  第一种加载配置文件的方法
//        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbctest.properties");
//        Properties properties = new Properties();
//            properties.load(resourceAsStream);
//            driver = properties.getProperty("jdbc.driver_class");
//            url = properties.getProperty("jdbc.connection.url");
//            username = properties.getProperty("jdbc.connection.username");
//            password = properties.getProperty("jdbc.connection.password");

        // 第二种加载配置文件的方法，只能加载后缀名为properties的文件，传参时后缀名不用写
        ResourceBundle resource = ResourceBundle.getBundle("jdbctest");
        driver = resource.getString("jdbc.driver_class");
        url = resource.getString("jdbc.connection.url");
        username = resource.getString("jdbc.connection.username");
        password = resource.getString("jdbc.connection.password");

        // 注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 返回一个数据库连接
    public static Connection getConnect() {
        Connection connection = threadLocal.get();

//        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // 绑定线程
            threadLocal.set(connection);
//        }
        return connection;
    }

    // 关闭资源
    public static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
