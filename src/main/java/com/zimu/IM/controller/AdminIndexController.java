package com.zimu.IM.controller;

import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.zimu.IM.service.AdminIndexService;

/**
 * @author zimu
 * @title: AdminIndexController
 * @projectName IM
 * @description: TODO
 * @date 2019-04-2011:42
 */

@Path(value = "/zimu/")
public class AdminIndexController {

    @Inject
    private AdminIndexService indexService;

    private String path = "zimu/";
    private String htmlPath = "zimu/html/";

    @GetRoute("index")
    public String admin_index(Request request){
        request.attribute("user", request.session().attribute("user"));
        return path + "index";
    }

    @GetRoute("welcome")
    public String admin_welcome(Request request) {
        indexService.admin_welcome(request);
        return htmlPath + "welcome";
    }

    @GetRoute("addIndex")
    public String addIndex(Request request) {
        indexService.addIndex(request);
        return htmlPath + "addLink";
    }

    @PostRoute("doAddIndex")
    @JSON
    public JSONObject doAddIndex(@Param String url, @Param String urlName, @Param Integer level) {
        JSONObject object = new JSONObject();
        if (url == null || urlName == null || level == null || url.equals("") || urlName.equals("")  ){
            object.put("status", 0);
            object.put("msg", "参数有误！");
            return object;
        }else {
            indexService.doAddIndex(url, urlName, level);
            object.put("status", 1);
            object.put("msg", "保存成功！");
            return object;
        }
    }

    @GetRoute("addToken")
    public String addToken(Request request){
        indexService.addIndex(request);
        return htmlPath + "addToken";
    }

    @PostRoute("doAddToken")
    @JSON
    public JSONObject doAddToken(@Param Integer levelid, @Param String token) {
        JSONObject object = new JSONObject();
        if (levelid == null || token == null || token.equals("ImgCode")) {
            object.put("status", 0);
            object.put("msg", "参数有误！");
            return object;
        } else {
            indexService.doAddToken(levelid, token);
            object.put("status", 1);
            object.put("msg", "保存成功！");
            return object;
        }
    }

    @GetRoute("addUser")
    public String addUser(Request request) {
        return htmlPath + "addUser";
    }

    @PostRoute("doAddUser")
    @JSON
    public JSONObject doAddUser(@Param String username, @Param String password){
        JSONObject object = new JSONObject();
        if (username == null || password == null || username.equals("") || password.equals("")) {
            object.put("status", 0);
            object.put("msg", "参数有误！");
            return object;
        } else {
            indexService.doAddUser(username, password);
            object.put("status", 1);
            object.put("msg", "保存成功！");
            return object;
        }
    }

    @GetRoute("userInfo")
    public String userInfo(Request request) {
        request.attribute("user", request.session().attribute("user"));
        return htmlPath + "userInfo";
    }

    @PostRoute("updateUser")
    @JSON
    public JSONObject updateUser(Request request, @Param String oldpassword, @Param String password) {
        JSONObject object = new JSONObject();
        if (oldpassword == null || password == null || oldpassword.equals("") || password.equals("")) {
            object.put("status", 0);
            object.put("msg", "参数有误！");
            return object;
        }else {
            if (indexService.updateUser(request, oldpassword, password)){
                object.put("status", 1);
                object.put("msg", "更新成功！");
                return object;
            }else {
                object.put("status", 0);
                object.put("msg", "更新失败！");
                return object;
            }

        }
    }

    @GetRoute("logout")
    public void logout(Request request, Response response) {
        request.session().attribute("user", "");
        response.redirect("login");
    }


}
