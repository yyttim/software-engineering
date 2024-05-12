package com.hospital.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.entity.po.Diseases;
import com.hospital.mapper.DiseaseMapper;
import com.hospital.service.DiseaseService;
import com.hospital.entity.vo.DiseasesPageVo;
import org.springframework.stereotype.Service;

/**
 * 疾病 服务层
 *
*
 */
@Service("DiseaseService")
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Diseases> implements DiseaseService {

    /**
     * 查询疾病 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 疾病
     */
    @Override
    public DiseasesPageVo findDiseasesPage(Integer pageNum, Integer pageSize, String query) {
        //分页条件
        Page<Diseases> page = new Page<>(pageNum, pageSize);

        //查询条件
        LambdaQueryWrapper<Diseases> lambdaQuery = Wrappers.<Diseases>lambdaQuery()
                .like(Diseases::getDeName, query);

        //分页查询
        IPage<Diseases> iPage = this.page(page, lambdaQuery);

        //组装结果
        DiseasesPageVo pageVo = new DiseasesPageVo();
        pageVo.populatePage(iPage);

        return pageVo;
    }

    /**
     * 通过id查询疾病
     *
     * @param deId 疾病id
     * @return 疾病
     */
    @Override
    public Diseases findDisease(Integer deId) {
        return this.getById(deId);
    }

    /**
     * 添加疾病
     *
     * @param diseases 疾病
     * @return 结果
     */
    @Override
    public Boolean addDisease(Diseases diseases) {
        //查询是否存在疾病
        Diseases existDiseases = this.getById(diseases.getDeId());

        //已经存在疾病，返回false
        if (existDiseases != null) {
            return Boolean.FALSE;
        }

        return this.save(diseases);
    }

    /**
     * 删除疾病
     *
     * @param deId 疾病id
     * @return 结果
     */
    @Override
    public Boolean deleteDiseases(Integer deId) {
        return this.removeById(deId);
    }

    /**
     * 更新疾病
     *
     * @param diseases 疾病信息
     * @return 结果
     */
    @Override
    public Boolean updateDiseases(Diseases diseases) {
        return this.updateById(diseases);
    }

}
