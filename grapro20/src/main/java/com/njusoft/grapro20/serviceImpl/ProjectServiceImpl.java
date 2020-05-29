package com.njusoft.grapro20.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.mapper.ProjectMapper;
import com.njusoft.grapro20.model.Project;
import com.njusoft.grapro20.model.ProjectStat;
import com.njusoft.grapro20.service.ProjectService;
import com.njusoft.grapro20.util.Define;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public PageInfo<Project> list(Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selectAll());
        return pageInfo;
    }

    @Override
    public PageInfo<Project> listChecked(Integer userid,Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selCheckedByUser(userid));
        return pageInfo;
    }

    @Override
    public PageInfo<Project> listJoined(Integer userid,Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selJoinedByUser(userid));
        return pageInfo;
    }

    @Override
    public PageInfo<Project> listInvestedPro(Integer userid,Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selCheckedByInvestor(userid));
        return pageInfo;
    }

    @Override
    public PageInfo<Project> listStudentPro(Integer userid,Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selStudentProByUser(userid));
        return pageInfo;
    }

    @Override
    public PageInfo<Project> listUnchecked(Integer userid,Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selUncheckedByUser(userid));
        return pageInfo;
    }

    @Override
    public PageInfo<Project> listUnchecked(String name,Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selUncheckedBySchool(name));
        return pageInfo;
    }

    @Override
    public Integer createProject(Project project){
        int code=0;
        project.setCretime(new Date());
        project.setIfchecked(0);
        project.setAmount(0.0);
        code=projectMapper.insert(project);
        return code;
    }

    @Override
    public Integer updateProject(Project project) {
        int code=0;
        code=projectMapper.updateByPrimaryKey(project);
        return code;
    }

    @Override
    public void del(Integer id) {

    }

    @Override
    public Project selById(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer agreeById(Integer id){
        int code=0;
        Project project=projectMapper.selectByPrimaryKey(id);
        project.setLastchecktime(new Date());
        project.setIfchecked(1);
        code=projectMapper.updateByPrimaryKey(project);
        return code;
    }

//
//    @Override
//    public Integer disagreeById(Integer id,String message){
//        int code=0;
//        Project project=projectMapper.selectByPrimaryKey(id);
//        project.setLastchecktime(new Date());
//        project.setIfchecked(2);
//        project.setMessage(message);
//        code=projectMapper.updateByPrimaryKey(project);
//        return code;
//    }
    @Override
    public List<ProjectStat> monthNum(ProjectStat projectStat){
        return projectMapper.queryMonthNum(projectStat);
    }
}
