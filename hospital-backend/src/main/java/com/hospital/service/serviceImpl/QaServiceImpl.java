package com.hospital.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hospital.entity.po.Qas;
import com.hospital.entity.vo.QasPageVo;
import com.hospital.service.QaService;
import com.hospital.mapper.QaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("QaService")
public class QaServiceImpl extends ServiceImpl<QaMapper, Qas> implements QaService {

    /**
     * 查询在线咨询 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 在线咨询
     */
    @Override
    public QasPageVo findQasPage(Integer pageNum, Integer pageSize, String query) {
        //分页条件
        Page<Qas> page = new Page<>(pageNum, pageSize);

        //查询条件
        LambdaQueryWrapper<Qas> lambdaQuery = Wrappers.<Qas>lambdaQuery()
                .like(Qas::getQaTitle, query);

        //分页查询
        IPage<Qas> iPage = this.page(page, lambdaQuery);

        //组装结果
        QasPageVo pageVo = new QasPageVo();
        pageVo.populatePage(iPage);

        return pageVo;
    }


    /**
     * 根据病患id查询在线咨询记录
     *
     * @param pId 病患id
     * @return 在线咨询记录
     */
    public List<Qas> findQasByPid(Integer pId) {
        return lambdaQuery().eq(Qas::getPId, pId).list();
    }

    /**
     * 根据医生id查询在线咨询记录
     *
     * @param dId 病患id
     * @return 在线咨询记录
     */
    public List<Qas> findQasByDid(Integer dId) {
        return lambdaQuery().eq(Qas::getDId, dId).or().eq(Qas::getDId, -1).list();
    }

    /**
     * 通过id查询在线咨询
     *
     * @param qaId 在线咨询id
     * @return 在线咨询
     */
    @Override
    public Qas findQa(Integer qaId) {
        return this.getById(qaId);
    }

    /**
     * 添加在线咨询
     *
     * @param qas 在线咨询
     * @return 结果
     */
    @Override
    public Boolean addQa(Qas qas) {
        //查询是否存在检测项目
        Qas existQas = this.getById(qas.getQaId());

        //已经存在在线咨询，返回false
        if (existQas != null) {
            return Boolean.FALSE;
        }

        return this.save(qas);
    }

    /**
     * 删除在线咨询
     *
     * @param qaId 在线咨询id
     * @return 结果
     */
    @Override
    public Boolean deleteQas(Integer qaId) {
        return this.removeById(qaId);
    }

    /**
     * 更新在线咨询
     *
     * @param qas 在线咨询信息
     * @return 结果
     */
    @Override
    public Boolean updateQas(Qas qas) {
        return this.updateById(qas);
    }

}
