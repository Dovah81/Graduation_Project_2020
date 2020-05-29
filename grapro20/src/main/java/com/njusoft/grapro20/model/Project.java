package com.njusoft.grapro20.model;

import java.util.Date;

public class Project {
    private Integer id;

    private String name;

    private String type;

    private String intro;

    private Double amount;

    private Integer studentId;

    private Date cretime;

    private Integer ifchecked;

    private Date lastchecktime;

    private String message;

    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", intro='" + intro + '\'' +
                ", amount=" + amount +
                ", studentId=" + studentId +
                ", cretime=" + cretime +
                ", ifchecked=" + ifchecked +
                ", lastchecktime=" + lastchecktime +
                ", message='" + message + '\'' +
                ", student=" + student +
                '}';
    }
}