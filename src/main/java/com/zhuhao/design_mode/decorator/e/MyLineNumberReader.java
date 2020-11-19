package com.zhuhao.design_mode.decorator.e;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author halk
 * @Date 2020/11/9 14:59
 */
public class MyLineNumberReader extends MyBufferedReader {

    /**
     * 行号
     */
    private int lineNumber = 0;

    public MyLineNumberReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        String l = super.readLine();
        if (null != l){
            lineNumber++;
        }
        return l;
    }

    public int getLineNumber(){
        return lineNumber;
    }
}
