package com.imooc.sm.dao;

import com.imooc.sm.entity.Staff;
import org.springframework.stereotype.Repository;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/11/5 14:28
 */
@Repository("selfDao")
public interface SelfDao {
    Staff selectByAccount(String account); // 给一个账户名，到数据库里把和账户名匹配的输入的密码去对比。
}
