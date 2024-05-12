package com.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.entity.po.HealthDatas;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthDataMapper extends BaseMapper<HealthDatas> {

}
