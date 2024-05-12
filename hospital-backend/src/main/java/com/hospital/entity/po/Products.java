package com.hospital.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 医疗产品
 *
*
 */
@Data
@TableName(value = "products")
public class Products {

    /**
     * 医疗产品id
     */
    @TableId(value = "product_id")
    @JsonProperty("productId")
    private int productId;

    /**
     * 医疗产品名称
     */
    @JsonProperty("productName")
    private String productName;

    /**
     *  医疗产品说明
     */
    @JsonProperty("productDescribe")
    private String productDescribe;

}
