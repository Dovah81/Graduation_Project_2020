package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.ProjectInvestment;
import java.util.List;

public interface ProjectInvestmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInvestment record);

    ProjectInvestment selectByPrimaryKey(Integer id);

    List<ProjectInvestment> selectAll();

    List<ProjectInvestment> selCheckByStudent(Integer userid);

    List<ProjectInvestment> selCheckByInvestor(Integer userid);

    int updateByPrimaryKey(ProjectInvestment record);
}