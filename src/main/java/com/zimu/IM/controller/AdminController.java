package com.zimu.IM.controller;

import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Request;
import com.zimu.IM.service.AdminService;

/**
 * @author zimu
 * @title: AdminController
 * @projectName IM
 * @description: TODO
 * @date 2019-04-2020:55
 */

@Path("/zimu/")
public class AdminController {

    private String path = "zimu/html/";

    @Inject
    private AdminService adminService;

    @GetRoute("links")
    public String links(Request request){
        adminService.getLinks(request);
        return path + "links";
    }

    @PostRoute("delLink")
    @JSON
    public JSONObject delLink(@Param Integer id) {
        JSONObject object = new JSONObject();
        if (id != null) {
            adminService.delLink(id);
            object.put("status", 1);
            object.put("msg", "删除成功！");
            return object;
        }else {
            object.put("status", 0);
            object.put("msg", "删除失败！");
            return object;
        }
    }

    @GetRoute("editorLink")
    public String editorLink(Request request, @Param Integer id) {
        adminService.getLinkById(request, id);
        return path + "editorLink";
    }

    @PostRoute("doEditorLink")
    @JSON
    public JSONObject doEditorLink(@Param Integer id, @Param String url, @Param String urlName, @Param Integer level) {
        JSONObject object = new JSONObject();
        if (id == null || url == null || urlName == null || level == null || url.equals("") || urlName.equals("")) {
            object.put("status", 0);
            object.put("msg", "参数有误！");
            return object;
        }else {
            adminService.editorLink(id, url, urlName, level);
            object.put("status", 1);
            object.put("msg", "修改成功！");
            return object;
        }
    }

    @GetRoute("levels")
    public String tokens(Request request) {
        adminService.getLevels(request);
        return path + "tokens";
    }

    @PostRoute("delLevel")
    @JSON
    public JSONObject delLevel(@Param Integer id, @Param String token) {
        JSONObject object = new JSONObject();
        if (id == null || token == null || token.equals("")) {
            object.put("status", 0);
            object.put("msg", "参数有误！");
            return object;
        }else {
            adminService.delLevel(id, token);
            object.put("status", 1);
            object.put("msg", "修改成功！");
            return object;
        }
    }

    @GetRoute("editorLevel")
    public String editorLevel(Request request, @Param Integer level_id, @Param String level_access_token) {
        request.attribute("level_id", level_id);
        request.attribute("level_access_token", level_access_token);
        return path + "editorLevel";
    }

    @GetRoute("adminList")
    public String adminList(Request request) {
        adminService.getAdminList(request);
        return path + "admin-list";

    }

    @PostRoute("delAdmin")
    @JSON
    public JSONObject delAdmin(@Param Integer id) {
        JSONObject object = new JSONObject();
        if (id == null || id == 0) {
            object.put("status", 0);
            object.put("msg", "参数有误！");
            return object;
        }else {
            adminService.delAdmin(id);
            object.put("status", 1);
            object.put("msg", "删除成功！");
            return object;
        }

    }

    @GetRoute("setting")
    public String setting(Request request) {
        adminService.getSetting(request);
        return path + "setting";
    }

    @GetRoute("clearData")
    public String clearData(Request request) {
        adminService.getTableInfo(request);
        return path + "clearData";
    }

    @GetRoute("delData")
    public String delData(@Param String table, Request request) {
        request.attribute("table", table);
        return path + "delData";
    }

    @PostRoute("delTableData")
    @JSON
    public JSONObject delData(Request request, @Param String table, @Param String dataNumber) {
        JSONObject object = new JSONObject();
        if (table == null || table.equals("") ) {
            object.put("status", 0);
            object.put("msg", "参数有误！");
            return object;
        }else {
            adminService.delData(table, dataNumber);
            object.put("status", 1);
            object.put("msg", "删除成功！");
            return object;
        }
    }

    @GetRoute("records")
    public String records(Request request) {
        Integer page = request.queryInt("page", 1);
        adminService.getRecords(request, page);
        return path + "records";
    }

    @PostRoute("saveSetting")
    @JSON
    public JSONObject saveSetting(@Param String title, @Param String description, @Param String keywords, @Param String domain, @Param String sign, @Param String footer_name,
                                  @Param String footer_link, @Param String footer_link_name) {
        JSONObject object = new JSONObject();
        adminService.saveSetting(title, description, keywords, domain, sign, footer_name, footer_link, footer_link_name);
        object.put("status", 1);
        object.put("msg", "保存成功！");
        return object;

    }

}
