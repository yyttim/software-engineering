package com.hospital.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hospital.entity.po.HealthDatas;
import com.hospital.entity.vo.base.PageBase;
import lombok.Data;

import java.util.List;

@Data
public class HealthDatasPageVo extends PageBase {

    /**
     * 健康数据
     */
    private List<HealthDatas> healthDatas;

    /**
     * 填充分页信息
     *
     * @param iPage 分页对象
     */
    public void populatePage(IPage iPage) {
        super.populatePage(iPage);
        this.healthDatas = iPage.getRecords();
    }
}

  