package com.njusoft.grapro20.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.mapper.AdminMapper;
import com.njusoft.grapro20.mapper.StudentMapper;
import com.njusoft.grapro20.model.Admin;
import com.njusoft.grapro20.model.Student;
import com.njusoft.grapro20.service.AdminService;
import com.njusoft.grapro20.util.Define;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Map<String,Object> login(Admin admin){
        Map<String,Object> result = new HashMap<>();
        int code = 0;
        Admin qAdmin =adminMapper.selectByPrimaryKey(admin.getId());
        if(qAdmin == null){ //用户名错误
            code = 1;
        }else{
            if(!qAdmin.getPassword().equals(admin.getPassword())){ //密码错误
                code = 2;
            }
        }
        result.put("code",code);
        result.put("admin",qAdmin);
        return result;
    }

    @Override
    public PageInfo<Student> listStudentMes(Integer userid, Integer currPage){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Student> pageInfo = new PageInfo<>(studentMapper.selStudentMes(userid));
        return pageInfo;
    }
}
