package world.keyi.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import world.keyi.view.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection conn;
    QueryRunner runner = new QueryRunner();

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }


    @Override
    public int addUser(User user) {
        //Dbutils的使用
        int result = 0;
        try {
            String sql = "insert into user values(?,?,?)";
            Object[] params = {user.getUsername(), user.getPassword(), user.getEmail()};
            result = runner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteUser(String username) {
        int result = 0;
        String sql = "delete from user where username = ?";
        try {
            result = runner.update(conn, sql, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public int updateUser(User user) {
        int result = 0;
        String sql = "update user set password=?,email=? where username=?";
        Object[] params = {user.getPassword(), user.getEmail(), user.getUsername()};
        try {
            result = runner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> queryAllUser() {
        String sql = "select username,password,email from user";
        List<User> users = null;

        try {
            users = runner.query(conn, sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User queryUser(String username) {
        QueryRunner queryRunner = new QueryRunner();
        User user = null;
        String sql = "select username,password,email from user where username=?";
        try {
            user = queryRunner.query(conn, sql, new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
