package com.zhuhao.jsondemo.FASTJsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * FASTJson
 * JSON 指的是 JavaScript 对象表示法（JavaScript Object Notation）
 * JSON 是轻量级的文本数据交换格式
 * JSON 独立于语言：JSON 使用 Javascript语法来描述数据对象，但是 JSON 仍然独立于语言和平台
 * JSON 具有自我描述性，更易理解
 * 1.Fastjson 是一个 Java 库，可以将 Java 对象转换为 JSON 格式，当然它也可以将 JSON 字符串转换为 Java 对象。
 * 2.
 * JSON 通常用于与服务端交换数据。
 * 在接收服务器数据时一般是字符串。
 * <p>
 * 与 XML 相同之处
 * JSON 是纯文本
 * JSON 具有"自我描述性"（人类可读）
 * JSON 具有层级结构（值中存在值）
 * JSON 可通过 JavaScript 进行解析
 * JSON 数据可使用 AJAX 进行传输
 *
 * @author: zhuhao
 * @date: 2019/4/8 0008 17:00
 */
public class FASTJson {

    //解析
    public static void test01() {
        // 对象嵌套数组嵌套对象
        String json1 = "{\"id\":110,\"name\":\"Java\",\"stus\":[{\"age\":20,\"id\":10,\"name\":\"小明\"},{\"age\":21,\"id\":11,\"name\":\"小明\"},{\"age\":22,\"id\":12,\"name\":\"小明\"}]}";
        // 数组
        String json2 = "['北京','天津','杭州']";
        //1.静态方法
        Grade grade = JSON.parseObject(json1, Grade.class);
        System.out.println(grade);

        //2.解析为一个string类型的数组
        List<String> list = JSON.parseArray(json2, String.class);
        System.out.println(list);
    }

    //生成
    public static void test02() {
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Student(10 + i, "小明", 20 + i));
        }
        Grade grade = new Grade(110, "Java", list);
        String s = JSON.toJSONString(grade);
        System.out.println(s);
    }

    public static void main(String[] args) {
        test02();
    }


    /**
     * @Author halk
     * @Description 对json中的数组进行解析
     * @Date 2020/6/10 0010 17:33
     * @Param []
     * @return void
     **/
    @Test
    public void test03() throws JsonProcessingException {

        String json = "{\"skuIds\": [10521526784,5835263]}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json).get("skuIds");
        if (jsonNode.isArray()) {
            jsonNode.forEach(System.out::println);
        }


        JSONObject jsonObject = JSON.parseObject(json);
        String skuIds1 = jsonObject.getString("skuIds");
        List<Long> longs = JSON.parseArray(skuIds1, Long.class);
        longs.forEach(System.out::println);

    }
}
