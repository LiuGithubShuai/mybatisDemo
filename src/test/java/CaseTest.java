import com.kaishengit.mapper.DeptMapper;
import com.kaishengit.mapper.EmployeeMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;
import com.kaishengit.pojo.User;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public class CaseTest {

    @Test
    public void readXML(){
        try {
            //1.读取配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //2.构建sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //3.创建sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //4.执行查询语句
            User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
            System.out.println(user);
            //5.释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findById(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();

        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void save(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);

        User user = new User();
        user.setUsername("xiaoliu");
        user.setPassword("0012300");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.save(user);

        System.out.println("userID: "+user.getId());

        /*sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);*/
    }

    @Test
    public void update(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);

        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",9);
        user.setUsername("AAA");

        sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
        sqlSession.close();
    }

    @Test
    public void delete(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);

        sqlSession.delete("com.kaishengit.mapper.UserMapper.del",2);
        sqlSession.close();
    }

    @Test
    public void findAll(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();

        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptList = deptMapper.findAll();
        for (Dept d : deptList){
            System.out.println(d.getId()+"  "+d.getDeptName());
        }

        System.out.println();
        sqlSession.close();
    }

    @Test
    public void findByEmpId(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);;
        employeeMapper.findById(1);
        sqlSession.close();
    }

    @Test
    public void findEmployeeByDeptId(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();

        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.findEmployeeByDeptId(3);
        System.out.println(dept);

        List<Employee> employeeList = dept.getEmployeeList();
        for (Employee emp : employeeList){
            System.out.println(emp.getEmpName());
        }

        sqlSession.close();
    }


    @Test
    public void findByDeptId(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();

        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.findById(1);
        System.out.println(dept);

        List<Employee> employeeList = dept.getEmployeeList();
        System.out.println(employeeList);

        /*for (Employee emp : employeeList){
            System.out.println(emp);
        };*/
    }

}
