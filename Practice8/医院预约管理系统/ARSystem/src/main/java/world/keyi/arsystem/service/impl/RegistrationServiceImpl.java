package world.keyi.arsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.arsystem.entity.Registration;
import world.keyi.arsystem.mapper.RegistrationMapper;
import world.keyi.arsystem.service.RegistrationService;
import world.keyi.arsystem.utils.QueryRequest;

/**
 * @author 万一
 * @date 2021年06月22日11:12
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements RegistrationService {

    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public IPage<Registration> queryList(QueryRequest queryRequest, Registration entity) {
        Page<Registration> registrationPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        IPage<Registration> registrationIPage = registrationMapper.queryList(registrationPage, queryRequest, entity);
        return registrationIPage;
    }

    @Override
    public IPage<Registration> queryListByDoctor(QueryRequest queryRequest, Registration entity, Integer userId) {
        Page<Registration> registrationPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        IPage<Registration> registrationIPage = registrationMapper.queryListByDoctor(registrationPage, queryRequest, entity,userId);
        return registrationIPage;
    }

    @Override
    public IPage<Registration> queryListByPatient(QueryRequest queryRequest, Registration entity, Integer userId) {
        Page<Registration> registrationPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        IPage<Registration> registrationIPage = registrationMapper.queryListByPatient(registrationPage, queryRequest, entity,userId);
        return registrationIPage;
    }

    @Override
    public Integer selectByNow(Integer depId) {
        String sql ="SELECT COUNT(1) FROM t_registration tg  " +
                " LEFT JOIN t_user su ON su.user_id = tg.doctor_id " +
                " LEFT JOIN t_department td ON td.id = su.dep_id " +
                " WHERE TO_DAYS(tg.create_time) = TO_DAYS(NOW()) " +
                " AND dep_id = "+depId;
        return registrationMapper.selectByNow(sql);
    }
}
