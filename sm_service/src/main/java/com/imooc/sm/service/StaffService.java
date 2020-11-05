package com.imooc.sm.service;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;

import java.util.List;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/11/3 16:35
 */
public interface StaffService {
    void add(Staff staff);
    void remove(Integer id);
    void edit(Staff staff);
    Staff get(Integer id);
    List<Staff> getAll();
}
