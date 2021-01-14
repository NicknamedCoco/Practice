package world.keyi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBUtils {
    private static DruidDataSource dataSource=null;
    static{
        Properties properties = new Properties();
        InputStream stream = DBUtils.class.getClassLoader().getResourceAsStream("/druid.properties");
        try {
            properties.load(stream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
