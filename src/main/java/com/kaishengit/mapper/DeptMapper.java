package com.kaishengit.mapper;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface DeptMapper {

    Dept findById(Integer id);
    Dept findEmployeeByDeptId(Integer id);
    List<Dept> findAll();

}
