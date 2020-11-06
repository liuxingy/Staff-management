package com.imooc.sm.service.impl;

import com.imooc.sm.dao.SelfDao;
import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/11/6 16:03
 */
@Service("selfService")
public class SelfServiceImpl implements SelfService {

    @Autowired
    private SelfDao selfDao;

    @Autowired
    private StaffDao staffDao;

    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        if (staff == null) return null;
        if (staff.getPassword().equals(password)) return staff;
        return null;
    }

    public void changePassword(Integer id, String password) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
