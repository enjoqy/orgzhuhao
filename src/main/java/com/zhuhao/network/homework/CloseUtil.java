package com.zhuhao.network.homework;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
    public static void closeAll(Closeable... io) {
        for (Closeable tmp : io) {
            try {
                if (null != tmp) {
                    tmp.close();
                } else {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
