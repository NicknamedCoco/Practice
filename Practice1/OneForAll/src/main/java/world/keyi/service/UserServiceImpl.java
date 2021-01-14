package world.keyi.service;

import org.apache.commons.dbutils.DbUtils;
import world.keyi.dao.UserDao;
import world.keyi.dao.UserDaoImpl;
import world.keyi.utils.DBUtils;
import world.keyi.view.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public String register(User user) {
        String result = null;
        Connection conn = null;
        try {
            conn = DBUtils.getDataSource().getConnection();
            conn.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl(conn);
            int i = userDao.addUser(user);
            DbUtils.commitAndCloseQuietly(conn);
            if (i != 0) {
                result = "注册成功";
            } else {
                result = "注册失败";
            }
        } catch (SQLException e) {
            DbUtils.rollbackAndCloseQuietly(conn);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Boolean login(User user) {
        Boolean result = false;
        Connection conn = null;
        try {
            conn = DBUtils.getDataSource().getConnection();
            conn.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl(conn);
            User dataUser = userDao.queryUser(user.getUsername());
            DbUtils.commitAndCloseQuietly(conn);
            if (dataUser.getUsername().equals(user.getUsername())
                    && dataUser.getPassword().equals(user.getPassword())) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException e) {
            DbUtils.rollbackAndCloseQuietly(conn);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> queryAllUser() {
        List<User> users=null;
        Connection conn = null;
        try {
            conn = DBUtils.getDataSource().getConnection();
            conn.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl(conn);
            users=userDao.queryAllUser();
            DbUtils.commitAndCloseQuietly(conn);
        } catch (SQLException e) {
            DbUtils.rollbackAndCloseQuietly(conn);
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Boolean query(String username) {
        Connection conn = null;
        Boolean flag=false;
        try {
            conn = DBUtils.getDataSource().getConnection();
            conn.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl(conn);
            User user = userDao.queryUser(username);
            DbUtils.commitAndCloseQuietly(conn);
            if (user!=null){
                flag=true;
            }
        } catch (SQLException e) {
            DbUtils.rollbackAndCloseQuietly(conn);
            e.printStackTrace();
        }
        return flag;
    }
}
