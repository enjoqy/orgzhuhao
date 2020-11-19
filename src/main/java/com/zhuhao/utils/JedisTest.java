package com.zhuhao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author halk
 * @Date 2020/7/7 0007 17:06
 */
public final class JedisTest {


    public static void main(String[] args) throws IOException {

        JedisUtil jedisUtil = JedisUtil.getInstance();
//        jedisUtil.set("a:b:c:11", "111", null );
        jedisUtil.delete("a:b:c:11");

    }
}

