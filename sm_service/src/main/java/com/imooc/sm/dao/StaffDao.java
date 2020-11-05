package com.imooc.sm.dao;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;

import java.util.List;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/11/3 16:35
 */
public interface StaffDao {
    void insert(Staff staff);
    void delete(Integer id);
    void update(Staff staff);
    Staff selectById(Integer id);
    List<Staff> selectAll();
}
