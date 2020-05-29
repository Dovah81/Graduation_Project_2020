package com.njusoft.grapro20.service;

import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.model.ProjectInvestment;

public interface ProjectInvestmentService {
    Integer investProject(ProjectInvestment projectInvestment);

    PageInfo<ProjectInvestment> listCheckS(Integer userid, Integer currPage);

    PageInfo<ProjectInvestment> listCheckI(Integer userid, Integer currPage);

    Integer agreeById(Integer id);
}
