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

    @Column(name = "req_ip")
    private String  req_ip;

    @Column(name = "req_ua")
    private String  req_ua;

    @Column(name = "req_access_token")
    private String  req_access_token;

    @Column(name = "req_link")
    private String  req_link;

    @Column(name = "req_ip_adress")
    private String  req_ip_adress;

    @Column(name = "req_time")
    private String  req_time;
}
