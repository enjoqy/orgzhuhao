package com.zhuhao.jsondemo.FASTJsonDemo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Demo01 {

    //json字符串-简单对象型
    private static String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    /**
     * json字符串-简单对象型到JSONObject的转换
     *
     * @author: zhuhao
     * @date: 2019/4/8 0008 20:17
     */
    public static void test01() {
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        System.out.println(jsonObject);
        System.out.println(jsonObject.getString("studentName"));
        System.out.println(jsonObject.getInteger("studentAge"));
    }

    /**
     * JSONObject到json字符串-简单对象型的转换
     *
     * @author: zhuhao
     * @date: 2019/4/8 0008 20:18
     */
    public static void test02() {
        //已知JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        // 第一种方式
        String s = JSONObject.toJSONString(jsonObject);
        System.out.println(s);
        // 第二种方式
        String s1 = jsonObject.toJSONString();
        System.out.println(s1);

    }

    /**
     * json字符串-数组类型到JSONArray的转换
     *
     * @author: zhuhao
     * @date: 2019/4/8 0008 20:24
     */
    public static void test03() {
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
        //1.遍历方式
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("studentName") + "\t" + jsonObject.getInteger("studentAge"));
        }

        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.getString("studentName") + "\t" + jsonObject.getInteger("studentAge"));
        }

    }

    /**
     * JSONArray到json字符串-数组类型的转换
     *
     * @author: zhuhao
     * @date: 2019/4/8 0008 22:04
     */
    public static void test04() {
        //已知JSONArray,目标要转换为json字符串
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
        //第一种方式
        String s = JSONArray.toJSONString(jsonArray);
        System.out.println(s);

        // 第二种方式
        String s1 = jsonArray.toJSONString();
        System.out.println(s1);
    }

    public static void main(String[] args) {
        test04();
    }

}
