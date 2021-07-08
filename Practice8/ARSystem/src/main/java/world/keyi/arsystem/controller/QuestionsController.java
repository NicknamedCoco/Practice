package world.keyi.arsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import world.keyi.arsystem.entity.Questions;
import world.keyi.arsystem.entity.Registration;
import world.keyi.arsystem.service.QuestionsService;
import world.keyi.arsystem.service.impl.QuestionsServiceImpl;
import world.keyi.arsystem.utils.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author 万一
 * @date 2021年06月22日11:19
 */
@RestController
@RequestMapping("/adminApi/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private UserManager userManager;

    /*
        查询问答列表，给参数
     */
    @GetMapping("/list")
    public Result queList(QueryRequest queryRequest, Questions entity, HttpServletRequest request){
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        if (userManager.isDoctorRole(userId)){
            return ResultGenerator.genSuccessResult(questionsService.queryList(queryRequest,entity));
        }else if (userManager.isPatientsRole(userId)){
            return ResultGenerator.genSuccessResult(questionsService.queryListByPatient(queryRequest,entity,userId));
        }
        return null;
    }

    /*
        新增问答,给参数
     */
    @PostMapping("/ask")
    public Result ask(@RequestBody Questions questions, HttpServletRequest request){
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        questions.setPatientId(userId);
        questionsService.save(questions);
        return ResultGenerator.genSuccessResult();
    }

    /*
        删除问答
     */
    @DeleteMapping("/{ids}")
    public Result delQuestions(@PathVariable("ids") Integer[] ids){
        for (Integer id : ids) {
            questionsService.removeById(id);
            QueryWrapper<Questions> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id",id);
            questionsService.remove(queryWrapper);
        }
        return ResultGenerator.genSuccessResult();
    }

    /*
        回复问题,给参数
     */
    @PutMapping("/reply")
    public Result reply(@RequestBody Questions questions,HttpServletRequest request){
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));
        Questions entity = new Questions();
        entity.setParentId(questions.getId());
        entity.setPatientId(questions.getPatientId());
        entity.setDoctorId(userId);
        entity.setTitle(questions.getReply());
        questionsService.save(entity);
        return ResultGenerator.genSuccessResult();
    }



}
