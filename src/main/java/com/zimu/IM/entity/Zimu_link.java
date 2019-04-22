package com.zimu.IM.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Data
@Table(name = "zimu_link", pk = "id")
public class Zimu_link extends Model {

    @Column(name = "id")
    private Integer id;
    @Column(name = "link")
    private String  link;
    @Column(name = "linkName")
    private String  linkName;
    @Column(name = "levelId")
    private Integer levelId;
}
