package world.keyi.arsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import world.keyi.arsystem.entity.Department;
import world.keyi.arsystem.utils.QueryRequest;

public interface DepartmentService extends IService<Department> {
    IPage<Department> queryDepartments(QueryRequest queryRequest, Department department);
}
