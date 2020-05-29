package com.njusoft.grapro20.controller;

import com.njusoft.grapro20.model.Investor;
import com.njusoft.grapro20.service.InvestorService;
import com.njusoft.grapro20.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/investor")
public class InvestorController {
    @Resource
    private InvestorService investorService;

    @RequestMapping("login")
    public ResultVO login(@RequestBody Investor investor){
        Map<String,Object> result=investorService.login(investor);
        Integer code = (Integer)result.get("code");
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        switch (code){
            case 0:
                resultVO.setMsg("登录成功");
                resultVO.setObject(result.get("investor"));
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
