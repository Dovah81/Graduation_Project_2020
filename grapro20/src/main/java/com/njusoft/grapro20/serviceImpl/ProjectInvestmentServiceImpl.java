package com.njusoft.grapro20.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.mapper.ProjectInvestmentMapper;
import com.njusoft.grapro20.mapper.ProjectMapper;
import com.njusoft.grapro20.model.Project;
import com.njusoft.grapro20.model.ProjectInvestment;
import com.njusoft.grapro20.service.ProjectInvestmentService;
import com.njusoft.grapro20.util.Define;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectInvestmentServiceImpl implements ProjectInvestmentService{
    @Autowired
    private ProjectInvestmentMapper projectInvestmentMapper;
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Integer investProject(ProjectInvestment projectInvestment){
        int code=0;
        projectInvestment.setCretime(new Date());
        projectInvestment.setIfchecked(0);
        code=projectInvestmentMapper.insert(projectInvestment);
        return code;
    }

    @Override
    public PageInfo<ProjectInvestment> listCheckS(Integer userid, Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<ProjectInvestment> pageInfo = new PageInfo<>(projectInvestmentMapper.selCheckByStudent(userid));
        return pageInfo;
    }

    @Override
    public PageInfo<ProjectInvestment> listCheckI(Integer userid, Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<ProjectInvestment> pageInfo = new PageInfo<>(projectInvestmentMapper.selCheckByInvestor(userid));
        return pageInfo;
    }

    @Override
    public Integer agreeById(Integer id){
        int code=0;
        ProjectInvestment projectInvestment=projectInvestmentMapper.selectByPrimaryKey(id);
        Project project=projectMapper.selectByPrimaryKey(projectInvestment.getProjectId());
        project.setAmount(project.getAmount()+projectInvestment.getAmount());
        projectInvestment.setLastchecktime(new Date());
        projectInvestment.setIfchecked(1);
        projectMapper.updateByPrimaryKey(project);
        code=projectInvestmentMapper.updateByPrimaryKey(projectInvestment);
        return code;
    }
}
