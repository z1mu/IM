package com.zimu.IM.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.zimu.IM.service.IndexService;

/**
 * @Auther: zimu
 * @Date: 2019/4/15 11:02
 * @Description:
 */

@Path
public class IndexController {

    @Inject
    private IndexService indexService;

    @GetRoute("/")
    public String index(Request request, Response response){
        /**
         * @Author: zimu
         * @Description: 首页路由
         * @Date 23:40 2019-04-15
         * @Param [request, response]
         * @return java.lang.String
         **/
        String access_token = indexService.handleParams(request);
        indexService.getSettings(request);
        indexService.getLinks(request,response, access_token);
        return "index";
    }

}
