package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.Match;
import java.util.List;

public interface MatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Match record);

    Match selectByPrimaryKey(Integer id);

    List<Match> selectAll();

    int updateByPrimaryKey(Match record);
}