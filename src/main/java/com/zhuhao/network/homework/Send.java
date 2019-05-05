package com.zhuhao.network.homework;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据线程
 *
 * @author: zhuhao
 * @Date: 2019/3/30 0030 11:12
 */
public class Send implements Runnable {

    private BufferedReader console = null;
    private DataOutputStream dos = null;
    private Boolean isRunning = true;

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));

    }

    public Send(Socket client) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            isRunning = false;
//            e.printStackTrace();
            CloseUtil.closeAll(dos, console);
        }
    }

    //1、从控制台接收数据
    private String getMsgFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //2、发送数据
    public void send() {
        String msg = getMsgFromConsole();
        if (null != msg && msg.equals("")) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dos, console);
            }
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            send();
        }

    }
}
