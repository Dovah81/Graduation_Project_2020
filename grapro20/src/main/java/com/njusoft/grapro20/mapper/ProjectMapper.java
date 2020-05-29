package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.Project;
import com.njusoft.grapro20.model.ProjectStat;

import java.util.List;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    Project selectByPrimaryKey(Integer id);

    List<Project> selectAll();

    List<Project> selCheckedByUser(Integer userid);

    List<Project> selJoinedByUser(Integer userid);

    List<Project> selStudentProByUser(Integer userid);

    List<Project> selCheckedByInvestor(Integer userid);

    List<Project> selUncheckedByUser(Integer userid);

    List<Project> selUncheckedBySchool(String name);

    List<ProjectStat> queryMonthNum(ProjectStat projectStat);

    int updateByPrimaryKey(Project record);
}