package com.zimu.IM.utils;

import com.blade.ioc.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zimu
 * @title: TimeTools
 * @projectName IM
 * @description: TODO
 * @date 2019-04-1620:02
 */

@Bean
public class TimeTools {

    public String  currentDataTime(){
        /**
         * @Author: zimu
         * @Description: 获取当前系统时间，以datetime格式返回
         * @Date 20:19 2019-04-16
         * @Param []
         * @return java.lang.String
         **/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
