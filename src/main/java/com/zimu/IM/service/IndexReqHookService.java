package com.zimu.IM.service;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.RouteContext;
import com.zimu.IM.entity.Zimu_log;
import com.zimu.IM.utils.QueryTools;
import com.zimu.IM.utils.TimeTools;
import io.github.biezhi.anima.Anima;

/**
 * @author zimu
 * @title: IndexReqHookService
 * @projectName IM
 * @description: TODO
 * @date 2019-04-1619:38
 */

@Bean
public class IndexReqHookService {

    @Inject
    private TimeTools timeTools;

    @Inject
    private QueryTools  queryTools;

    public void handleLog(RouteContext routeContext){

        Zimu_log    log =   new Zimu_log();
        String req_ip = routeContext.remoteAddress();
        Integer flag    =   req_ip.indexOf(":");
        req_ip = req_ip.substring(0, flag);
        String  req_ua  =   routeContext.userAgent();
        String  req_access_token    =   routeContext.query("key", "");
        if (req_access_token.equals("")){
            req_access_token = routeContext.cookie("key");
            if (req_access_token == null)
                req_access_token = "";
        }
        String  req_link =   routeContext.uri();
        String  req_ip_adress   =   queryTools.queryIpAdress(req_ip);
        String  req_time    =   timeTools.currentDataTime();
        log.setReq_ip(req_ip);
        log.setReq_ua(req_ua);
        log.setReq_access_token(req_access_token);
        log.setReq_link(req_link);
        log.setReq_ip_adress(req_ip_adress);
        log.setReq_time(req_time);
        Integer id  =   log.save().asInt();
    }
}
