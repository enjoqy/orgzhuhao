package com.zhuhao.webcrawler.crawler51job;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 返回全国32个省市的map集合
 * @Author junhi
 * @Date 2019/5/28 15:42
 */
public class CreateNationwideUrls {

    /**
     * 返回全国32个省市的map集合
     *
     * @param
     */
    public static Map<String, String> createNationwideUrls() {

        String url = "https://search.51job.com/list/010000,000000,0000,00,9,99,java,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
        String provinceUrl = "";
        Map<String, String> provincesUrl = new LinkedHashMap<>();
        String[] provinces = {
                "北京", "上海", "广东省", "深圳", "天津", "重庆", "江苏省", "浙江省",
                "四川省", "海南省", "福建省", "山东省", "江西省", "广西", "安徽省", "河北",
                "河南省", "湖北省", "湖南省", "陕西省", "山西省", "黑龙江省", "辽宁省", "吉林省",
                "云南省", "贵州省", "甘肃省", "内蒙古", "宁夏", "西藏", "新疆", "青海省"};
        for (int i=1; i<=provinces.length; i++){
            if( i<=9 ){
                provinceUrl = url.substring(0, 31) + i + url.substring(32);
                provincesUrl.put(provinces[i-1], provinceUrl);
            }else {
                provinceUrl = url.substring(0, 30) + i + url.substring(32);
                provincesUrl.put(provinces[i-1], provinceUrl);
            }
        }
        return provincesUrl;

    }

}
