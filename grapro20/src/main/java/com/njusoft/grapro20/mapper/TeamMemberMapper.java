package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.TeamMember;
import java.util.List;

public interface TeamMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeamMember record);

    TeamMember selectByPrimaryKey(Integer id);

    List<TeamMember> selectAll();

    int updateByPrimaryKey(TeamMember record);
}