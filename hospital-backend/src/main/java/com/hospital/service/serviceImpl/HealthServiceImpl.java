package com.hospital.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.entity.po.HealthDatas;
import com.hospital.entity.vo.HealthDatasPageVo;
import com.hospital.mapper.HealthDataMapper;
import com.hospital.service.HealthService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HealthService")
public class HealthServiceImpl extends ServiceImpl<HealthDataMapper, HealthDatas> implements HealthService {

    /**
     * 查询健康数据 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 健康数据
     */
    @Override
    public HealthDatasPageVo findHealthDatasPage(Integer pageNum, Integer pageSize, String query) {
        //分页条件
        Page<HealthDatas> page = new Page<>(pageNum, pageSize);

        //查询条件
        LambdaQueryWrapper<HealthDatas> lambdaQuery = Wrappers.<HealthDatas>lambdaQuery()
                .like(HealthDatas::getHdDate, query);

        //分页查询
        IPage<HealthDatas> iPage = this.page(page, lambdaQuery);

        //组装结果
        HealthDatasPageVo pageVo = new HealthDatasPageVo();
        pageVo.populatePage(iPage);

        return pageVo;
    }

    /**
     * 通过id查询健康数据
     *
     * @param hdId 健康数据id
     * @return 健康数据
     */
    @Override
    public HealthDatas findHealthData(Integer hdId) {
        return this.getById(hdId);
    }

    /**
     * 根据病患id查询健康数据
     *
     * @param pId 病患id
     * @return 健康数据
     */
    public List<HealthDatas> findHealthDatasByPid(Integer pId) {
        return lambdaQuery().eq(HealthDatas::getPId, pId).list();
    }

    /**
     * 添加健康数据
     *
     * @param healthDatas 健康数据
     * @return 结果
     */
    @Override
    public Boolean addHealthData(HealthDatas healthDatas) {
        //查询是否存在检测项目
        HealthDatas existHealthDatas = this.getById(healthDatas.getHdId());

        //已经存在健康数据，返回false
        if (existHealthDatas != null) {
            return Boolean.FALSE;
        }

        return this.save(healthDatas);
    }

    /**
     * 删除健康数据
     *
     * @param hdId 健康数据id
     * @return 结果
     */
    @Override
    public Boolean deleteHealthDatas(Integer hdId) {
        return this.removeById(hdId);
    }

    /**
     * 更新健康数据
     *
     * @param healthDatas 健康数据信息
     * @return 结果
     */
    @Override
    public Boolean updateHealthDatas(HealthDatas healthDatas) {
        return this.updateById(healthDatas);
    }

}
