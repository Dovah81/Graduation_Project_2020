package com.njusoft.grapro20.service;

import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.model.Project;
import com.njusoft.grapro20.model.ProjectStat;

import java.util.List;

public interface ProjectService {

    Integer createProject(Project project);

    PageInfo<Project> list(Integer currPage);

    PageInfo<Project> listChecked(Integer userid,Integer currPage);

    PageInfo<Project> listJoined(Integer userid,Integer currPage);

    PageInfo<Project> listInvestedPro(Integer userid,Integer currPage);

    PageInfo<Project> listStudentPro(Integer userid,Integer currPage);

    PageInfo<Project> listUnchecked(Integer userid,Integer currPage);

    PageInfo<Project> listUnchecked(String name,Integer currPage);

    List<ProjectStat> monthNum(ProjectStat projectStat);

    Integer updateProject(Project project);

    void del(Integer id);

    Project selById(Integer id);

    Integer agreeById(Integer id);
}
