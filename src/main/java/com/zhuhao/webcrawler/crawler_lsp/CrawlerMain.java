package com.zhuhao.webcrawler.crawler_lsp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @Author halk
 * @Date 2021/1/13 19:25
 */
public class CrawlerMain {
    static String url = "http://www.baidu.com";

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect(url).get();
        String title = document.title();
        System.out.println(title);
    }
}
