package com.hospital.service;

import com.hospital.entity.vo.QasPageVo;
import com.hospital.entity.po.Qas;

import java.util.List;

public interface QaService {

    /**
     * 查询在线咨询 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 在线咨询
     */
    QasPageVo findQasPage(Integer pageNum, Integer pageSize, String query);


    /**
     * 根据病患id查询在线咨询记录
     *
     * @param pId 病患id
     * @return 在线咨询记录
     */
    List<Qas> findQasByPid(Integer pId);

    /**
     * 根据医生id查询在线咨询记录
     *
     * @param dId 医生id
     * @return 在线咨询记录
     */
    List<Qas> findQasByDid(Integer dId);

    /**
     * 通过id查询在线咨询
     *
     * @param qaId 在线咨询id
     * @return 在线咨询
     */
    Qas findQa(Integer qaId);

    /**
     * 添加在线咨询
     *
     * @param qas 在线咨询
     * @return 结果
     */
    Boolean addQa(Qas qas);

    /**
     * 删除在线咨询
     *
     * @param qaId 在线咨询id
     * @return 结果
     */
    Boolean deleteQas(Integer qaId);

    /**
     * 更新在线咨询
     *
     * @param qas 在线咨询信息
     * @return 结果
     */
    Boolean updateQas(Qas qas);
}
