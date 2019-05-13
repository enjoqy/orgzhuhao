package com.zhuhao.mysql.mysqlnote.jdbctest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo01 {

    public static void main(String[] args) {
        InputStream resourceAsStream = Demo01.class.getClassLoader().getResourceAsStream("jdbctest.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = properties.getProperty("jdbc.driver_class");
        String url = properties.getProperty("jdbc.connection.");
        String username = properties.getProperty("jdbc.connection.username");
        String password = properties.getProperty("jdbc.connection.password");
    }
}
