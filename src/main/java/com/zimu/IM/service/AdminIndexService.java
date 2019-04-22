package com.zimu.IM.service;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.http.Request;
import com.zimu.IM.entity.Zimu_admin;
import com.zimu.IM.entity.Zimu_level;
import com.zimu.IM.entity.Zimu_link;
import com.zimu.IM.entity.Zimu_log;
import com.zimu.IM.utils.Md5;
import com.zimu.IM.utils.TimeTools;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.List;
import java.util.Properties;

import static io.github.biezhi.anima.Anima.select;

/**
 * @author zimu
 * @title: AdminIndexService
 * @projectName IM
 * @description: TODO
 * @date 2019-04-2013:41
 */

@Bean
public class AdminIndexService {

    @Inject
    private TimeTools timeTools;

    @Inject
    private Md5 md5;

    public void admin_welcome(Request request) {
        Integer log_count = 0;
        String ip = null;
        String service = null;
        String enviroment = null;
        String jdk = null;
        String mysql = null;
        String currntTime = timeTools.currentDataTime().substring(0,10);
        List<Zimu_log> logs = select().from(Zimu_log.class).all();
        for (Zimu_log log : logs) {
            if(log.getReqTime().compareTo(currntTime) > 0)
                log_count++;
        }

        Integer leveMax = select().bySQL(Integer.class,"SELECT MAX(levelId) FROM zimu_level").one();

        long userCount = select().from(Zimu_admin.class).count();

        long logSum = select().from(Zimu_log.class).count();

        mysql = select().bySQL(String.class,"SELECT VERSION()").one();
        try {
            InetAddress address = Inet4Address.getLocalHost();
            Properties properties = System.getProperties();
            ip = address.getHostAddress();
            service = properties.getProperty("os.name");
            jdk = properties.getProperty("java.version");

        }catch (Exception e){

        }

        request.attribute("user", request.session().attribute("user"));
        request.attribute("currentTime", timeTools.currentDataTime());
        request.attribute("logCount", log_count);
        request.attribute("levelMax", leveMax);
        request.attribute("userCount", userCount);
        request.attribute("logSum", logSum);
        request.attribute("ip", ip);
        request.attribute("service", service);
        request.attribute("jdk", jdk);
        request.attribute("mysql", mysql);
    }

    public void addIndex(Request request) {
        List<Zimu_level> levels = select().from(Zimu_level.class).all();
        request.attribute("levels", levels);
    }

    public void doAddIndex(String url, String urlName, Integer level_id){
        Zimu_link link = new Zimu_link();
        link.setLink(url);
        link.setLinkName(urlName);
        link.setLevelId(level_id);
        link.save();
    }


    public void doAddToken(Integer level_id, String token) {
        Zimu_level level = new Zimu_level();
        level.setLevelAccessToken(token);
        level.setLevelId(level_id);
        level.save();
    }

    public void doAddUser(String username, String password) {
        Zimu_admin zimu_admin = select().from(Zimu_admin.class).where("username", username).one();
        if (zimu_admin != null) {
            return;
        }
        String salt = md5.getRandomString(6);
        password = md5.getMd5(password + salt);
        Zimu_admin admin = new Zimu_admin();
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setSalt(salt);
        admin.save();
    }

    public Boolean updateUser(Request request, String oldpassword, String password) {
        String username = request.session().attribute("user");
        Zimu_admin admin = select().from(Zimu_admin.class).where("username", username).one();
        if (admin != null) {
            oldpassword = md5.getMd5(oldpassword + admin.getSalt()).toLowerCase();
            if (oldpassword.equals(admin.getPassword().toLowerCase())) {
                password = md5.getMd5(password + admin.getSalt());
                admin.setPassword(password);
                admin.update();
                return true;
            }
        }
        return false;
    }
}
