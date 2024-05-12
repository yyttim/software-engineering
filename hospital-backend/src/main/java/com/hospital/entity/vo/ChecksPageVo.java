package com.hospital.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hospital.entity.po.Checks;
import com.hospital.entity.vo.base.PageBase;
import lombok.Data;

import java.util.List;

/**
 * 检查项目分页 返回对象
 *
*
 */
@Data
public class ChecksPageVo extends PageBase {

    /**
     * 检查项目
     */
    private List<Checks> checks;

    /**
     * 填充分页信息
     *
     * @param iPage 分页对象
     */
    public void populatePage(IPage iPage) {
        super.populatePage(iPage);
        this.checks = iPage.getRecords();
    }
}

  