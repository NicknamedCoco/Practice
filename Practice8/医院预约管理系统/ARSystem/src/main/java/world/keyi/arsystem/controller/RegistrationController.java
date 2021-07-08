package world.keyi.arsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import world.keyi.arsystem.entity.Registration;
import world.keyi.arsystem.service.DepartmentService;
import world.keyi.arsystem.service.RegistrationService;
import world.keyi.arsystem.service.impl.RegistrationServiceImpl;
import world.keyi.arsystem.utils.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 万一
 * @date 2021年06月22日11:19
 */
@RestController
@RequestMapping("/adminApi/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private DepartmentService departmentService;

    /*
        查询挂号列表
        管理员没有挂号列表功能，所以registrationService.queryList不可能执行
     */
    @GetMapping("/list")
    public Result listRegistration(QueryRequest queryRequest, Registration entity, HttpServletRequest request){
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        if (userManager.isAdminRole(userId)){
            return ResultGenerator.genSuccessResult(registrationService.queryList(queryRequest, entity));
        }else if (userManager.isDoctorRole(userId)){
            return ResultGenerator.genSuccessResult(registrationService.queryListByDoctor(queryRequest,entity,userId));
        }else if (userManager.isPatientsRole(userId)){
            return ResultGenerator.genSuccessResult(registrationService.queryListByPatient(queryRequest,entity,userId));
        }
        return null;
    }

    /*
        新增挂号,给参数
     */
    @PostMapping
    public Result add(@RequestBody Registration registration,HttpServletRequest request){
        //拼接number编号,时间+部门名+获取当天内，各个部分的预约人数
        StringBuilder s = new StringBuilder(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        s.append(departmentService.getById(registration.getDepId()).getLetter());
        Integer num = registrationService.selectByNow(registration.getDepId());
        s.append(num+1);
        registration.setNumber(String.valueOf(s));
        //获取病人Id
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        registration.setPatientsId(userId);

        //随机设置付款金额，30到100之间
        int min=30,max=100;
        BigDecimal v = BigDecimal.valueOf(Math.random() * (max - min) + min).setScale(2, RoundingMode.HALF_UP);
        registration.setAmountPayable(v);
        registrationService.save(registration);
        return ResultGenerator.genSuccessResult("已支付"+v+"元");
    }

    /*
        开发票,给id
     */
    @PutMapping("/{id}")
    public Result openInvoice(@PathVariable("id") Integer id){
        Registration registration = new Registration();
        registration.setId(id);
        //生成发票代码，12位数，随机生成
        registration.setInvoiceCode(String.valueOf(OrderSnUtil.getRandom(12)));
        //生成发票号，9位数，随机生成
        registration.setInvoiceNumber(String.valueOf(OrderSnUtil.getRandom(9)));
        //生成发票日期
        registration.setInvoiceDate(LocalDate.now());
        //改变状态
        registration.setIsInvoice(true);
        registrationService.updateById(registration);
        return ResultGenerator.genSuccessResult();
    }

    /*
        通过id获取信息，给id
     */
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable Integer id){
        return ResultGenerator.genSuccessResult(registrationService.getById(id));
    }

    /*
        采纳，给id
     */
    @GetMapping("/accept/{id}")
    public Result accept(@PathVariable Integer id){
        Registration registration = new Registration();
        registration.setId(id);
        registration.setAccept(1);
        registrationService.updateById(registration);
        return ResultGenerator.genSuccessResult();
    }

    /*
        不采纳，给id
     */
    @GetMapping("/notAccept/{id}")
    public Result notAccept(@PathVariable Integer id){
        Registration registration = new Registration();
        registration.setId(id);
        registration.setStatus(0);
        registration.setAccept(2);
        registrationService.updateById(registration);
        return ResultGenerator.genSuccessResult();
    }

    /*
        评价,给参数
     */
    @PutMapping("/evaluate")
    public Result evaluate(@RequestBody Registration registration){
        registrationService.updateById(registration);
        return ResultGenerator.genSuccessResult();
    }

}
