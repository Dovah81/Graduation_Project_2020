package com.njusoft.grapro20.model;

import lombok.Data;

@Data
public class ProjectStat {
    //用户ID
    private Integer userId;

    //查询的年份
    private String year;

    //返回结果的月份
    private String month;

    //返回结果的消费金额
    private int num;

    @Override
    public String toString() {
        return "ProjectStat{" +
                "userId=" + userId +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", num=" + num +
                '}';
    }
}
