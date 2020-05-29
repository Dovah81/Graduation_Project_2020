package com.njusoft.grapro20.service;

import com.njusoft.grapro20.model.Investor;

import java.util.Map;

public interface InvestorService {
    Map<String,Object> login(Investor investor);
}
