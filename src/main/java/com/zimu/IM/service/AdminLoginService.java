package com.zimu.IM.service;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.zimu.IM.entity.Zimu_admin;
import com.zimu.IM.utils.IMGCode;
import com.zimu.IM.utils.Md5;

import static io.github.biezhi.anima.Anima.*;


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


    @Inject
    private Md5 md5;

    public String getImgCode(Request request, Response response) {
        String IMGCode = imgCode.getBase64Img(request, response);
        return IMGCode;
    }

    public boolean handleLogin(Request request, Response response, String username, String password, String code) {
        if (imgCode.checkImgCode(request, code)){
            Zimu_admin admin = select().from(Zimu_admin.class).where("username", username).one();
            String salt = admin.getSalt();
            password = md5.getMd5(password + salt).toLowerCase();
            if (admin.getPassword().toLowerCase().equals(password))
                return true;
        }
        return false;
    }

}
