package com.zimu.IM.service;

import com.alibaba.fastjson.JSONObject;
import com.blade.ioc.annotation.Bean;
import com.blade.mvc.http.Request;
import com.zimu.IM.entity.*;
import io.github.biezhi.anima.Anima;
import io.github.biezhi.anima.page.Page;

import java.util.ArrayList;
import java.util.List;

import static io.github.biezhi.anima.Anima.select;

/**
 * @author zimu
 * @title: AdminService
 * @projectName IM
 * @description: TODO
 * @date 2019-04-2021:26
 */

@Bean
public class AdminService {

    public void getLinks(Request request) {
        List<Zimu_link> links = select().from(Zimu_link.class).all();
        request.attribute("links", links);
    }

    public void delLink(Integer id) {
        Zimu_link link = new Zimu_link();
        link.setId(id);
        link.delete();
    }

    public void getLinkById(Request request, Integer id) {
        Zimu_link link = select().from(Zimu_link.class).where("id", id).one();
        List<Zimu_level> levels = select().from(Zimu_level.class).all();
        request.attribute("link", link);
        request.attribute("levels", levels);
    }

    public void editorLink(Integer id, String url, String urlName, Integer level) {
        Zimu_link link = new Zimu_link();
        link.setId(id);
        link.setLevelId(level);
        link.setLink(url);
        link.setLinkName(urlName);
        link.update();
    }

    public void getLevels(Request request) {
        List<Zimu_level> levels = select().from(Zimu_level.class).all();
        request.attribute("levels", levels);
    }

    public void delLevel(Integer id, String token) {
        Zimu_level level = new Zimu_level();
        level.setLevelId(id);
        level.setLevelAccessToken(token);
        level.delete();
    }

    public void getAdminList(Request request) {
        List<Zimu_admin> admins = select().from(Zimu_admin.class).all();
        request.attribute("admins", admins);
    }

    public void delAdmin(Integer id) {
        Zimu_admin admin = new Zimu_admin();
        admin.setId(id);
        admin.delete();
    }

    public void getSetting(Request request) {
        Zimu_setting setting = select().from(Zimu_setting.class).one();
        request.attribute("setting", setting);
    }

    public void getTableInfo(Request request) {
        List<String> lists= select().bySQL(String.class, "show tables").all();
        List<DBS> dbsList = new ArrayList<DBS>();
        for (String list : lists) {
            Integer count = select().bySQL(Integer.class, "select count(*) from "+list).one();
            DBS dbs = new DBS();
            dbs.setDbname(list);
            dbs.setCount(count);
            dbsList.add(dbs);
        }
        request.attribute("dbs", dbsList);

    }

    public void delData(String table, String number) {
        int flag = Anima.execute("DELETE FROM "+table+" LIMIT ?",number);
    }

    public void getRecords(Request request, Integer page) {
        Page<Zimu_log> logs = select().from(Zimu_log.class).order("id desc").page(page, 10);
        for (int i=0; i< logs.getRows().size(); i++) {
            try {
                JSONObject object = (JSONObject) JSONObject.parse(logs.getRows().get(i).getReqIpAdress());
                if (object.get("city").toString().equals("[]"))
                    logs.getRows().get(i).setReqIpAdress("未查到该IP！");
                else
                    logs.getRows().get(i).setReqIpAdress(object.get("city").toString());
            } catch (Exception e) {
                logs.getRows().get(i).setReqIpAdress("未查到该IP！");
            }
        }
        request.attribute("logs", logs);
    }

    public void saveSetting(String title, String description, String keywords, String domain, String sign, String footer_name, String footer_link, String footer_link_name) {
        Zimu_setting setting = new Zimu_setting();
        setting.setTitle(title);
        setting.setDescription(description);
        setting.setKeywords(keywords);
        setting.setDomain(domain);
        setting.setSign(sign);
        setting.setFooterName(footer_name);
        setting.setFooterLink(footer_link);
        setting.setFooterLinkName(footer_link_name);
        setting.save();
    }
}
