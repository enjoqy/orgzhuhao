package com.zhuhao.network;

import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * 网络编程：
 * 1.相关协议：
 * 1.TCP/IP：一批协议集合的统称。
 * 2.TCP：传输控制协议。安全、稳定、可靠。
 * 三次握手：
 * 第一次握手：客户端向服务器发送数据  --> 发送状态
 * 第二次握手：服务器向客户端发送数据  --> 接收状态
 * 第三次握手：客户端确认服务器的数据  --> 连接状态
 * 三次握手确认完毕，开始传输数据，传输的是二进制数据。
 * 3.UDP：用户数据报协议。不安全的、不稳定、不可靠的。
 * 4.IP：网络协议。
 * 5.ARP：地址解析协议，arp-a获取物理地址和ip地址。
 * 6.HTTP：超文本传输协议。
 * 7.FTP：文本传输协议。
 * 8.POP3：邮局协议版本3，邮件接收协议。
 * 9.SMTP：简单的邮件传输协议，邮件发送协议。
 * <p>
 * 2.IP地址和端口号
 * 本机的IP地址：
 * 1.localhost
 * 2.127.0.0.1
 * 3.局域网的实际IP
 * 4.广域网（公网）的实际IP
 * 3.网络编程相关类
 * 1.和IP地址相关的类
 * InetAddress\Inet4Address\Inet6Address
 * 2.URL地址
 * http://183.232.231.174:8080/video/nijie.avi
 * 1.http：网络协议
 * 2.183.232.231.174：公网地址，一般可以映射为网络域名
 * 3.8080：端口号，如果是80端口，可以省略。
 * 4.video/nijie.avi：资源路径
 * 3.URL相关类：
 * 1.URL
 * 2.URLEncoder：编码
 * 3.URLDecoder：反编码
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class NetworkDemo {

    public static void main(String[] args) throws UnknownHostException, MalformedURLException, UnsupportedEncodingException {
        test01();
    }

    public static void test01() throws MalformedURLException, UnsupportedEncodingException {
//        URL url = new URL("http：//123.125.114.144:8080/nijie.avi");
        String encode = URLEncoder.encode("http：//123.125.114.144:8080/nijie.avi", "utf-8");
        System.out.println(encode);

        String decode = URLDecoder.decode(encode);
        System.out.println(decode);

    }


    public static void test() throws UnknownHostException {
        InetAddress name1 = Inet4Address.getByName("localhost");
        System.out.println(name1);

        InetAddress name = InetAddress.getByName("localhost");
        System.out.println(name);

        InetAddress name2 = Inet6Address.getByName("localhost");
        System.out.println(name2);

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress byAddress = InetAddress.getByAddress("192.168.124.1".getBytes());
        System.out.println(byAddress);


    }


}
