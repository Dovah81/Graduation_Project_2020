package com.njusoft.grapro20.controller;

import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.model.*;
import com.njusoft.grapro20.service.ProjectService;
import com.njusoft.grapro20.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Resource
    private ProjectService projectService;

    @RequestMapping("list/{currPage}")
    public PageInfo<Project> list(@PathVariable Integer currPage){
        return projectService.list(currPage);
    }

    @RequestMapping("list/checked/{currPage}")
    public PageInfo<Project> listChecked(@PathVariable Integer currPage,@RequestBody Student student){
        return projectService.listChecked(student.getId(),currPage);
    }

    @RequestMapping("list/joined/{currPage}")
    public PageInfo<Project> listJoined(@PathVariable Integer currPage,@RequestBody Student student){
        return projectService.listJoined(student.getId(),currPage);
    }

    @RequestMapping("list/investedPro/{currPage}")
    public PageInfo<Project> listInvestedPro(@PathVariable Integer currPage,@RequestBody Investor investor){
        return projectService.listInvestedPro(investor.getId(),currPage);
    }

    @RequestMapping("list/studentPro/{currPage}")
    public PageInfo<Project> listInvestedPro(@PathVariable Integer currPage,@RequestBody Admin admin){
        return projectService.listStudentPro(admin.getId(),currPage);
    }

    @RequestMapping("list/unchecked/{currPage}")
    public PageInfo<Project> listUnchecked(@PathVariable Integer currPage,@RequestBody Student student){
        return projectService.listUnchecked(student.getId(),currPage);
    }

    @RequestMapping("list/tocheck/{currPage}")
    public PageInfo<Project> listUnchecked(@PathVariable Integer currPage,@RequestBody Admin admin){
        return projectService.listUnchecked(admin.getName(),currPage);
    }

    @RequestMapping("createProject")
    public ResultVO createProject(@RequestBody Project project){
        Integer result=0;
        result = projectService.createProject(project);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(result);
        if(result==0){
            resultVO.setMsg("新建项目失败");
        }
        else
            resultVO.setMsg("新建项目成功");
        return resultVO;
    }

    @RequestMapping("updateProject")
    public ResultVO updateProject(@RequestBody Project project){
        Integer result=0;
        result = projectService.updateProject(project);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(result);
        if(result==0){
            resultVO.setMsg("修改项目失败");
        }
        else
            resultVO.setMsg("修改项目成功");
        return resultVO;
    }

    @RequestMapping("sel/{id}")
    public Project sel(@PathVariable Integer id){
        return projectService.selById(id);
    }

    @RequestMapping("agree/{id}")
    public ResultVO agree(@PathVariable Integer id){
        Integer result=0;
        result = projectService.agreeById(id);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(result);
        if(result==0){
            resultVO.setMsg("操作失败");
        }
        else
            resultVO.setMsg("操作成功");
        return resultVO;
    }

    @RequestMapping("monthNum")
    public List<ProjectStat> monthNum(@RequestBody ProjectStat projectStat){
        System.out.println(projectStat.toString());
        return projectService.monthNum(projectStat);
    }
}
