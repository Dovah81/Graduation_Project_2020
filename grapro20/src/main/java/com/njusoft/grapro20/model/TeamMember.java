package com.njusoft.grapro20.model;

import java.util.Date;

public class TeamMember {
    private Integer id;

    private Integer teamId;

    private Integer studentId;

    private Date cretime;

    private Integer ifchecked;

    private Date lastchecktime;

    private String repeat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getCretime() {
        return cretime;
    }

    public void setCretime(Date cretime) {
        this.cretime = cretime;
    }

    public Integer getIfchecked() {
        return ifchecked;
    }

    public void setIfchecked(Integer ifchecked) {
        this.ifchecked = ifchecked;
    }

    public Date getLastchecktime() {
        return lastchecktime;
    }

    public void setLastchecktime(Date lastchecktime) {
        this.lastchecktime = lastchecktime;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat == null ? null : repeat.trim();
    }
}