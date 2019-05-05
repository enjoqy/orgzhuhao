package com.zhuhao.network.homework;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8888);
        //控制台输入流
        new Thread(new Send()).start();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        while (true) {
            //输出流，接收到控制台的消息，并发送出去
            String info = console.readLine();
            dos.writeUTF(info);
            dos.flush();

            //输入流，接收消息
            String msg = dis.readUTF();
            System.out.println(msg);

        }


    }
}
