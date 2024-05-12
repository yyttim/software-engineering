package com.hospital.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hospital.entity.po.Qas;
import com.hospital.entity.vo.base.PageBase;
import lombok.Data;

import java.util.List;

@Data
public class QasPageVo extends PageBase {

    /**
     * 在线咨询
     */
    private List<Qas> qas;

    /**
     * 填充分页信息
     *
     * @param iPage 分页对象
     */
    public void populatePage(IPage iPage) {
        super.populatePage(iPage);
        this.qas = iPage.getRecords();
    }
}

  