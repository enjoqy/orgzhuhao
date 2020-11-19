package com.zhuhao.design_mode.decorator.e;

import org.junit.Test;

import java.io.*;

/**
 * 至此，我们已经学习完了“装饰器模式”
 * <p>
 * 其实jdk中的流就是装饰器模式
 *
 * @Author halk
 * @Date 2020/11/9 10:34
 */
public class AppTest {

    /**
     * InputStream相当于饮料
     * FilterInputStream相当于调料继承了饮料，并且关联了饮料
     *
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test01() throws FileNotFoundException, UnsupportedEncodingException {
        InputStream in = new FileInputStream("F:\\1.txt");
        //将读取到的字符或者字节缓存起来，到达一定数量之后在放到内存中
        BufferedInputStream bis = new BufferedInputStream(in);
        InputStreamReader isr = new InputStreamReader(bis, "GBK");
    }

    /**
     * Reader相当于饮料
     * BufferedReader相当于调料继承了饮料，并且关联了饮料
     * FilterReader相当于调料继承了饮料，并且关联了饮料
     * 使用了装饰器模式
     * <p>
     * 现在重写BufferedReader
     */
    @Test
    public void test02() throws IOException {
        Reader fileReader = new FileReader("F:\\2.txt");
//        MyBufferedReader br = new MyBufferedReader(fileReader);
//        BufferedReader br = new BufferedReader(fileReader);

//        LineNumberReader lnr = new LineNumberReader(fileReader);
        MyLineNumberReader lnr = new MyLineNumberReader(fileReader);

        String line;
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + " : " + line);

        }

        lnr.close();

    }

    @Test
    public void test03(){
        int i = 0;
        int a = i++;
        System.out.println(a);
        System.out.println(i);
    }
}
