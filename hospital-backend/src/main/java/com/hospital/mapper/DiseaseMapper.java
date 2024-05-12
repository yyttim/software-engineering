package com.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.entity.po.Diseases;
import org.apache.ibatis.annotations.Mapper;

/**
 * 疾病 持久层（mapper）
 *

 */
@Mapper
public interface DiseaseMapper extends BaseMapper<Diseases> {

}
