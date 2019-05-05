package com.zhuhao.regex;

import com.zhuhao.webcrawler.DBUtils;

import java.io.*;
import java.util.Properties;

public class PripertiesDemo {
    public static void main(String[] args) throws IOException {
      /*  Properties p = new Properties();

        p.setProperty("xx", "mm");
        p.setProperty("11", "aa");
        p.setProperty("22", "bb");

        PrintStream ps = new PrintStream("testproperties.properties");
        p.store(ps, "这个是自动生成的properties配置文件");

        PrintStream ps01 = new PrintStream("test.xml");
        p.storeToXML(ps01, "这个是自动生成的xml配置文件");*/

      /*  InputStream is = null;
        Properties properties = new Properties();
        //将资源放在try()，jvm会自动帮我们关闭
        try  {
            is = PripertiesDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
           // FileInputStream is = new FileInputStream("H:\\orgzhuhao\\jdbc.properties");
            //通过配置文件获取jdbc所需的属性
            properties.load(is);
            String driver = properties.getProperty("jdbc.driver_class");
            System.out.println(driver);
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
