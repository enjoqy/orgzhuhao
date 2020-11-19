package org.halk.lombok;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author halk
 * @Date 2020/5/21 0021 11:15
 */
public class Demo01 {

    /**
     * 继承类中使用@data时，需要显式的加上@EqualsAndHashCode(callSuper = true)，@ToString(callSuper = true)以调用超类
     * 不加时进行equals比较，不会比较超类的属性
     */
    @Test
    public void test01() {
        User user = new User();
        user.setId(1L);
        user.setName("xiao");

        User user2 = new User();
        user2.setId(22222L);
        user2.setName("xiao");

        System.out.println(user);
        System.out.println(user2);

        System.out.println(user.equals(user2));
    }

    @Test
    public void test02() throws JsonProcessingException {
        String jsonStr = "[\"{'pic':'http://wx1.sinaimg.cn/large/00630Gpxly1g9jurfojgsg307s04zdv8.gif','text':'你下贱，你只是馋他的身子'}\", \"{'pic':'http://img.gaoxiaogif.com/d/file/201912/344e9a5829acb62776014a53a4ce5273.gif','text':'跟着老爸出来做个大宝剑'}\", \"{'pic':'http://img.gaoxiaogif.com/d/file/201912/6f6adb2e7df9be288740fe560524c071.gif','text':'对于这种车来说，窗帘就格外重要了'}\", \"{'pic':'http://img.gaoxiaogif.com/d/file/201912/d88515622ccb8e8eea970097fc60dbaa.gif','text':'这情节，好像在日本电影中看到过~'}\", \"{'pic':'http://img.gaoxiaogif.com/d/file/201912/bf3938859a46b3514ff30466c8e776fe.gif','text':'这种好事怎么不叫我！'}\", \"{'pic':'http://img.gaoxiaogif.com/d/file/201912/c35f5bb8a69157b84b613ec970c5e916.gif','text':'这才是真正的有福同享有难同当'}\", \"{'pic':'http://img.gaoxiaogif.com/d/file/201912/973252f939a613673a272145540aa216.gif','text':'我也想学演戏啊！'}\", \"{'pic':'http://img.gaoxiaogif.com/d/file/201912/1b9df70e4e73ad5425a3d11e05ffb8de.gif','text':'好真实的女人'}\", \"{'pic':'http://img.gaoxiaogif.com/d/file/201912/a8098537da58297a66c2bf5e7c39c971.gif','text':'腿短了点，跳得还是不错的'}\"]";
        String replace = jsonStr.replace("\'", "\\\"");
        jsonStr = replace;

        JSONArray jsonArray1 = JSONArray.parseArray(jsonStr);

        List<Map> list = new ArrayList<>();
        jsonArray1.forEach(json -> {
            Map<String, String> map = new HashMap<>();
            JSONObject jsonObject = JSONObject.parseObject((String) json);
            String pic = jsonObject.getString("pic");
            String url = jsonObject.getString("text");
            map.put("pic", pic);
            map.put("url", url);
            list.add(map);
        });


        list.forEach(System.out::println);
    }
}
