package com.hospital.controller;

import com.hospital.common.R;
import com.hospital.entity.po.HealthDatas;
import com.hospital.entity.po.Qas;
import com.hospital.entity.vo.HealthDatasPageVo;
import com.hospital.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    /**
     * 查询健康数据 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 健康数据
     */
    @RequestMapping("findAllHealthDatas")
    public R<HealthDatasPageVo> findHealthDatasPage(
            @RequestParam(value = "pageNumber") Integer pageNum,
            @RequestParam(value = "size") Integer pageSize,
            @RequestParam(value = "query") String query

    ) {
        return R.ok(healthService.findHealthDatasPage(pageNum, pageSize, query));
    }

    /**
     * 根据病患id查询健康数据
     *
     * @param pId 病患id
     * @return 健康数据
     */
    @RequestMapping("findHealthDatasByPid")
    public R<Qas> findQasByPid(@RequestParam(value = "pId") int pId) {
        return R.ok(healthService.findHealthDatasByPid(pId));
    }


    /**
     * 通过id查询健康数据
     *
     * @param hdId 健康数据id
     * @return 健康数据
     */
    @RequestMapping("findHealthData")
    public R<HealthDatas> findHealthData(Integer hdId) {
        return R.ok(healthService.findHealthData(hdId));
    }

    /**
     * 添加健康数据
     *
     * @param healthDatas 健康数据
     * @return 结果
     */
    @RequestMapping("addHealthData")
    public R<Boolean> addHealthData(HealthDatas healthDatas) {
        if (BooleanUtils.isTrue(healthService.addHealthData(healthDatas))) {
            return R.ok("增加健康数据成功");
        }

        return R.error("增加健康数据失败！账号或已被占用");
    }

    /**
     * 更新健康数据
     *
     * @param healthDatas 健康数据信息
     * @return 结果
     */
    @RequestMapping("modifyHealthData")
    public R<Boolean> updateHealthData(HealthDatas healthDatas) {
        if (BooleanUtils.isTrue(healthService.updateHealthDatas(healthDatas))) {
            return R.ok("修改健康数据成功");
        }

        return R.error("修改健康数据失败");
    }

    /**
     * 删除健康数据
     *
     * @param hdId 健康数据id
     * @return 结果
     */
    @RequestMapping("deleteHealthData")
    public R<Boolean> deleteHealthData(@RequestParam(value = "hdId") Integer hdId) {
        if (BooleanUtils.isTrue(healthService.deleteHealthDatas(hdId))) {
            return R.ok("删除健康数据成功");
        }

        return R.error("删除健康数据失败");
    }

}
