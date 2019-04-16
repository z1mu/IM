package com.zimu.IM.hooks;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.RouteContext;
import com.blade.mvc.hook.WebHook;
import com.zimu.IM.service.IndexReqHookService;

/**
 * @author zimu
 * @title: IndexReqHook
 * @projectName IM
 * @description: TODO
 * @date 2019-04-1619:29
 */

@Bean
public class IndexReqHook implements WebHook {

    @Inject
    private IndexReqHookService hookService;

    @Override
    public boolean before(RouteContext routeContext) {

        hookService.handleLog(routeContext);
        return true;
    }
}
