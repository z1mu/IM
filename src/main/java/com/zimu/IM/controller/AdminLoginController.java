package com.zimu.IM.controller;

import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.zimu.IM.service.AdminLoginService;

/**
 * @author zimu
 * @title: AdminLoginController
 * @projectName IM
 * @description: TODO
 * @date 2019-04-1621:15
 */

@Path("/zimu")
public class AdminLoginController {

    private String  path = "zimu/";

    @Inject
    private AdminLoginService   loginService;

    @GetRoute("/login")
    public String showLogin(Request request, Response response){
        loginService.getImgCode(request, response);
        return this.path + "login";
    }

    @GetRoute("/getImgCode")
    @JSON
    public String getImgCode(Request request, Response response){
        return loginService.getImgCode(request, response);
    }

    @PostRoute("/login")
    @JSON
    public JSONObject login(Request request, Response response, @Param String username, @Param String password,  @Param String imgCode) {
        JSONObject res = new JSONObject();
        if (loginService.handleLogin(request, response, username,password, imgCode)){
            res.put("status", 1);
            res.put("msg", "登录成功!");
            request.session().attribute("user", username);
            return res;
        }
        else{
            res.put("status", 0);
            res.put("msg", "登录失败！");
            return res;
        }
    }
}
