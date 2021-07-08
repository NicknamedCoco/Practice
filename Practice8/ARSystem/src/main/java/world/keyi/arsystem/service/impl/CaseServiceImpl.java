package world.keyi.arsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.arsystem.entity.Case;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.mapper.CaseMapper;
import world.keyi.arsystem.service.CaseService;
import world.keyi.arsystem.utils.QueryRequest;

/**
 * @author 万一
 * @date 2021年06月22日11:15
 */
@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements CaseService {

    @Autowired
    private CaseMapper caseMapper;

    @Override
    public IPage<Case> queryList(QueryRequest queryRequest, Case cases) {
        IPage<Case> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return caseMapper.queryList(page,queryRequest,cases);
    }

    @Override
    public IPage<Case> queryListByPatient(QueryRequest queryRequest, Case cases, Integer userId) {
        IPage<Case> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return caseMapper.queryListByPatient(page,queryRequest,cases,userId);
    }
}
