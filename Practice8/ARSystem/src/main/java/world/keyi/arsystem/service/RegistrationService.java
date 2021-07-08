package world.keyi.arsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import world.keyi.arsystem.entity.Registration;
import world.keyi.arsystem.utils.QueryRequest;

public interface RegistrationService extends IService<Registration> {
    IPage<Registration> queryList(QueryRequest queryRequest,Registration entity);
    IPage<Registration> queryListByDoctor(QueryRequest queryRequest,Registration entity,Integer userId);
    IPage<Registration> queryListByPatient(QueryRequest queryRequest,Registration entity,Integer userId);

    Integer selectByNow(Integer depId);
}
