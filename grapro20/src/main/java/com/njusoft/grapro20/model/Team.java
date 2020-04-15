package com.njusoft.grapro20.model;

public class Team {
    private Integer id;

    private String name;

    private String intro;

    private Integer leaderId;

    private Integer ifexcellentteam;

    private String reason;

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getIfexcellentteam() {
        return ifexcellentteam;
    }

    public void setIfexcellentteam(Integer ifexcellentteam) {
        this.ifexcellentteam = ifexcellentteam;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}