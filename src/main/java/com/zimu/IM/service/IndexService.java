package com.zimu.IM.service;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.zimu.IM.entity.Zimu_level;
import com.zimu.IM.entity.Zimu_link;
import com.zimu.IM.entity.Zimu_setting;

import java.util.List;

import static io.github.biezhi.anima.Anima.*;

@Bean
public class IndexService {


    public void getSettings(Request request){
        /**
         * @Author: zimu
         * @Description: 获取引导页设置
         * @Date 22:29 2019-04-15
         * @Param [request]
         * @return void
         **/
        Zimu_setting settings = select().from(Zimu_setting.class).one();
        request.attribute("settings", settings);
    }

    public void getLinks(Request request, Response response,  String access_token) {
        /**
         * @Author: zimu
         * @Description: 根据access_token获取所有链接
         * @Date 23:30 2019-04-15
         * @Param [request, response, access_token]
         * @return void
         **/
        if (access_token.equals("")) {
            List<Zimu_link> links = select().from(Zimu_link.class).where("levelId", 0).all();
            request.attribute("links", links);
            return;
        }else {
            Zimu_level level = select("levelId")
                    .from(Zimu_level.class)
                    .where("levelAccessToken", access_token)
                    .one();
            if (level != null) {
                Integer level_id = level.getLevelId();
                List<Zimu_link> links = select().from(Zimu_link.class).lte("levelId", level_id).all();
                request.attribute("links", links);
                response.cookie("key", access_token, 604800);
            }else {
                List<Zimu_link> links = select().from(Zimu_link.class).where("levelId", 0).all();
                request.attribute("links", links);
            }
        }

    }

    public String handleParams(Request request) {
        /**
         * @Author: zimu
         * @Description: 处理请求参数与cookie中的key参数
         * @Date 23:30 2019-04-15
         * @Param [request]
         * @return java.lang.String
         **/
        String access_token = request.query("key", "");
        if(access_token.equals("")){
            access_token = request.cookie("key");
            if(access_token == null)
                access_token = "";
        }
        return access_token;
    }
}
