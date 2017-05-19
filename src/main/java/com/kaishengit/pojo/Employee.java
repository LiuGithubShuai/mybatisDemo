package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/12.
 */

/**
 * 实现序列化接口主要目的是缓存
 */
public class Employee implements Serializable {

    private Integer id;
    private String empName;
    private Integer deptId;
    private Dept dept;

    public Employee() {
    }

    public Employee(String empName, Integer deptId) {
        this.empName = empName;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", deptId=" + deptId +
                ", dept=" + dept +
                '}';
    }
}
