package com.njusoft.grapro20.service;

import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.model.Admin;
import com.njusoft.grapro20.model.Student;

import java.util.Map;

public interface AdminService {
    Map<String,Object> login(Admin admin);

    PageInfo<Student> listStudentMes(Integer userid, Integer currPage);
}
