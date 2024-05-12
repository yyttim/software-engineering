package com.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.entity.po.Products;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医疗产品 持久层（mapper）
 *
*
 */
@Mapper
public interface ProductMapper extends BaseMapper<Products> {

}
