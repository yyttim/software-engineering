package com.hospital.service;

import com.hospital.entity.po.Products;
import com.hospital.entity.vo.ProductsPageVo;

/**
 * 医疗产品 服务层
 *
*
 */
public interface ProductService {

    /**
     * 查询医疗产品 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 医疗产品
     */
    ProductsPageVo findProductsPage(Integer pageNum, Integer pageSize, String query);

    /**
     * 通过id查询医疗产品
     *
     * @param productId 医疗产品id
     * @return 医疗产品
     */
    Products findProduct(Integer productId);

    /**
     * 添加医疗产品
     *
     * @param products 医疗产品
     * @return 结果
     */
    Boolean addProduct(Products products);

    /**
     * 删除医疗产品
     *
     * @param productId 医疗产品id
     * @return 结果
     */
    Boolean deleteProducts(Integer productId);

    /**
     * 更新医疗产品
     *
     * @param products 医疗产品信息
     * @return 结果
     */
    Boolean updateProducts(Products products);
}
