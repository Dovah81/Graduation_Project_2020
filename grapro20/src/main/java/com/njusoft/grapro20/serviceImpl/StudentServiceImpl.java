package com.njusoft.grapro20.serviceImpl;

import com.njusoft.grapro20.mapper.StudentMapper;
import com.njusoft.grapro20.model.Student;
import com.njusoft.grapro20.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Map<String,Object> login(Student student){
        Map<String,Object> result = new HashMap<>();
        int code = 0;
        Student qStudent =studentMapper.selectByPrimaryKey(student.getId());
        if(qStudent == null){ //用户名错误
            code = 1;
        }else{
            if(!qStudent.getPassword().equals(student.getPassword())){ //密码错误
                code = 2;
            }
        }
        result.put("code",code);
        result.put("student",qStudent);
        return result;
    }
}
