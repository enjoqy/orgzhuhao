package com.zhuhao.basic.lambdademo.streamdemo;
/**
 * @author: zhuhao
 * @date: 2019/4/6 0006 10:27
 */

import java.util.Arrays;

/**
 * Stream 流
 * 		1.定义
 * 			1.对数据源进行一系列流水线式的中间操作，产生一个流对象
 * 			2.集合讲的是数据，流讲的是计算
 * 		2.注意
 * 			1.Stream自己不会存储元素
 * 			2.Stream不会改变源对象，相反，他们会返回一个持有结果的新Stream
 * 			3.Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行
 * 			4.返回值是Stream就是惰性求值，返回值是具体的数据类型就是及早求值（说明执行了终止操作）
 * 		3.操作步骤
 * 			1.创建Stream：一个数据源（如：集合、数组），获取一个流
 * 			2.中间操作：一个中间操作链，对数据源的数据进行处理
 * 			3.终止操作（终端操作）：一个终止操作，执行中间操作链，并产生结果
 *
 *
 * @author junki
 * @date 2019年4月4日
 */
public class Demo01Stream {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //打印数组中大于7的元素
        Arrays.stream(nums).filter(x -> x > 7).forEach(System.out::println);

        //返回数组中大于5的元素的个数
        long count = Arrays.stream(nums).filter(q -> q > 5).count();
        System.out.println(count);
    }
}
