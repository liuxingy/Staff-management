package com.imooc.sm.dao;

import com.imooc.sm.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/11/10 13:54
 */
@Repository("logDao")
public interface LogDao {
    void insert(Log log);
    List<Log> selectByType(String type);
}
