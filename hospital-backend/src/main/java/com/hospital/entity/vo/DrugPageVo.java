package com.hospital.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hospital.entity.po.Drug;
import lombok.Data;

import java.util.List;

@Data
public class DrugPageVo extends BedPageVo {

    /**
     * 药物数据
     */
    private List<Drug> drugs;

    /**
     * 填充分页信息
     *
     * @param iPage 分页对象
     */
    public void populatePage(IPage iPage) {
        super.populatePage(iPage);
        this.drugs = iPage.getRecords();
    }

}

  