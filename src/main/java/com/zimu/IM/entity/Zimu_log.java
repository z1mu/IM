package com.zimu.IM.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

/**
 * @author zimu
 * @title: Zimu_log
 * @projectName IM
 * @description: TODO
 * @date 2019-04-1620:37
 */
@Data
@Table(name = "zimu_log", pk = "id")
public class Zimu_log extends Model {

    @Column(name = "id")
    private Integer id;

    @Column(name = "reqIp")
    private String  reqIp;

    @Column(name = "reqUa")
    private String  reqUa;

    @Column(name = "reqAccessToken")
    private String  reqAccessToken;

    @Column(name = "reqLink")
    private String  reqLink;

    @Column(name = "reqIpAdress")
    private String  reqIpAdress;

    @Column(name = "reqTime")
    private String  reqTime;
}
