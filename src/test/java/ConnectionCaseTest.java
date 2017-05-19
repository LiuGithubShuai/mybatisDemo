import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/14.
 */
public class ConnectionCaseTest {

    /*@Test
    public void test() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///mydb","root","root");
        PreparedStatement preparedStatement = null;
        connection.setAutoCommit(false);

        try {
            String sql = "insert into t_account (username,password) values ('z1','z111')";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            String sql2 = "insert into t_account (username,password) values ('z2','z222')";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }*/

    @Test
    public void test() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///mydb","root","root");
        PreparedStatement preparedStatement = null;
        connection.setAutoCommit(false);

        try {
            String sql = "INSERT INTO t_account (username,password) VALUES ('z1','z111')";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            String sql2 = "insert into t_account (username,password) values ('z2','z222')";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            preparedStatement.close();
            connection.close();
        }


    }

}
