package com.hospital.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hospital.entity.po.Patient;
import com.hospital.entity.vo.base.PageBase;
import lombok.Data;

import java.util.List;

@Data
public class PatientPageVo extends PageBase {

    /**
     * 病人数据
     */
    private List<Patient> patients;

    /**
     * 填充分页信息
     *
     * @param iPage 分页对象
     */
    public void populatePage(IPage iPage) {
        super.populatePage(iPage);
        this.patients = iPage.getRecords();
    }

}

  