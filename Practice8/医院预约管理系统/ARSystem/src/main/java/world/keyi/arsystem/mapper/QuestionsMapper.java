package world.keyi.arsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import world.keyi.arsystem.entity.Questions;
import world.keyi.arsystem.utils.QueryRequest;

public interface QuestionsMapper extends BaseMapper<Questions> {
    IPage<Questions> queryList(Page<Questions> questionsPage,
                               @Param("queryRequest") QueryRequest queryRequest,
                               @Param("entity") Questions entity);

    IPage<Questions> queryListByPatient(Page<Questions> questionsPage,
                                        @Param("queryRequest") QueryRequest queryRequest,
                                        @Param("entity") Questions entity,
                                        @Param("userId") Integer userId);
}
