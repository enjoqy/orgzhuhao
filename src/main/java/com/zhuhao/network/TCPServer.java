package com.zhuhao.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(1926);
        System.out.println("服务端启动");
//        System.out.println("你已经跟服务器建立连接，可以发发送消息了!");
        System.out.println("服务器持续监听。。。");

        while (true) {
            Socket link = server.accept();

            //接收客户端发来的消息
            System.out.print("等待接收到客户端发来的消息。。。" + "\t");
            DataInputStream dis = new DataInputStream(link.getInputStream());
            String messge = dis.readUTF();
            System.out.println(messge + "\n");

            //给客户端发消息
            System.out.print("请输入给客户端发送的消息：\t");
            DataOutputStream dos = new DataOutputStream(link.getOutputStream());
            Scanner input = new Scanner(System.in);
            String sendMessge = input.next();
            dos.writeUTF(sendMessge);
        }

    }
}
