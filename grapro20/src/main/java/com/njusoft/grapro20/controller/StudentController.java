package com.njusoft.grapro20.controller;

import com.njusoft.grapro20.model.Student;
import com.njusoft.grapro20.service.StudentService;
import com.njusoft.grapro20.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("login")
    public ResultVO login(@RequestBody Student student){
        Map<String,Object> result=studentService.login(student);
        Integer code = (Integer)result.get("code");
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        switch (code){
            case 0:
                resultVO.setMsg("登录成功");
                resultVO.setObject(result.get("student"));
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

}
