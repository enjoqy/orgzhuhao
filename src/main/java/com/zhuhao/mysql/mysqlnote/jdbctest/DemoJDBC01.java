package com.zhuhao.mysql.mysqlnote.jdbctest;

import com.mysql.jdbc.Driver;
import com.zhuhao.mysql.mysqlnote.Entity.ChinaJob;
import com.zhuhao.mysql.mysqlnote.JDBCUtils.JDBCUtils;
import lombok.Data;

import java.sql.*;

/**
 * @author: zhuhao
 * @date: 2019/5/13 0013 9:12
 */
public class DemoJDBC01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        final String URL = "jdbc:mysql://localhost:3306/mypython?useSSL=false";
        final String USER = "root";
        final String PASSWD = "1234";
        Connection conn = DriverManager.getConnection(URL, USER, PASSWD);


//        3.编写sql语句
        String sql = "select * from china_job";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ChinaJob chinaJob = ChinaJob.builder().id(rs.getLong("id"))
                    .province(rs.getString("province"))
                    .jobTitle(rs.getString("job_title"))
                    .companyName(rs.getString("company_name"))
                    .workingPlace(rs.getString("working_place"))
                    .salary(rs.getString("salary"))
                    .build();
            System.out.println(chinaJob);
        }

        // 7、释放资源
        rs.close();
        ps.close();
        conn.close();


    }
}
