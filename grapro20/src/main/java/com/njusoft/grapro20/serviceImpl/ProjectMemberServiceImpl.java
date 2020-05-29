package com.njusoft.grapro20.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.mapper.ProjectMemberMapper;
import com.njusoft.grapro20.model.ProjectMember;
import com.njusoft.grapro20.service.ProjectMemberService;
import com.njusoft.grapro20.util.Define;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService{

    @Autowired
    private ProjectMemberMapper projectMemberMapper;

    @Override
    public Integer joinProject(ProjectMember projectMember){
        int code=0;
        projectMember.setCretime(new Date());
        projectMember.setIfchecked(0);
        code=projectMemberMapper.insert(projectMember);
        return code;
    }

    @Override
    public PageInfo<ProjectMember> listCheck(Integer userid, Integer currPage){
        if(currPage == null) currPage = 1;
        System.out.println(userid);
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<ProjectMember> pageInfo = new PageInfo<>(projectMemberMapper.selCheckByUser(userid));
        return pageInfo;
    }

    @Override
    public Integer agreeById(Integer id){
        int code=0;
        ProjectMember projectMember=projectMemberMapper.selectByPrimaryKey(id);
        projectMember.setLastchecktime(new Date());
        projectMember.setIfchecked(1);
        code=projectMemberMapper.updateByPrimaryKey(projectMember);
        return code;
    }
}
