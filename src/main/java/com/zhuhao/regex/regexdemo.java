package com.zhuhao.regex;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * 1.定义：正则表达式(regular expression)描述了一种字符串匹配的模式（pattern），可以用来检查一个串是否含有某种子串、将匹配的子串替换或者从某个串中取出符合某个条件的子串等。
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class regexdemo {

    public static void main(String[] args) {

        //正则表达式获取url地址
        String str = "<a href=\"/p-1-290.html\"  target=\"_blank\"><img width=\"210\"  alt=\"中专校花鞠婧祎\" src=\"http://www.xiaohuar.com/d/file/20141116030511162.jpg\" /></a>\n";
        Pattern compile = Pattern.compile("(?<=src=\\\")[[\\s\\S]&&[^>]]*(?=\" />)");
        Matcher matcher = compile.matcher(str);
        matcher.find();
        String url = matcher.group();

        //正则表达式获取img图片名字
        Pattern compile1 = Pattern.compile("(?<=/)[[\\s\\S]&&[^/]]*(?=\" />)");
        Matcher matcher1 = compile1.matcher(str);
        matcher1.find();
        String name = matcher1.group();
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
            System.out.println("下载成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
