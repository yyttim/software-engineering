package com.hospital.controller;

import com.hospital.entity.vo.QasPageVo;
import com.hospital.common.R;
import com.hospital.entity.po.Qas;
import com.hospital.service.QaService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("qa")
@RequiredArgsConstructor
public class QaController {

    private final QaService qaService;

    /**
     * 查询在线咨询 分页
     *
     * @param pageNum  分页页面
     * @param pageSize 分页大小
     * @param query    查询条件
     * @return 在线咨询
     */
    @RequestMapping("findAllQas")
    public R<QasPageVo> findQasPage(
            @RequestParam(value = "pageNumber") Integer pageNum,
            @RequestParam(value = "size") Integer pageSize,
            @RequestParam(value = "query") String query

    ) {
        return R.ok(qaService.findQasPage(pageNum, pageSize, query));
    }

    /**
     * 根据病患id查询在线咨询记录
     *
     * @param pId 病患id
     * @return 在线咨询记录
     */
    @RequestMapping("findQasByPid")
    public R<Qas> findQasByPid(@RequestParam(value = "pId") int pId) {
        return R.ok(qaService.findQasByPid(pId));
    }

    /**
     * 根据医生id查询在线咨询记录
     *
     * @param dId 医生id
     * @return 在线咨询记录
     */
    @RequestMapping("findQasByDid")
    public R<Qas> findQasByDid(@RequestParam(value = "dId") int dId) {
        return R.ok(qaService.findQasByDid(dId));
    }


    /**
     * 通过id查询在线咨询
     *
     * @param qaId 在线咨询id
     * @return 在线咨询
     */
    @RequestMapping("findQa")
    public R<Qas> findQa(Integer qaId) {
        return R.ok(qaService.findQa(qaId));
    }

    /**
     * 添加在线咨询
     *
     * @param qas 在线咨询
     * @return 结果
     */
    @RequestMapping("addQa")
    public R<Boolean> addQa(Qas qas) {
        if (BooleanUtils.isTrue(qaService.addQa(qas))) {
            return R.ok("增加在线咨询成功");
        }

        return R.error("增加在线咨询失败！账号或已被占用");
    }

    /**
     * 更新在线咨询
     *
     * @param qas 在线咨询信息
     * @return 结果
     */
    @RequestMapping("modifyQa")
    public R<Boolean> updateQa(Qas qas) {
        if (BooleanUtils.isTrue(qaService.updateQas(qas))) {
            return R.ok("修改在线咨询成功");
        }

        return R.error("修改在线咨询失败");
    }

    /**
     * 删除在线咨询
     *
     * @param qaId 在线咨询id
     * @return 结果
     */
    @RequestMapping("deleteQa")
    public R<Boolean> deleteQa(@RequestParam(value = "qaId") Integer qaId) {
        if (BooleanUtils.isTrue(qaService.deleteQas(qaId))) {
            return R.ok("删除在线咨询成功");
        }

        return R.error("删除在线咨询失败");
    }

}
