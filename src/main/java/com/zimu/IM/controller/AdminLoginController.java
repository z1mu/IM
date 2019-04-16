package com.zimu.IM.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;
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
}
