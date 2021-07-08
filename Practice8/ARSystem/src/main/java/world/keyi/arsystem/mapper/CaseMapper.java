package world.keyi.arsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import world.keyi.arsystem.entity.Case;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.utils.QueryRequest;

public interface CaseMapper extends BaseMapper<Case> {
    IPage<Case> queryList(IPage<Case> page,
                          @Param("queryRequest") QueryRequest queryRequest,
                          @Param("cases") Case cases);

    IPage<Case> queryListByPatient(IPage<Case> page,
                                   @Param("queryRequest") QueryRequest queryRequest,
                                   @Param("cases") Case cases,
                                   @Param("userId") Integer userId);
}
