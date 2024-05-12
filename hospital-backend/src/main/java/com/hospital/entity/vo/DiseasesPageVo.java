package com.hospital.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hospital.entity.po.Diseases;
import com.hospital.entity.vo.base.PageBase;
import lombok.Data;

import java.util.List;

/**
 * 疾病分页 返回对象
 *
*
 */
@Data
public class DiseasesPageVo extends PageBase {

    /**
     * 疾病
     */
    private List<Diseases> diseases;

    /**
     * 填充分页信息
     *
     * @param iPage 分页对象
     */
    public void populatePage(IPage iPage) {
        super.populatePage(iPage);
        this.diseases = iPage.getRecords();
    }
}

  