package com.zhuhao.basic.collection;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 保留两位小数4种方法
 * @Author halk
 * @Date 2020/2/25 16:10
 */
public class RoundHalfUp {

    @Test
    public void test01(){
        double f = 12.5585;
        double format = Double.valueOf(String.format("%.3f", f));
        System.out.println(format);
    }

    @Test
    public void test02(){
        double f = 12.5585;
        DecimalFormat df = new DecimalFormat("#.000");
        Double format = Double.valueOf(df.format(f));
        System.out.println(format);
    }

    @Test
    public void test03(){
        double f = 12.5585;
        BigDecimal bd = new BigDecimal(f);
        double format = bd.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(format);

        //上面的方法已过时，建议使用下面的枚举方法
        double format1 = bd.setScale(3, RoundingMode.HALF_UP).doubleValue();
        System.out.println(format1);
    }

    @Test
    public void test04(){
        double f = 12.5585;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(3);
        Double format = Double.valueOf(nf.format(f));
        System.out.println(format);
    }

}
