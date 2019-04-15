package com.zimu.IM.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Data
@Table(name = "zimu_link", pk = "id")
public class Zimu_link extends Model {

    private Integer id;
    private String  link;
    private String  link_name;
    private Integer level_id;
}
