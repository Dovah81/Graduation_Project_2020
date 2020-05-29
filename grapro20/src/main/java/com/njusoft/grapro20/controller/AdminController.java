package com.njusoft.grapro20.controller;

import com.github.pagehelper.PageInfo;
import com.njusoft.grapro20.model.Admin;
import com.njusoft.grapro20.model.Student;
import com.njusoft.grapro20.service.AdminService;
import com.njusoft.grapro20.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class  AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping("login")
    public ResultVO login(@RequestBody Admin admin){
        Map<String,Object> result=adminService.login(admin);
        Integer code = (Integer)result.get("code");
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        switch (code){
            case 0:
                resultVO.setMsg("登录成功");
                resultVO.setObject(result.get("admin"));
                break;
            case 1:
                resultVO.setMsg("用户名错误");
                break;
            case 2:
                resultVO.setMsg("密码错误");
                break;
        }
        return resultVO;
    }

    @RequestMapping("list/studentMes/{currPage}")
    public PageInfo<Student> listStudentMes(@PathVariable Integer currPage, @RequestBody Admin admin){
        return adminService.listStudentMes(admin.getId(),currPage);
    }
}