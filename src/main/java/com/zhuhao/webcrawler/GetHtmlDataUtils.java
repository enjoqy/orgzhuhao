package com.zhuhao.webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.seimicrawler.xpath.JXDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public final class GetHtmlDataUtils {


    //获取文章标题，城市的名字
    public static String getTitle(String url) {
        Document doc = null;
        String cityName = "";
        try {
            doc = Jsoup.connect(url).get();
            String cityNameTmp = doc.title();
            cityName = cityNameTmp.substring(1, cityNameTmp.lastIndexOf("】"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;
    }

    public static List<User> getData(String url) {
        JXDocument jxdocument = JXDocument.createByUrl(url);

        List<User> list = new ArrayList();
        for (int i = 0; i < 49; i++) {
            User user = new User();

            try {
                //获取职位名称
                List<Object> jobTitleList = jxdocument.sel("//*[@id=\"resultList\"]/div[" + (i + 4) + "]/p/span/a");
                String jobTitleTmp = jobTitleList.get(0).toString();
                String jobTitle = jobTitleTmp.substring(jobTitleTmp.indexOf("\"> ") + 3, jobTitleTmp.indexOf(" </a>"));
//            System.out.println(jobTitle);
                user.setJobTitle(jobTitle);

                //获取公司名称
                //*[@id="resultList"]/div[4]/span[1]/a
                //*[@id="resultList"]/div[53]/span[1]/a
                List<Object> companyNameList = jxdocument.sel("//*[@id=\"resultList\"]/div[" + (i + 4) + "]/span[1]/a");
                String companyNameTmp = companyNameList.get(0).toString();
                String companyName = companyNameTmp.substring(companyNameTmp.indexOf("\">") + 2, companyNameTmp.indexOf("</a>"));
                user.setCompanyName(companyName);

                //获取工作地点
                //*[@id="resultList"]/div[4]/span[2]
                //*[@id="resultList"]/div[53]/span[2]
                List<Object> workingPlaceList = jxdocument.sel("//*[@id=\"resultList\"]/div[" + (i + 4) + "]/span[2]");
                String workingPlaceTmp = workingPlaceList.get(0).toString();
                String workingPlace = workingPlaceTmp.substring(workingPlaceTmp.indexOf("t3\">") + 4, workingPlaceTmp.indexOf("</span>"));
                user.setWorkingPlace(workingPlace);

                //获取薪资
                //*[@id="resultList"]/div[4]/span[3]
                //*[@id="resultList"]/div[53]/span[3]
                List<Object> salaryList = jxdocument.sel("//*[@id=\"resultList\"]/div[" + (i + 4) + "]/span[3]");
                String salaryTmp = salaryList.get(0).toString();
                String salarye = salaryTmp.substring(salaryTmp.indexOf("t4\">") + 4, salaryTmp.indexOf("</span>"));
                user.setSalary(salarye);

                //获取发布时间
                //*[@id="resultList"]/div[4]/span[4]
                //*[@id="resultList"]/div[53]/span[4]
                List<Object> releaseTimeList = jxdocument.sel("//*[@id=\"resultList\"]/div[" + (i + 4) + "]/span[4]");
                String releaseTimeTmp = releaseTimeList.get(0).toString();
                String releaseTime = releaseTimeTmp.substring(releaseTimeTmp.indexOf("t5\">") + 4, releaseTimeTmp.indexOf("</span>"));
                user.setReleaseTime(releaseTime);

                //放到list数组
                list.add(user);
            } catch (Exception e) {
                System.out.println("有异常，，，跳过！！" + e.getMessage());
            }
        }
        return list;
    }
}











/*

        for (Object obj: sel ) {
            String str = obj.toString();
//            System.out.println(str);
            System.out.println("--------------------------");

            List<Object> sel1 = JXDocument.create(str).sel("//*[@class=\"t1\"]");
            System.out.println(sel1);
*/


//            String jobTitle =  jobTitles.get(0).toString();
//            String substring = jobTitle.substring(jobTitle.indexOf("title=\"") + 7, jobTitle.indexOf("\" hre"));
//
//            System.out.println(substring);

         /*   //匹配职位名
            Matcher matcher *//*= Pattern.compile("(?<=title=\\\")[\\u4e00-\\u9fa5]*(?=\\\")\"").matcher(str);
            if(matcher.find()){
                String jobTitile = matcher.group();
                System.out.println("职位名： " +  jobTitile);
            }*//*

            //匹配公司名
            Pattern.compile("").matcher(str);


           */

//        return null;


    /*public static List<?>  getData(String html){
        List data = new ArrayList();
        System.out.println(html.length());
        Document doc = Jsoup.parse(html);

        //获取html中的内容 //*[@id="resultList"]/div[4]
        Elements elements = doc.select("div.el");  //img[src$=.png]  ////*[@id="resultList"]/div[16]/p/span/a
        System.out.println(elements.size());
        for (Object e:elements) {
            System.out.println(e);
        }
        return null;
    }*/


   /* public static String getHtml(String url) {

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            System.out.println(doc.title());
            System.out.println("输出成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc.html();

    }


    public static void main(String[] args) {
        String url = "https://search.51job.com/list/150000,000000,0000,01,9,99,%2520,2,1.html?lang=c&stype=&postchannel=0000&workyear" +
                "=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
//        String html = GetHtmlDataUtils.getHtml(url);
//        System.out.println(html);
//        String request = GetHtmlDataUtils.getRequest(url);
//        System.out.println(request);

        MyParse.getData();
    }


    public static String getRequest(String requestUrl) {
        String res = "";
        StringBuffer buffer = new StringBuffer();

        try {
            URL url = new URL(requestUrl);
            //打开链接
            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
            if (200 == urlCon.getResponseCode()) {  //从HTTP响应消息获取状态代码。200代表成功
                InputStream is = urlCon.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "gbk"));

                String str = null;
                while ((str = br.readLine()) != null) {
                    buffer.append(str);
                }

                //关闭流
                br.close();
                is.close();

                res = buffer.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }*/
