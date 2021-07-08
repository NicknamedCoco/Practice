package world.keyi.arsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.keyi.arsystem.entity.Department;
import world.keyi.arsystem.service.DepartmentService;
import world.keyi.arsystem.utils.QueryRequest;
import world.keyi.arsystem.utils.Result;
import world.keyi.arsystem.utils.ResultGenerator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 万一
 * @date 2021年06月22日11:20
 */
@RestController
@RequestMapping("/adminApi/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /*
        查询医院科室列表,给参数
     */
    @GetMapping("/list")
    public Result listDepartment(QueryRequest queryRequest,Department department){
        return ResultGenerator.genSuccessResult(departmentService.queryDepartments(queryRequest,department));
    }

    /*
        查询医院科室详细，给id
     */
    @GetMapping("/{deptId}")
    public Result getDepartment(@PathVariable("deptId") Integer id){
        return ResultGenerator.genSuccessResult(departmentService.getById(id));
    }

    /*
        新增医院科室，给参数
     */
    @PostMapping
    public Result addDepartment(@RequestBody Department department){
        departmentService.save(department);
        return ResultGenerator.genSuccessResult();
    }

    /*
        修改医院科室，给参数
     */
    @PutMapping
    public String updateDepartment(){
        return "";
    }

    /*
        删除医院科室，给id
     */
    @DeleteMapping("/{deptIds}")
    public Result delDepartment(@PathVariable("deptIds") Integer[] deptIds){
        return ResultGenerator.genSuccessResult(departmentService.removeByIds(Arrays.asList(deptIds)));
    }
}
