package com.njusoft.grapro20.service;

import com.njusoft.grapro20.model.Student;

import java.util.Map;

public interface StudentService {

    Map<String,Object> login(Student student);
}
