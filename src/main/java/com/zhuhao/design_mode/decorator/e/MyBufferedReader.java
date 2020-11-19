package com.zhuhao.design_mode.decorator.e;

import java.io.IOException;
import java.io.Reader;
import java.util.TreeMap;

/**
 * 自己重写BufferedReader，实现读取一行的逻辑（Reader只能读取一个字符）
 *
 * @Author halk
 * @Date 2020/11/9 11:24
 */
public class MyBufferedReader extends Reader {

    protected Reader in;

    public MyBufferedReader(Reader in) {
        this.in = in;
    }

    /**
     * 实现返回一行字符的方法
     *
     * @return
     * @throws IOException
     */
    public String readLine() throws IOException {

        StringBuilder sb = new StringBuilder();
        int c;
        while (true) {
            c = this.in.read();

            if (c == '\r') {
                continue;
            }

            if (c == -1 || c == '\n') {
                break;
            }

            sb.append((char) c);
        }

        if (sb.length() == 0) {
            if (c == '\n') {
                return "";
            }else {
                return null;
            }
        }

        return sb.toString();
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        //空方法
        return 0;
    }

    @Override
    public void close() throws IOException {

        if (null != in) {
            in.close();
        }
    }
}
