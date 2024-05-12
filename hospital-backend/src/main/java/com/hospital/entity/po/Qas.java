package com.hospital.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName(value = "qas")
public class Qas {

    /**
     * 在线咨询id
     */
    @TableId(value = "qa_id")
    @JsonProperty("qaId")
    private int qaId;

    /**
     * 在线咨询标题
     */
    @JsonProperty("qaTitle")
    private String qaTitle;

    /**
     *  在线咨询记录
     */
    @JsonProperty("qaHistory")
    private String qaHistory;

    /**
     * 病患id
     */
    @JsonProperty("pId")
    private int pId;

    /**
     * 病患名称
     */
    @JsonProperty("pName")
    private String pName;

    /**
     * 医生id
     */
    @JsonProperty("dId")
    private int dId;

    /**
     * 医生名称
     */
    @JsonProperty("dName")
    private String dName;

}
