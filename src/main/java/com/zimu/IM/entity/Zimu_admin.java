package com.zimu.IM.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

/**
 * @author zimu
 * @title: Zimu_admin
 * @projectName IM
 * @description: TODO
 * @date 2019-04-1721:43
 */

@Data
@Table(name = "zimu_admin", pk = "id")
public class Zimu_admin extends Model {

    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String  username;
    @Column(name = "password")
    private String  password;
    @Column(name = "salt")
    private String  salt;
}
