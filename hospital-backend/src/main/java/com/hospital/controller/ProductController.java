package com.hospital.controller;

import com.hospital.common.R;
import com.hospital.entity.po.Products;
import com.hospital.entity.vo.ProductsPageVo;
import com.hospital.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 医疗产品 控制层
 *
*
 */
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * 查询医疗产品 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 医疗产品
     */
    @RequestMapping("findAllProducts")
    public R<ProductsPageVo> findProductsPage(
            @RequestParam(value = "pageNumber") Integer pageNum,
            @RequestParam(value = "size") Integer pageSize,
            @RequestParam(value = "query") String query

    ) {
        return R.ok(productService.findProductsPage(pageNum, pageSize, query));
    }

    /**
     * 通过id查询医疗产品
     *
     * @param productId 医疗产品id
     * @return 医疗产品
     */
    @RequestMapping("findProduct")
    public R<Products> findProduct(Integer productId) {
        return R.ok(productService.findProduct(productId));
    }

    /**
     * 添加医疗产品
     *
     * @param products 医疗产品
     * @return 结果
     */
    @RequestMapping("addProduct")
    public R<Boolean> addProduct(Products products) {
        if (BooleanUtils.isTrue(productService.addProduct(products))) {
            return R.ok("增加医疗产品成功");
        }

        return R.error("增加医疗产品失败！账号或已被占用");
    }

    /**
     * 更新医疗产品
     *
     * @param products 医疗产品信息
     * @return 结果
     */
    @RequestMapping("modifyProduct")
    public R<Boolean> updateProduct(Products products) {
        if (BooleanUtils.isTrue(productService.updateProducts(products))) {
            return R.ok("修改医疗产品成功");
        }

        return R.error("修改医疗产品失败");
    }

    /**
     * 删除医疗产品
     *
     * @param productId 医疗产品id
     * @return 结果
     */
    @RequestMapping("deleteProduct")
    public R<Boolean> deleteProduct(@RequestParam(value = "productId") Integer productId) {
        if (BooleanUtils.isTrue(productService.deleteProducts(productId))) {
            return R.ok("删除医疗产品成功");
        }

        return R.error("删除医疗产品失败");
    }

}
