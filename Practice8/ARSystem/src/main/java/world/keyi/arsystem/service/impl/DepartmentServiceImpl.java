package world.keyi.arsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.keyi.arsystem.entity.Department;
import world.keyi.arsystem.mapper.DepartmentMapper;
import world.keyi.arsystem.service.DepartmentService;
import world.keyi.arsystem.utils.QueryRequest;

/**
 * @author 万一
 * @date 2021年06月22日11:14
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public IPage<Department> queryDepartments(QueryRequest queryRequest, Department department) {
        IPage<Department> departmentIPage = new Page<>(queryRequest.getPageNum(),queryRequest.getPageSize(),true);
        QueryWrapper<Department> departmentQueryWrapper = new QueryWrapper<>();
        departmentQueryWrapper.like(!ObjectUtils.isEmpty(department.getDepName()),"dep_name",department.getDepName())
        .like(!ObjectUtils.isEmpty(department.getLetter()),"letter",department.getLetter())
        .orderByDesc("create_time");
        return departmentMapper.selectPage(departmentIPage,departmentQueryWrapper);
    }
}
