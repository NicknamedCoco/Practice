package world.keyi.springboot_initialization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import world.keyi.springboot_initialization.bean.PO.UserPO;

@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
