package com.zhuhao.utils.smsUtils.aliyun;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.0</version>
</dependency>
*/
/**
 * @Author halk
 * @Description 阿里发送短信的demo，新版demo
 * @Date 2020/5/29 0029 23:38
 * @Param
 * @return
 **/
public class SendSms {
    public static void main(String[] args) {
        //第二个和第三个参数：AccessKey ID，	AccessKey Secret
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIRHnKpcs9USnd", "Ezc3OO7LiSbt2e8RgLvkldaLMLjnI9");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
//        request.setSysMethod(MethodType.POST);
        //产品域名,开发者无需替换
//        request.setSysDomain("dysmsapi.aliyuncs.com");
        //无需更改
//        request.setSysVersion("2017-05-25");
        //调用api的名称
//        request.setSysAction("SendSms");
        //
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //必填:待发送手机号
        request.putQueryParameter("PhoneNumbers", "18355182591");
        //必填:短信签名-可在短信控制台中找到
        request.putQueryParameter("SignName", "coreach网站通知");
        //必填:短信模板-可在短信控制台中找到
        request.putQueryParameter("TemplateCode", "SMS_171858094");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.putQueryParameter("TemplateParam", "{ \"code\": \"8858\" }");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println("getData: "+ response.getData());
            System.out.println(response.getHttpResponse());
            System.out.println(response.getHttpStatus());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
