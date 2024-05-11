package com.hospital.service;

import com.hospital.entity.po.Patient;
import com.hospital.entity.vo.PatientPageVo;
import com.hospital.entity.vo.user.PatientUserVo;

import java.util.List;

public interface PatientUserService {

    /**
     * 病患登录
     *
     * @param pId       病患id（账号）
     * @param pPassword 密码
     * @return 病患信息
     */
    PatientUserVo login(Integer pId, String pPassword);

    /**
     * 查询患者信息 - 分页
     *
     * @param pageNum  分页页码
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 患者数据
     */
    PatientPageVo findPatientPage(Integer pageNum, Integer pageSize, String query);

    /**
     * 删除患者
     *
     * @param pId 账号id
     * @return 结果
     */
    Boolean deletePatient(int pId);

    /**
     * 查询患者信息
     *
     * @param pId 患者id
     * @return 患者信息
     */
    Patient findPatientById(Integer pId);

    /**
     * 添加病患
     *
     * @param patient 病患信息
     * @return 结果
     */
    Boolean addPatient(Patient patient);

    /**
     * 统计患者年龄分布
     *
     * @return 年龄分布
     */
    List<Integer> patientAge();
}
