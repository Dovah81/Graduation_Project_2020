package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.Investor;
import java.util.List;

public interface InvestorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Investor record);

    Investor selectByPrimaryKey(Integer id);

    List<Investor> selectAll();

    int updateByPrimaryKey(Investor record);
}