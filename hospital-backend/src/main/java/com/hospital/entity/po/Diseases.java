package com.hospital.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 疾病
 *
*
 */
@Data
@TableName(value = "diseases")
public class Diseases {

    /**
     * 疾病id
     */
    @TableId(value = "de_id")
    @JsonProperty("deId")
    private int deId;

    /**
     * 疾病名称
     */
    @JsonProperty("deName")
    private String deName;

    /**
     * 疾病症状
     */
    @JsonProperty("deSymptom")
    private String deSymptom;

}
