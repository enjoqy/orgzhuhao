package com.zhuhao.design_mode.adapter.a;

import com.zhuhao.design_mode.adapter.a.immutable.*;
import org.junit.Test;

/**
 *
 *
 * @Author halk
 * @Date 2020/11/10 17:33
 */
public class Apply {

    private static String str = "123 456 qwe rDF";

    public static void process(Processor processor, Object str) {
        System.out.println(processor.name());
        System.out.println(processor.process(str));
    }

    @Test
    public void test01(){
        Apply.process(new Downcase(), str);
        Apply.process(new Upcase(), str);
        Apply.process(new Splitter(), str);

        /**
         * 可以对这段代码进行进一步的封装，减少重复的代码
         */
//        String str = "123 456 qwe rDF";
//
//        Processor processor = new Downcase();
//        System.out.println(processor.name());
//        System.out.println(processor.process(str));
//
//        Processor processor2 = new Upcase();
//        System.out.println(processor2.name());
//        System.out.println(processor2.process(str));
//
//        Processor processor3 = new Splitter();
//        System.out.println(processor3.name());
//        System.out.println(processor3.process(str));

    }

    @Test
    public void test02(){
        Waveform wf = new Waveform();

        Apply.process(new FilterAdapter(new HighPass(0)), wf);
        Apply.process(new FilterAdapter(new LowPass(0)), wf);
        Apply.process(new FilterAdapter(new BandPass(0, 1)), wf);
    }

}
