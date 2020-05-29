package com.njusoft.grapro20.model;

import java.util.Date;

public class ProjectMember {
    private Integer id;

    private Integer projectId;

    private Integer studentId;

    private Date cretime;

    private Integer ifchecked;

    private Date lastchecktime;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}