package com.zhuhao.design_mode.principle.single_responsibilities.homework;

import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 找出文件中出现次数最多的单词（符合单一职责）
 *
 * @Author halk
 * @Date 2020/11/10 11:31
 */
public class AppTest {

    @Test
    public void test01() throws IOException {

        /**
         * 方法的语句在同一个抽象层级上
         * 有一个方法封装，最好都封装起来，处于都一个级别
         */
        String str = loadFile("F:\\3.txt");

        String[] words = parseWords(str);

        Map<String, Integer> map = countWords(words);

        Integer maxValue = getMaxValue(map);

        List<Map<String, Integer>> list = getKeyByValue(map, maxValue);

        System.out.println(list);


    }

    /**
     * 收集出现次数的单词
     *
     * @param map
     * @param maxValue
     * @return
     */
    private List<Map<String, Integer>> getKeyByValue(Map<String, Integer> map, Integer maxValue) {
        List<Map<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value.equals(maxValue)) {
                Map<String, Integer> hashMap = new HashMap<>();
                hashMap.put(entry.getKey(), entry.getValue());
                list.add(hashMap);
            }
        }
        return list;
    }


    /**
     * 获取出现次数最多的单词（key）
     *
     * @param map
     * @return
     */
    private Integer getMaxValue(Map<String, Integer> map) {

        Collection<Integer> values = map.values();
        return Collections.max(values);
    }

    /**
     * 统计单词出现的次数
     *
     * @param words
     * @return
     */
    private Map<String, Integer> countWords(String[] words) {

        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.put(word, ++count);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    /**
     * 对字符串进行解析，返回单词
     *
     * @param str
     * @return
     */
    private String[] parseWords(String str) {

        String[] split = str.split("[^a-zA-Z]+");
        return split;
    }

    /**
     * 将文件中内容读取到字符串
     *
     * @param path
     * @return
     */
    private String loadFile(String path) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            Reader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);

            while (br.ready()) {
                String str = br.readLine();
                stringBuilder.append(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
