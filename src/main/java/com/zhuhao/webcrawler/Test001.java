package com.zhuhao.webcrawler;

import java.util.Scanner;

/**
 * 根据传入的城市名，自动生成一个表
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class Test001 {
    static int size = 0;

    public static void main(String[] args) {
        String cityName = "";
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("目前只支持“前程无忧”网站的爬取\n\n请输入需要爬取的网址：");
            String urlTmp = input.next();
            System.out.println("已获取网址，请等待。。。");

            cityName = GetHtmlDataUtils.getTitle(urlTmp);
            DBUtils.createDB(cityName);

            for (int i = 1; i <= 31; i++) {

//                String url = "https://search.51job.com/list/150200,000000,2539%252C0107,15%252C01,9,99,java,2," + i + ".html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
                String url = urlTmp.substring(0, 82) + i + urlTmp.substring(83, urlTmp.length());
                System.out.println(url);
                size = DBUtils.insert(url, "job_position_" + cityName, size);

                System.out.println("第\t" + i + "\t页爬取完成。。。");
            }
        } catch (Exception e) {
            System.out.println("有异常跳过，，" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("共计爬取：\t" + size + "\t条数据");
    }






        /*List<String> tableNames = DBUtils.getTableNames();
        for (int i = 0; i < tableNames.size(); i++) {
            DBUtils.deleteTable(tableNames.get(i));
        }*/

}











/* *//**
 * 通过给定的表名，对表进行删除
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 * <p>
 * 通过传入一个表名的list集合，进行比较，两张表的内容是否相同，相同的就删除第二张表
 * <p>
 * 此方法未完善,有bug
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 * <p>
 * 查询数据库指定表的数据，并返回ResultSet集合
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 * <p>
 * 通过传入一个表名的list集合，进行比较，两张表的内容是否相同，相同的就删除第二张表
 * <p>
 * 此方法未完善,有bug
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 * <p>
 * 查询数据库指定表的数据，并返回ResultSet集合
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 *//*
    public static void deleteTable(String table_name) {
        Connection con = DBUtils.getConnection();
        String sql = "drop table if  exists  `" + table_name + "` ;";
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
            }
            con.close();
            System.out.println(table_name + "\t删除成功！");
        } catch (SQLException e) {
            System.out.println(table_name + "\t删除失败！");
            e.printStackTrace();
        }
    }*/

/**
 * 通过传入一个表名的list集合，进行比较，两张表的内容是否相同，相同的就删除第二张表
 *
 * 此方法未完善,有bug
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
   /* @Deprecated
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
    }*/


/**
 * 查询数据库指定表的数据，并返回ResultSet集合
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
   /* public static ResultSet query(String table_name) {
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
//                System.out.println("id\t" + id + "\tjob_title\t" + job_title + "\tcompany_name\t" + company_name + "\tworking_place\t" + working_place +
//                        "\tsalary\t" + salary + "\trelease_time\t" + release_time);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }*/

   /* //获取数据库中的表存到list中
    public static List<String> getTableNames() {
        Connection con = null;
        DatabaseMetaData data = null;
        List<String> tableList = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            //获取数据库中的表存到list中
            data = con.getMetaData();
            ResultSet tables = data.getTables(null, "mydb", null, null);
            while (tables.next()) {
                tableList.add(tables.getString("table_name"));
                System.out.println(tables.getString("table_name"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }*/
   /* public static void createDB(String cityTableName) {
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
            statement =  con.prepareStatement(sql);
            statement.execute();
            statement.close();

            System.out.println("生成表成功，表名为 job_position_" + cityTableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       createDB("shanghai");

    }*/




/*
*  String sql = "CREATE TABLE `mydb`.`Untitled`  (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `job_title` varchar(255) NULL COMMENT '职位',\n" +
                "  `company_name` varchar(255) NULL COMMENT '公司名称',\n" +
                "  `working_place` varchar(255) NULL COMMENT '工作地点',\n" +
                "  `salary` varchar(255) NULL COMMENT '薪资',\n" +
                "  `release_time` varchar(255) NULL COMMENT '发布时间',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ");";
* */