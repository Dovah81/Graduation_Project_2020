package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.StartupKnowledge;
import java.util.List;

public interface StartupKnowledgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StartupKnowledge record);

    StartupKnowledge selectByPrimaryKey(Integer id);

    List<StartupKnowledge> selectAll();

    int updateByPrimaryKey(StartupKnowledge record);
}