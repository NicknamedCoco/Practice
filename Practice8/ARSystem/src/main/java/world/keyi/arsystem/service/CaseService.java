package world.keyi.arsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import world.keyi.arsystem.entity.Case;
import world.keyi.arsystem.entity.User;
import world.keyi.arsystem.utils.QueryRequest;

public interface CaseService extends IService<Case> {
    IPage<Case> queryList(QueryRequest queryRequest, Case cases);

    IPage<Case> queryListByPatient(QueryRequest queryRequest, Case cases, Integer userId);
}
