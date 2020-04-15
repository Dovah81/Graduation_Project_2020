package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.Team;
import java.util.List;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Team record);

    Team selectByPrimaryKey(Integer id);

    List<Team> selectAll();

    int updateByPrimaryKey(Team record);
}