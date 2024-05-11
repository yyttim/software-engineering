package com.hospital.service;

import com.hospital.entity.vo.user.AdminUserVo;

public interface AdminUserService {

    /**
     * 管理员登录
     *
     * @param aId       管理员id （账号）
     * @param aPassword 管理员密码
     * @return 返回管理员登录信息
     */
    AdminUserVo login(int aId, String aPassword);

}
