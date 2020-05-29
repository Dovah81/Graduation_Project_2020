package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.MatchCompetitor;
import java.util.List;

public interface MatchCompetitorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MatchCompetitor record);

    MatchCompetitor selectByPrimaryKey(Integer id);

    List<MatchCompetitor> selectAll();

    int updateByPrimaryKey(MatchCompetitor record);
}