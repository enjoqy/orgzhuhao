package com.zhuhao.mysql.mysqlnote.JDBCUtils;

import com.zhuhao.mysql.mysqlnote.jdbctest.Demo01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类
 *
 *  @author: zhuhao
 * @date: 2019/5/13 0013 10:51
 */
public final class JDBCUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn = null;

    private JDBCUtils() {
    }

    static {
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbctest.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);

            driver = properties.getProperty("jdbc.driver_class");
            url = properties.getProperty("jdbc.connection.url");
            username = properties.getProperty("jdbc.connection.username");
            password = properties.getProperty("jdbc.connection.password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 返回一个数据库连接
    public static Connection getConnect(){
        return conn;
    }

    // 关闭资源
    public static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
