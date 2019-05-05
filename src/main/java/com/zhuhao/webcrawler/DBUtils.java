package com.zhuhao.webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * jdbc部分，插入数据
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public final class DBUtils {

    //获取数据库连接
    public static Connection getConnection() {
        Connection con = null;
        Properties properties = new Properties();
        //将资源放在try()，jvm会自动帮我们关闭
        try (InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
            //通过配置文件获取jdbc所需的属性
            properties.load(is);
            String driver = properties.getProperty("jdbc.driver_class");
            String url = properties.getProperty("jdbc.connection.url");
            String user = properties.getProperty("jdbc.connection.username");
            String password = properties.getProperty("jdbc.connection.password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return con;
    }


    /**
     * 通过给定的表名，对表进行删除
     *
     * @author: zhuhao
     * @Date: 2019/3/30 0030 11:12
     */
    public static void deleteTable(String table_name) {
        Connection con = DBUtils.getConnection();
        String sql = "drop table `" + table_name + "` ;";
        String sqlTmp = "select count(*) from `" + table_name + "`;";
        int size = 0;
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sqlTmp);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                size = resultSet.getInt("count(*)");
            }

            if (0 == size) {

                statement = con.prepareStatement(sql);
                statement.execute();
                System.out.println(table_name + "\t删除成功！");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(table_name + "\t删除失败！");
            e.printStackTrace();
        }
    }

    //获取数据库中的表存到list中
    public static List<String> getTableNames() {
        Connection con = null;
        DatabaseMetaData data = null;
        List<String> tableNameList = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            //获取数据库中的表存到list中
            data = con.getMetaData();
            ResultSet tables = data.getTables(null, "mydb", null, null);
            while (tables.next()) {
                tableNameList.add(tables.getString("table_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //调用关闭资源的方法
            closeResource(con, null);
        }
        return tableNameList;
    }

    /**
     * 根据传入的表名生成表
     *
     * @author: zhuhao
     * @Date: 2019/3/30 0030 11:12
     */
    public static void createDB(String cityTableName) {
        Connection con = DBUtils.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "CREATE TABLE IF NOT EXISTS `mydb`.`job_position_" + cityTableName + "`  (" +
                    "  `id` int(11) NOT NULL AUTO_INCREMENT," +
                    "  `job_title` varchar(255) NULL COMMENT '职位'," +
                    "  `company_name` varchar(255) NULL COMMENT '公司名称'," +
                    "  `working_place` varchar(255) NULL COMMENT '工作地点'," +
                    "  `salary` varchar(255) NULL COMMENT '薪资'," +
                    "  `release_time` varchar(255) NULL COMMENT '发布时间'," +
                    "  PRIMARY KEY (`id`)" +
                    ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            System.out.println(sql);
            statement = con.prepareStatement(sql);
            statement.execute();
            System.out.println("生成表成功，表名为 job_position_" + cityTableName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //调用关闭资源的方法
            closeResource(con, statement);
        }

    }

    /**
     * 查询数据库指定表的数据，并返回ResultSet集合
     *
     * @author: zhuhao
     * @Date: 2019/3/30 0030 11:12
     */
    public static ResultSet query(String table_name) {
        Connection con = DBUtils.getConnection();
        ResultSet resultSet = null;
        String sql = "select * from " + table_name;  // + " limit 5";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String job_title = resultSet.getString("job_title");
                String company_name = resultSet.getString("company_name");
                String working_place = resultSet.getString("working_place");
                String salary = resultSet.getString("salary");
                String release_time = resultSet.getString("release_time");
                System.out.println("id\t" + id + "\tjob_title\t" + job_title + "\tcompany_name\t" + company_name + "\tworking_place\t" + working_place +
                        "\tsalary\t" + salary + "\trelease_time\t" + release_time);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //插入数据
    public static int insert(String url, String table_name, int size) {
        Connection con = DBUtils.getConnection();
        List<User> userList = GetHtmlDataUtils.getData(url);
        PreparedStatement statement = null;
        int sum = 0;
        try {
            String sql = "insert into `" + table_name + "` (job_title,company_name,working_place, salary,release_time) values (?,?,?,?,?);";
            for (int i = 0; i < userList.size(); i++) {
                statement = con.prepareStatement(sql);
                User user = userList.get(i);
                statement.setString(1, user.getJobTitle());
                statement.setString(2, user.getCompanyName());
                statement.setString(3, user.getWorkingPlace());
                statement.setString(4, user.getSalary());
                statement.setString(5, user.getReleaseTime());
                statement.execute();
                sum++;
                size++;
                System.out.print("插入第\t" + sum + "\t条数据成功！\t");
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //调用关闭资源的方法
            closeResource(con, statement);
            System.out.println("插入数据到mysql数据库完成！此页共计：\t" + sum + "\t条数据");
        }
        return size;
    }

    /**
     * 通过传入一个表名的list集合，进行比较，两张表的内容是否相同，相同的就删除第二张表
     * <p>
     * 此方法未完善,有bug
     *
     * @author: zhuhao
     * @Date: 2019/3/30 0030 11:12
     */
    @Deprecated
    public static void compareTableDelete(List<String> tableNameList) {
        for (int i = 0; i < tableNameList.size() - 1; i++) {
            String tableNameTmp01 = tableNameList.get(1);
            String tableNameTmp02 = tableNameList.get(i + 1);
            ResultSet resultSetTmp01 = DBUtils.query(tableNameTmp01);
            ResultSet resultSetTmp02 = DBUtils.query(tableNameTmp02);
            try {
                if (resultSetTmp01.next() && resultSetTmp02.next()) {

                    if (resultSetTmp01.getString("job_title") == null) {
                        deleteTable(tableNameTmp02);
                        i++;
                    }
                    //如果job_title，company_name，working_place，release_time是相同的，则认定两张表是相同的，删除第二张表
                    else if (resultSetTmp01.getString("job_title").equals(resultSetTmp02.getString("job_title"))
                            && resultSetTmp01.getString("company_name").equals(resultSetTmp02.getString("company_name"))
                            && resultSetTmp01.getString("working_place").equals(resultSetTmp02.getString("working_place"))
                            && resultSetTmp01.getString("release_time").equals(resultSetTmp02.getString("release_time"))) {
                        deleteTable(tableNameTmp02);
                        i++;

                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    //关闭资源的方法
    private static void closeResource(Connection con, PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
