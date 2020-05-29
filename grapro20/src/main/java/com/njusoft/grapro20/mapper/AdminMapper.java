package com.njusoft.grapro20.mapper;

import com.njusoft.grapro20.model.Admin;
import com.njusoft.grapro20.model.Student;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);

    List<Student> selStudentMes(Integer userid);
}