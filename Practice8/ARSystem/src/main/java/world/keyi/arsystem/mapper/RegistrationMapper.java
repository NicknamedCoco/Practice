package world.keyi.arsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import world.keyi.arsystem.entity.Registration;
import world.keyi.arsystem.utils.QueryRequest;

public interface RegistrationMapper extends BaseMapper<Registration> {
    IPage<Registration> queryList(IPage<Registration> page,@Param("queryRequest") QueryRequest queryRequest,@Param("entity") Registration entity);

    IPage<Registration> queryListByDoctor(Page<Registration> registrationPage, @Param("queryRequest")QueryRequest queryRequest, @Param("entity")Registration entity, @Param("userId") Integer userId);
    IPage<Registration> queryListByPatient(Page<Registration> registrationPage, @Param("queryRequest")QueryRequest queryRequest, @Param("entity")Registration entity, @Param("userId") Integer userId);

    @Select("${sql}")
    Integer selectByNow(@Param("sql") String sql);
}
