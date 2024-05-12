package com.hospital.service;

import com.hospital.entity.po.HealthDatas;
import com.hospital.entity.vo.HealthDatasPageVo;

import java.util.List;

public interface HealthService {

    /**
     * 查询健康数据 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 健康数据
     */
    HealthDatasPageVo findHealthDatasPage(Integer pageNum, Integer pageSize, String query);

    /**
     * 通过id查询健康数据
     *
     * @param hdId 健康数据id
     * @return 健康数据
     */
    HealthDatas findHealthData(Integer hdId);

    /**
     * 根据病患id查询健康数据
     *
     * @param pId 病患id
     * @return 健康数据
     */
    List<HealthDatas> findHealthDatasByPid(Integer pId);

    /**
     * 添加健康数据
     *
     * @param healthDatas 健康数据
     * @return 结果
     */
    Boolean addHealthData(HealthDatas healthDatas);

    /**
     * 删除健康数据
     *
     * @param hdId 健康数据id
     * @return 结果
     */
    Boolean deleteHealthDatas(Integer hdId);

    /**
     * 更新健康数据
     *
     * @param healthDatas 健康数据信息
     * @return 结果
     */
    Boolean updateHealthDatas(HealthDatas healthDatas);
}
