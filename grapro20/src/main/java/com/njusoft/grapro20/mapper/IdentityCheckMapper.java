package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.IdentityCheck;
import java.util.List;

public interface IdentityCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IdentityCheck record);

    IdentityCheck selectByPrimaryKey(Integer id);

    List<IdentityCheck> selectAll();

    int updateByPrimaryKey(IdentityCheck record);
}