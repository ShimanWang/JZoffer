import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @program: api_auto_learing
 * @description: 解析json串
 * @author: Mr.Wang
 * @create: 2019-10-03 11:39
 **/
public class TestJSON {
    public static void main(String[] args) {
        String jsonString = "{\"mobilephone\":\"19000000000\",\"pwd\":\"\"}";//引号需要转义
        //从json串里面提取出来对应的key、value
        //一个很重要的类JSONObject、parse解析,解析成一个object类型的对象
        Map<String,String> jsonMap = (Map<String, String>) JSONObject.parse(jsonString);
        String mobilephone = jsonMap.get("mobilephone");
        System.out.println(mobilephone);
    }
} 
