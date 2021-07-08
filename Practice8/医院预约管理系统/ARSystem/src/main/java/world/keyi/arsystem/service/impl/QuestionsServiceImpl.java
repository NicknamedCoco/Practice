package world.keyi.arsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.arsystem.entity.Questions;
import world.keyi.arsystem.mapper.QuestionsMapper;
import world.keyi.arsystem.service.QuestionsService;
import world.keyi.arsystem.utils.QueryRequest;

/**
 * @author 万一
 * @date 2021年06月22日11:13
 */
@Service
public class QuestionsServiceImpl extends ServiceImpl<QuestionsMapper, Questions> implements QuestionsService {

    @Autowired
    private QuestionsMapper questionsMapper;

    @Override
    public IPage<Questions> queryList(QueryRequest queryRequest, Questions entity) {
        Page<Questions> questionsPage = new Page<>(queryRequest.getPageNum(),queryRequest.getPageSize(),true);
        return questionsMapper.queryList(questionsPage,queryRequest,entity);
    }

    @Override
    public IPage<Questions> queryListByPatient(QueryRequest queryRequest, Questions entity, Integer userId) {
        Page<Questions> questionsPage = new Page<>(queryRequest.getPageNum(),queryRequest.getPageSize(),true);
        return questionsMapper.queryListByPatient(questionsPage,queryRequest,entity,userId);
    }
}
