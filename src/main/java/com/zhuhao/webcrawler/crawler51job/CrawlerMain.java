package com.zhuhao.webcrawler.crawler51job;


import java.util.Map;
import java.util.Set;

/**
 * 程序入口
 */
public class CrawlerMain {


    public static void main(String[] args) {

        //调用工具类，获取， 省市对应的url
        Map<String, String> nationwideUrls = CreateNationwideUrls.createNationwideUrls();

        //获取全国32个省市的集合
        Set<String> provinces = nationwideUrls.keySet();

        for (String cityName : provinces){

            //根据省市的名称创建一个数据库
            DBUtils.createDB(cityName);

            //获取第一页的数据插入数据库，翻页未实现
            DBUtils.insert(nationwideUrls.get(cityName), cityName);
        }

    }
}
