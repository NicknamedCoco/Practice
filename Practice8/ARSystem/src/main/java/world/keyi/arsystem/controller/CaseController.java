package world.keyi.arsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import world.keyi.arsystem.entity.Case;
import world.keyi.arsystem.entity.Registration;
import world.keyi.arsystem.service.CaseService;
import world.keyi.arsystem.service.RegistrationService;
import world.keyi.arsystem.utils.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 万一
 * @date 2021年06月22日11:20
 */
@RestController
@RequestMapping("/adminApi/case")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private RegistrationService registrationService;

    /*
        开处方,保存到case表中，并更新挂号表状态
     */
    @PostMapping("/makeCase")
    public Result makeCase(@RequestBody Case cases){
        Integer id = cases.getId();
        cases.setId(null);
        caseService.save(cases);
        Registration registration = new Registration();
        registration.setId(id);
        registration.setStatus(1);
        registrationService.updateById(registration);
        return ResultGenerator.genSuccessResult();
    }

    /*
        查询列表，给参数
     */
    @GetMapping("/list")
    public Result listCase(QueryRequest queryRequest, Case cases, HttpServletRequest request){
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        if (userManager.isAdminRole(userId)){
            return ResultGenerator.genSuccessResult(caseService.queryList(queryRequest,cases));
        }else if (userManager.isPatientsRole(userId)){
            return ResultGenerator.genSuccessResult(caseService.queryListByPatient(queryRequest,cases,userId));
        }
        return null;
    }

}
