package world.keyi.arsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.utils.QueryRequest;

public interface UserMapper extends BaseMapper<User> {
    IPage<User> queryDoctorUser(IPage<User> userIPage,@Param("queryRequest") QueryRequest queryRequest, @Param("user") User user);

    @Select("${sql}")
    User queryDoctorInfoByUsername(@Param("sql") String sql);
}
