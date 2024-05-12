package com.hospital.controller;

import com.hospital.entity.po.Diseases;
import com.hospital.service.DiseaseService;
import com.hospital.common.R;
import com.hospital.entity.vo.DiseasesPageVo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 疾病 控制层
 */
@RestController
@RequestMapping("disease")
@RequiredArgsConstructor
public class DiseaseController {

    private final DiseaseService diseaseService;

    /**
     * 查询疾病 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 疾病
     */
    @RequestMapping("findAllDiseases")
    public R<DiseasesPageVo> findDiseasesPage(
            @RequestParam(value = "pageNumber") Integer pageNum,
            @RequestParam(value = "size") Integer pageSize,
            @RequestParam(value = "query") String query

    ) {
        return R.ok(diseaseService.findDiseasesPage(pageNum, pageSize, query));
    }

    /**
     * 通过id查询疾病
     *
     * @param deId 疾病id
     * @return 疾病
     */
    @RequestMapping("findDisease")
    public R<Diseases> findDisease(Integer deId) {
        return R.ok(diseaseService.findDisease(deId));
    }

    /**
     * 添加疾病
     *
     * @param diseases 疾病
     * @return 结果
     */
    @RequestMapping("addDisease")
    public R<Boolean> addDisease(Diseases diseases) {
        if (BooleanUtils.isTrue(diseaseService.addDisease(diseases))) {
            return R.ok("增加疾病成功");
        }

        return R.error("增加疾病失败！账号或已被占用");
    }

    /**
     * 更新疾病
     *
     * @param diseases 疾病信息
     * @return 结果
     */
    @RequestMapping("modifyDisease")
    public R<Boolean> updateDisease(Diseases diseases) {
        if (BooleanUtils.isTrue(diseaseService.updateDiseases(diseases))) {
            return R.ok("修改疾病成功");
        }

        return R.error("修改疾病失败");
    }

    /**
     * 删除疾病
     *
     * @param deId 疾病id
     * @return 结果
     */
    @RequestMapping("deleteDisease")
    public R<Boolean> deleteDisease(@RequestParam(value = "deId") Integer deId) {
        if (BooleanUtils.isTrue(diseaseService.deleteDiseases(deId))) {
            return R.ok("删除疾病成功");
        }

        return R.error("删除疾病失败");
    }

}
