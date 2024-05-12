package com.hospital.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hospital.entity.po.Products;
import com.hospital.entity.vo.base.PageBase;
import lombok.Data;

import java.util.List;

/**
 * 医疗产品分页 返回对象
 *
*
 */
@Data
public class ProductsPageVo extends PageBase {

    /**
     * 医疗产品
     */
    private List<Products> products;

    /**
     * 填充分页信息
     *
     * @param iPage 分页对象
     */
    public void populatePage(IPage iPage) {
        super.populatePage(iPage);
        this.products = iPage.getRecords();
    }
}

  