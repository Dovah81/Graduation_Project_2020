package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.ProjectMember;
import java.util.List;

public interface ProjectMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectMember record);

    ProjectMember selectByPrimaryKey(Integer id);

    List<ProjectMember> selectAll();

    List<ProjectMember> selCheckByUser(Integer userid);

    int updateByPrimaryKey(ProjectMember record);
}