package com.zimu.IM.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Data
@Table(name = "zimu_setting")
public class Zimu_setting extends Model {

    private String title;
    private String description;
    private String keywords;
    private String domain;
    private String sign;
    private String head;
    private String footer_name;
    private String footer_link;
    private String footer_link_name;

}
