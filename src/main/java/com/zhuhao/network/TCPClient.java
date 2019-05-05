package com.zhuhao.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP/IP协议的套接字客户端
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动");

        while (true) {
            //客户端给服务端发送消息
            Socket client = new Socket("localhost", 1926);
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            //获取控制台输入的消息
            System.out.print("请输入给服务器发送的消息:\t");
            Scanner input = new Scanner(System.in);
            String sendMessge = input.next();
            dos.writeUTF(sendMessge);

            //接收服务端发来的消息
            System.out.print("等待接收到来自服务器的消息。。。\t");
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String messge = dis.readUTF();
            System.out.println(messge + "\n");
        }

    }
}
