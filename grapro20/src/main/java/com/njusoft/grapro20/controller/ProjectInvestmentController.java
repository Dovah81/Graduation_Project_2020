package com.njusoft.grapro20.controller;

import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.model.ProjectInvestment;
import com.njusoft.grapro20.model.Student;
import com.njusoft.grapro20.service.ProjectInvestmentService;
import com.njusoft.grapro20.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/projectInvestment")
public class ProjectInvestmentController {
    @Resource
    private ProjectInvestmentService projectInvestmentService;

    @RequestMapping("investProject")
    public ResultVO investProject(@RequestBody ProjectInvestment projectInvestment){
        Integer result=0;
        System.out.println(projectInvestment.toString());
        result = projectInvestmentService.investProject(projectInvestment);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(result);
        if(result==0){
            resultVO.setMsg("申请失败");
        }
        else
            resultVO.setMsg("申请成功");
        return resultVO;
    }

    @RequestMapping("list/checkS/{currPage}")
    public PageInfo<ProjectInvestment> listCheckS(@PathVariable Integer currPage, @RequestBody Student student){
        return projectInvestmentService.listCheckS(student.getId(),currPage);
    }

    @RequestMapping("list/checkI/{currPage}")
    public PageInfo<ProjectInvestment> listCheckI(@PathVariable Integer currPage, @RequestBody Student student){
        return projectInvestmentService.listCheckI(student.getId(),currPage);
    }

    @RequestMapping("agree/{id}")
    public ResultVO agree(@PathVariable Integer id){
        Integer result=0;
        result = projectInvestmentService.agreeById(id);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(result);
        if(result==0){
            resultVO.setMsg("操作失败");
        }
        else
            resultVO.setMsg("操作成功");
        return resultVO;
    }
//
//    @RequestMapping("disagree/{id}")
//    public ResultVO disagree(@PathVariable Integer id){
//        Integer result=0;
//        result = projectInvestmentService.disagreeById(id);
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(result);
//        if(result==0){
//            resultVO.setMsg("修改项目失败");
//        }
//        else
//            resultVO.setMsg("修改项目成功");
//        return resultVO;
//    }
}
