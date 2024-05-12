package com.hospital.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 检查项目
 *
*
 */
@Data
@TableName(value = "checks")
public class Checks {

    /**
     * 检查项目id
     */
    @TableId(value = "ch_id")
    @JsonProperty("chId")
    private int chId;

    /**
     * 检查项目名称
     */
    @JsonProperty("chName")
    private String chName;

    /**
     * 检查项目价格
     */
    @JsonProperty("chPrice")
    private Double chPrice;

}
