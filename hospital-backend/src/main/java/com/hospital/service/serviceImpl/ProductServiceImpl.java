package com.hospital.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.entity.po.Products;
import com.hospital.service.ProductService;
import com.hospital.entity.vo.ProductsPageVo;
import com.hospital.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Products> implements ProductService {

    /**
     * 查询医疗产品 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 医疗产品
     */
    @Override
    public ProductsPageVo findProductsPage(Integer pageNum, Integer pageSize, String query) {
        //分页条件
        Page<Products> page = new Page<>(pageNum, pageSize);

        //查询条件
        LambdaQueryWrapper<Products> lambdaQuery = Wrappers.<Products>lambdaQuery()
                .like(Products::getProductName, query);

        //分页查询
        IPage<Products> iPage = this.page(page, lambdaQuery);

        //组装结果
        ProductsPageVo pageVo = new ProductsPageVo();
        pageVo.populatePage(iPage);

        return pageVo;
    }

    /**
     * 通过id查询医疗产品
     *
     * @param productId 医疗产品id
     * @return 医疗产品
     */
    @Override
    public Products findProduct(Integer productId) {
        return this.getById(productId);
    }

    /**
     * 添加医疗产品
     *
     * @param products 医疗产品
     * @return 结果
     */
    @Override
    public Boolean addProduct(Products products) {
        //查询是否存在检测项目
        Products existProducts = this.getById(products.getProductId());

        //已经存在医疗产品，返回false
        if (existProducts != null) {
            return Boolean.FALSE;
        }

        return this.save(products);
    }

    /**
     * 删除医疗产品
     *
     * @param productId 医疗产品id
     * @return 结果
     */
    @Override
    public Boolean deleteProducts(Integer productId) {
        return this.removeById(productId);
    }

    /**
     * 更新医疗产品
     *
     * @param products 医疗产品信息
     * @return 结果
     */
    @Override
    public Boolean updateProducts(Products products) {
        return this.updateById(products);
    }

}
