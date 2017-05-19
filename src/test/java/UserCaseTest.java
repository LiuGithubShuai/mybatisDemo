import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/16.
 */
public class UserCaseTest {

    private SqlSession sqlSession = null;
    private UserMapper userMapper = null;

    @Before
    public void beforeTest() {
        sqlSession = SqlSessionFactoryUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void afterTest() {
        sqlSession.close();
    }


    /**
     * 多参数sql语句，不能用常规的方法操作，一般有三种方法，具体见UserMapper.xml
     */
    /*
    @Test
    public void findByUsernameAndPassword(){
        User user = userMapper.findByUsernameAndPassword("AAA","a000");
        System.out.println(user);
    }*/

   /*
   @Test
   public void findByUsernameAndPassword(){
        Map<String,String> params = new HashMap<>();
        params.put("username","AAA");
        params.put("password","a000");

        userMapper.findByUsernameAndPassword(params);
    }*/

   /*@Test
    public void findByUsernameAndPassword(){
       User user = userMapper.findByUsernameAndPassword("eric","123123");
       System.out.println(user);
   }*/

   /*@Test
    public void findByUsernameAndPassword(){
       User user = userMapper.findByUsernameAndPassword("eric","123123");
       System.out.println(user);
   }*/

   /*@Test
    public void findByUsernameAndPassword(){
       Map<String,String> params = new HashMap<>();
       params.put("username","eric");
       params.put("password","123123");

       User user = userMapper.findByUsernameAndPassword(params);
       System.out.println(user);
   }*/

   @Test
    public void findByUsernameAndPassword(){
       Map<String,String> params = new HashMap<>();
       //params.put("username","eric");
       params.put("password","123123");

       userMapper.findByUsernameAndPassword(params);
   }

   @Test
    public void batchSave(){
       List<User> userList = new ArrayList<>();
       userList.add(new User("a11001","a12001"));
       userList.add(new User("a11002","a12002"));
       userList.add(new User("a11003","a12003"));
       userList.add(new User("a11004","a12004"));
       userList.add(new User("a11005","a12005"));
       userList.add(new User("a11006","a12006"));
       userList.add(new User("a11007","a12007"));
       userList.add(new User("a11008","a12008"));

       userMapper.batchSave(userList);
       sqlSession.commit();
   }

}
