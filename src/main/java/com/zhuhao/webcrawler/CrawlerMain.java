package com.zhuhao.webcrawler;

public class CrawlerMain {

    static int size = 0;
//    static String table_name = "job_position_nanjing";

    public static void main(String[] args) {

        String cityName = "";

        for (int j = 1; j < 99; j++) {
            try {
                //https://search.51job.com/list/000000,000000,0000,15,4,99,java,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=
                String url1 = "https://search.51job.com/list/000000,000000,0000," + j + ",4,99,java,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
                cityName = GetHtmlDataUtils.getTitle(url1);
                DBUtils.createDB(cityName + j);

                for (int i = 1; i <= 31; i++) {

//            String url = "https://search.51job.com/list/150000,000000,0000,01,9,99,java,2,"+ i +".html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";

//                    String url = "https://search.51job.com/list/"+ j +"00,000000,0000,01,9,99,java,2," + i + ".html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
                    String url = "https://search.51job.com/list/000000,000000,0000," + j + ",4,99,java,2," + i + ".html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";

                    size = DBUtils.insert(url, "job_position_" + cityName + j, size);

                    System.out.println("第\t" + i + "\t页爬取完成。。。");
                }
            } catch (Exception e) {
                System.out.println("有异常跳过，，" + e.getMessage());
            }

            System.out.println("共计爬取：\t" + size + "\t条数据");

        }
    }
}
//安徽的java岗位
//https://search.51job.com/list/150000,000000,0000,01,9,99,java,2,2.html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=
//https://search.51job.com/list/150000,000000,0000,01,9,99,java,2,3.html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=
//https://search.51job.com/list/150000,000000,0000,01,9,99,java,2,4.html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=
//南京的java岗位
//https://search.51job.com/list/070200,000000,0000,01,9,99,java,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9
//哈尔冰
//https://search.51job.com/list/220200,000000,0000,01,9,99,java,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9