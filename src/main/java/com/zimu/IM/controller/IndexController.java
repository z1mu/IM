package com.zimu.IM.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;

/**
 * @Auther: zimu
 * @Date: 2019/4/15 11:02
 * @Description:
 */

@Path
public class IndexController {

    @GetRoute("/")
    public String index(Request request){
        request.attribute("name", "zimu");
        return "index";
    }
}
