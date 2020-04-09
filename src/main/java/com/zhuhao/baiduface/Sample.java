package com.zhuhao.baiduface;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author junhi
 * @date 2019/11/7 17:09
 */
public class Sample {

    //设置APPID/AK/SK
    public static final String APP_ID = "17719603";
    public static final String API_KEY = "OIhCTLqjoKb4pN2AoBAlomGM";
    public static final String SECRET_KEY = "bUgQaHvgY9PwUMOcyaQ1fw1N0STEG2V2";

    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理


        // 调用接口
        String image = "http://b115.photo.store.qq.com/psb?/V13lGsTT1NoTDl/pDzBerc69cp0X7Phqhq*ORT9jXhHU7SBJcA.7q4yaxw!/b/dDfOlERGMQAA&bo=IANYAkAGsAQBCKQ!&rf=viewer_4";
        String imageType = "URL";



        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age,beauty,expression,face_shape,gender,glasses,landmark,landmark72,landmark150,race,quality,eye_status,emotion,face_type");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        options.put("liveness_control", "LOW");

        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString(2));

    }

    public void sample(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        options.put("liveness_control", "LOW");

        String image = "取决于image_type参数，传入BASE64字符串或URL字符串或FACE_TOKEN字符串";
        String imageType = "BASE64";

        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString(2));

    }
}
