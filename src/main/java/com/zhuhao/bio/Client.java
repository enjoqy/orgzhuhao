package com.zhuhao.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author junhi
 * @date 2019/11/11 16:48
 */
public class Client {

    final static String ADDRESS = "192.168.1.117";
    final static int PORT = 8765;

    public static void main(String[] args) throws IOException {
            Socket socket = new Socket(ADDRESS, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("接受到客户端的请求数据");
            String response = in.readLine();
            System.out.println("Client " + response);
    }
}
