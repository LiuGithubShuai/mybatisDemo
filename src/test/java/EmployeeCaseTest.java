import com.kaishengit.mapper.EmployeeMapper;
import com.kaishengit.pojo.Employee;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16.
 */
public class EmployeeCaseTest {

    SqlSession sqlSession = null;
    EmployeeMapper employeeMapper = null;

    @Before
    public void beforeTest(){
        sqlSession = SqlSessionFactoryUtil.getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    @After
    public void afterTest(){
        sqlSession.close();
    }

    @Test
    public void save(){
        employeeMapper.save(new Employee("涨涨涨",3));
        sqlSession.commit();
    }

    @Test
    public void findEmployeeByDeptId(){
        List<Employee> employeeList = employeeMapper.findByDeptId(1);

        for (Employee emp : employeeList){
            System.out.println(emp);
        }
    }

    @Test
    public void updateEmployee(){
        Employee employee = employeeMapper.findById(18);
        employee.setEmpName("小小喵");
        employeeMapper.updateEmployee(employee);
        sqlSession.commit();
    }

    @Test
    public void del(){
        employeeMapper.del(19);
        sqlSession.commit();
    }

}
