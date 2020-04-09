package com.zhuhao.utils.smsUtils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.google.common.collect.Maps;

import java.util.HashMap;

public class SendMessageUtils {
    /**
     * 发送消息
     * @param phone  手机号
     * @param code  验证码
     * @param intervalTime  验证码多长时间有效
     * @param modelId  模板id
     * @param time
     *
     * 备注： 如果报   Connection to https://app.cloopen.com:8883 refused  SDKTestGetSubAccounts result={statusMsg=网络错误, statusCode=172001}  
     * 			需要配置host文件最后加上一行		42.121.254.126  app.cloopen.com  ，这样子就好了
     * 
     * @return
     */
    public static HashMap<String, HashMap<String, Object>> sendSms(String phone, String code, String intervalTime, String modelId, Long time){
        HashMap<String, HashMap<String, Object>> resultMap = Maps.newHashMap();
        HashMap<String, Object> result = null;

        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

        //******************************注释*********************************************
        //*初始化服务器地址和端口                                                       *
        //*沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
        //*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883");       *
        //*******************************************************************************
        restAPI.init(MessageConstants.PRO_SERVERIP, MessageConstants.PRO_SERVERPORT);

        //******************************注释*********************************************
        //*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
        //*ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
        //*参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。                   *
        //*restAPI.setAccount("8a48b5514ab8cc53014ab981bdde00fb", "2e2b2cb88cec42388de786879f0502e6");
        //*******************************************************************************

        restAPI.setAccount(MessageConstants.ACCOUNT_SID, MessageConstants.ACCOUNT_TOKEN);


        //******************************注释*********************************************
        //*初始化应用ID                                                                 *
        //*测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID     *
        //*应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
        //*restAPI.setAppId("8aaf070856d4826c0156da7fc791087b");
        //*******************************************************************************
        restAPI.setAppId(MessageConstants.XINRUIDA_APPID);



        //******************************注释****************************************************************
        //*调用发送模板短信的接口发送短信                                                                  *
        //*参数顺序说明：                                                                                  *
        //*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号                          *
        //*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。    *
        //*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
        //*第三个参数是要替换的内容数组。                                                                                                                               *
        //**************************************************************************************************

        //**************************************举例说明***********************************************************************
        //*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为           *
        //*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});                                                                          *
        //*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入     *
        //*********************************************************************************************************************
        //result = restAPI.sendTemplateSMS(userName,modelId ,new String[]{code,"1"});
//        result = restAPI.sendTemplateSMS(phone,modelId ,new String[]{code,""+time});
        result = restAPI.sendTemplateSMS(phone,modelId ,new String[]{code,intervalTime});
        //result = restAPI.sendTemplateSMS(userName,"1" ,new String[]{"6532","5"});
        System.out.println("SDKTestGetSubAccounts result=" + result);
        if("000000".equals(result.get("statusCode"))){
            result.put("verifyCode",code);
            resultMap.put("SUCCESS",result);
            return resultMap;
        }else{
            resultMap.put("ERROR",result);
            return resultMap;
        }
    }

    public static void main(String[] args) {

        sendSms("18355182591","8888", "3","581654", 1L);//"8a48b5515493a1b70154c7a0d76c3445"//8aaf070858297ab601582de03da60775

    }
}
