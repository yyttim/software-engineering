package com.hospital.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hospital.entity.po.Doctor;
import com.hospital.entity.vo.base.PageBase;
import lombok.Data;

import java.util.List;

@Data
public class DoctorPageVo extends PageBase {

    /**
     * 医生数据
     */
    private List<Doctor> doctors;

    /**
     * 填充分页信息
     *
     * @param iPage 分页对象
     */
    public void populatePage(IPage iPage) {
        super.populatePage(iPage);
        this.doctors = iPage.getRecords();
    }

}

  