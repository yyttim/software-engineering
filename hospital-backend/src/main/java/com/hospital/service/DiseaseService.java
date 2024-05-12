package com.hospital.service;

import com.hospital.entity.po.Diseases;
import com.hospital.entity.vo.DiseasesPageVo;

/**
 * 疾病 服务层
 *
*
 */
public interface DiseaseService {

    /**
     * 查询疾病 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 疾病
     */
    DiseasesPageVo findDiseasesPage(Integer pageNum, Integer pageSize, String query);

    /**
     * 通过id查询疾病
     *
     * @param deId 疾病id
     * @return 疾病
     */
    Diseases findDisease(Integer deId);

    /**
     * 添加疾病
     *
     * @param diseases 疾病
     * @return 结果
     */
    Boolean addDisease(Diseases diseases);

    /**
     * 删除疾病
     *
     * @param deId 疾病id
     * @return 结果
     */
    Boolean deleteDiseases(Integer deId);

    /**
     * 更新疾病
     *
     * @param diseases 疾病信息
     * @return 结果
     */
    Boolean updateDiseases(Diseases diseases);
}
