package com.njusoft.grapro20.serviceImpl;

import com.njusoft.grapro20.mapper.InvestorMapper;
import com.njusoft.grapro20.model.Investor;
import com.njusoft.grapro20.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    private InvestorMapper investorMapper;

    @Override
    public Map<String,Object> login(Investor investor){
        Map<String,Object> result = new HashMap<>();
        int code = 0;
        Investor qInvestor =investorMapper.selectByPrimaryKey(investor.getId());
        if(qInvestor == null){ //用户名错误
            code = 1;
        }else{
            if(!qInvestor.getPassword().equals(investor.getPassword())){ //密码错误
                code = 2;
            }
        }
        result.put("code",code);
        result.put("investor",qInvestor);
        return result;
    }
}
