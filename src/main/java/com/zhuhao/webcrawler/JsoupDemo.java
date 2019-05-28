package com.zhuhao.webcrawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        test01();
    }

    public static void test01() throws IOException {
        String url = "http://www.xiaohuar.com/list-1-2.html";
        Connection connect = Jsoup.connect(url);
        Document doc = connect.get();
        Elements elements = doc.select("img[src$=.jpg]");
        for (Object obj : elements) {
            System.out.println(obj);
        }
    }
}
