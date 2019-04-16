package com.zimu.IM.service;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.zimu.IM.utils.IMGCode;


/**
 * @author zimu
 * @title: AdminLoginService
 * @projectName IM
 * @description: TODO
 * @date 2019-04-1621:51
 */

@Bean
public class AdminLoginService {

    @Inject
    private IMGCode imgCode;

    public String getImgCode(Request request, Response response) {
        String IMGCode = imgCode.getBase64Img(request, response);
        return IMGCode;
    }

}
