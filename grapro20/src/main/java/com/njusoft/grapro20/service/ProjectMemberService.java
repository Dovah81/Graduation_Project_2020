package com.njusoft.grapro20.service;

import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.model.ProjectMember;

public interface ProjectMemberService {

    Integer joinProject(ProjectMember projectMember);

    PageInfo<ProjectMember> listCheck(Integer userid, Integer currPage);

    Integer agreeById(Integer id);
}
