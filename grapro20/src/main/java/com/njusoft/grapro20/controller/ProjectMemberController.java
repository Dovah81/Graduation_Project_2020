package com.njusoft.grapro20.controller;

import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.model.Project;
import com.njusoft.grapro20.model.ProjectMember;
import com.njusoft.grapro20.model.Student;
import com.njusoft.grapro20.service.ProjectMemberService;
import com.njusoft.grapro20.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/projectMember")
public class ProjectMemberController {
    @Resource
    private ProjectMemberService projectMemberService;

    @RequestMapping("joinProject")
    public ResultVO joinProject(@RequestBody ProjectMember projectMember){
        Integer result=0;
        result = projectMemberService.joinProject(projectMember);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(result);
        if(result==0){
            resultVO.setMsg("申请失败");
        }
        else
            resultVO.setMsg("申请成功");
        return resultVO;
    }

    @RequestMapping("list/check/{currPage}")
    public PageInfo<ProjectMember> listCheck(@PathVariable Integer currPage, @RequestBody Student student){
        return projectMemberService.listCheck(student.getId(),currPage);
    }

    @RequestMapping("agree/{id}")
    public ResultVO agree(@PathVariable Integer id){
        int result=0;
        result=projectMemberService.agreeById(id);
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
//        return projectMemberService.disagreeById(id);
//    }
}
