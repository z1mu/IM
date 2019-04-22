package com.zimu.IM.utils;

import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author zimu
 * @title: QueryTools
 * @projectName IM
 * @description: TODO
 * @date 2019-04-1620:18
 */

@Bean
public class QueryTools {

    public String queryIpAdress(String ip) {
        /**
         * @Author: zimu
         * @Description: 查询ip地址
         * @Date 20:37 2019-04-16
         * @Param [ip]
         * @return java.lang.String
         **/
        String url  =   "http://iploc.market.alicloudapi.com/v3/ip?ip="+ip;
        try {
            URL u = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) u.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Authorization", "APPCODE 3a9893830aff456ea56a44f20ad44bd4");
            httpURLConnection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            String  data    =   reader.readLine();
            JSONObject object = (JSONObject) JSONObject.parse(data);
            return object.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(new Date().getTime());
            return "未查询到该IP地址！";
        }
    }
}
