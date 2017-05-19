package com.kaishengit.mapper;

import com.kaishengit.pojo.Employee;
import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public interface EmployeeMapper {

    Employee findById(Integer id);

    @Insert(value = "insert into t_employee (emp_name,dept_id) values (#{empName},#{deptId})")
    void save(Employee employee);

    @Select(value = "select * from t_employee where dept_id = #{deptId} ")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "emp_name",property = "empName"),
            @Result(column = "dept_id",property = "deptId"),
            @Result(column = "dept_id",property = "dept",one = @One(select = "com.kaishengit.mapper.DeptMapper.findById"))
    })
    //List<Employee> findAll();
    List<Employee> findByDeptId(Integer id);

    @Update(value="update t_employee set emp_name = #{empName} , dept_id = #{deptId} where id = #{id}")
    void updateEmployee(Employee employee);

    @Delete(value="delete from t_employee where id = #{id}")
    void del(Integer id);



}
