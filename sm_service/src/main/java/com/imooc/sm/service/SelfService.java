package com.imooc.sm.service;

import com.imooc.sm.entity.Staff;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/11/6 15:52
 */
public interface SelfService {
    Staff login(String account, String password);
    void changePassword(Integer id, String password);
}
