package com.zimu.IM.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

/**
 * @author zimu
 * @title: Zimu_level
 * @projectName IM
 * @description: 接入等级表
 * @date 2019-04-1522:39
 */

@Data
@Table(name = "zimu_level", pk = "id")
public class Zimu_level extends Model {

    private Integer level_id;
    private String  level_access_token;
}
