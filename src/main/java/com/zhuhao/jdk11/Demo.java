package com.zhuhao.jdk11;

import com.zhuhao.collection.ArraysList;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * jdk11 新特性
 * @Author halk
 * @Date 2020/1/18 19:51
 */
public class Demo {

    @Test
    public void test07(){
        Random random = new Random();
        int count = 10000;
        ArrayList<List> listAll = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> list = new ArrayList<>();
            int radom1 = random.nextInt(100);
            int radom2 = random.nextInt(100- radom1);
            int radom3 = random.nextInt(100- radom1 - radom2);
            int radom4 = random.nextInt(100- radom1 - radom2 - radom3);
            int radom5 = 100- radom1 - radom2 - radom3 - radom4;
            int sum = radom1 + radom2 + radom3 + radom4 + radom5;
            list.add(radom1);
            list.add(radom2);
            list.add(radom3);
            list.add(radom4);
            list.add(radom5);
            list.add(sum);
            listAll.add(list);
//            System.out.println(radom1 + "\t" + radom2 + "\t" + radom3 + "\t" + radom4 + "\t" + radom5 + "\t" + sum);
        }

    }

    @Test
    public void test06(){
        //测试sting
        String str = "EEEE";

        String d = new String("D");
        String d2 = new String("D");

        System.out.println(str.equals("EEEE"));
        System.out.println(d.equals(d2));

        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>(Arrays.asList(1));

        System.out.println(list1.isEmpty());
        System.out.println(list2.isEmpty());

        char a = 'A';
        char b = 'B';
        char c = 'C';
        char cc = 'C';

        System.out.println(String.valueOf(a).compareTo(String.valueOf(b)));
        System.out.println(String.valueOf(c).compareTo(String.valueOf(cc)));
    }

    /**
     * @Author halk
     * @Description 集成httpClient API
     * @Date 2020/1/18 20:41
     * @Param []
     * @return void
     **/
    @Test
    public void test04() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://zhidao.baidu.com/question/568761338.html"))
                .GET()
                .build();
        System.out.println(request);
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        for (int i = 0; i < 500; i++) {

            HttpResponse<String> response1 = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("请求：" + i + " 次, 状态码： " + response1.statusCode());
        }
//
//
//        System.out.println(response);
//        System.out.println(response.uri());
//        System.out.println(response.headers());
//        System.out.println(response.request());
//        System.out.println(response.statusCode());
//        System.out.println(response.sslSession());
//        System.out.println(response.previousResponse());
//        System.out.println(response.body());

    }

    @Test
    public void test05() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/coreachcms/"))
                .GET()
                .build();
        System.out.println(request);
        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        for (int i = 0; i < 500; i++) {

            HttpResponse<String> response1 = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("请求：" + i + " 次, 状态码： " + response1.statusCode());
//            System.out.println(response1.body());
        }
//
//
//        System.out.println(response);
//        System.out.println(response.uri());
//        System.out.println(response.headers());
//        System.out.println(response.request());
//        System.out.println(response.statusCode());
//        System.out.println(response.sslSession());
//        System.out.println(response.previousResponse());
//        System.out.println(response.body());

    }

    @Test
    public void test03(){
        //从n<3不成立时进行收集，一直到最后
        List<Integer> collect01 = Stream.of(1, 2, 3, 2, 1, 8, 2)
                .dropWhile(n -> n < 3)
                .collect(Collectors.toList());

        collect01.forEach(x -> System.out.println(x));
    }

    /**
     * @Author halk
     * @Description 对strem()进行增强 
     * @Date 2020/1/18 20:21
     * @Param []
     * @return void
     **/
    @Test
    public void test02(){
        //对<3的进行收集，遇到>=3的停止收集
        List<Integer> collect01 = Stream.of(1, 2, 3, 2, 1, 0)
                .takeWhile(n -> n < 3)
                .collect(Collectors.toList());
//        collect01.forEach(x -> System.out.println(x));

        //Arrays.asList()返回的是不可变集合，不可进行增删改操作
        List<Integer> list = Arrays.asList(1, 1, 5, 8, 9, 9, 5, 2, 6, 4);
//        list.add(9);


        //使用这种方法可以转为正常集合，可进行增删改查操作
        List<Integer> list01 = new ArrayList<>(Arrays.asList(1, 1,5, 8, 9, 9, 5, 2, 6, 4));
        list01.add(8);
        list01.remove(0);
        list01.set(0, 3);
        List<Integer> list02 = list01.stream().takeWhile(n -> n < 6).collect(Collectors.toList());
        list02.forEach(x -> System.out.println(x));

    }

    /**
     * @Author halk
     * @Description 新增var， List.of()返回一个不可变集合， list.copyOf()复制一个数组 
     * @Date 2020/1/18 20:20
     * @Param []
     * @return void
     **/
    @Test
    public void test01(){

        var number = 11;

        var str = "hello jdk11";
        System.out.println(str);
        System.out.println(number);

        //去除首位空格
        var strip = " ni hao ".strip();
        System.out.println(strip);

        var list = new ArrayList();
        list.forEach(x -> System.out.println(x));

        var blank = "".isBlank();
        System.out.println(blank);

        var blank2 = "".isEmpty();
        System.out.println(blank2);

        var list2 = List.of(1,2,3,"222", 1.1f, 3L,'c');

        var list3 = List.copyOf(list2);

        //list.of()返回的是不变集合，不能进行增删改的操作
        list2.set(1, 2);
        list2.remove(1);
        list2.add(1);

        list2.forEach(x -> System.out.println(x));


    }
}
