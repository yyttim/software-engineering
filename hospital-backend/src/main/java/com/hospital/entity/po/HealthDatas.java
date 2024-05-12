package com.hospital.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName(value = "healthDatas")
public class HealthDatas {

    /**
     * 健康数据id
     */
    @TableId(value = "hd_id")
    @JsonProperty("hdId")
    private int hdId;


    /**
     * 健康数据身高
     */
    @JsonProperty("hdHeight")
    private int hdHeight;


    /**
     *  健康数据体重
     */
    @JsonProperty("hdWeight")
    private float hdWeight;

    /**
     *  健康数据体温
     */
    @JsonProperty("hdTemperature")
    private float hdTemperature;


    /**
     *  健康数据建议
     */
    @JsonProperty("hdAdvise")
    private String hdAdvise;

    /**
     * 健康数据日期
     */
    @JsonProperty("hdDate")
    private String hdDate;

    /**
     * 病患id
     */
    @JsonProperty("pId")
    private int pId;

}
