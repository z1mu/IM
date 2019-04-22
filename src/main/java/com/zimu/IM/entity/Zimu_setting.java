package com.zimu.IM.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Data
@Table(name = "zimu_setting")
public class Zimu_setting extends Model {

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "keywords")
    private String keywords;
    @Column(name = "domain")
    private String domain;
    @Column(name = "sign")
    private String sign;
    @Column(name = "head")
    private String head;
    @Column(name = "footerName")
    private String footerName;
    @Column(name = "footerLink")
    private String footerLink;
    @Column(name = "footerLinkName")
    private String footerLinkName;

}
