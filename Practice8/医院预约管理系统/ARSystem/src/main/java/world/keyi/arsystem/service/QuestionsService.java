package world.keyi.arsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import world.keyi.arsystem.entity.Questions;
import world.keyi.arsystem.utils.QueryRequest;

public interface QuestionsService extends IService<Questions> {
    IPage<Questions> queryList(QueryRequest queryRequest, Questions entity);

    IPage<Questions> queryListByPatient(QueryRequest queryRequest, Questions entity, Integer userId);
}
