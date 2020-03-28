package com.example.dcmatch.model;

import javax.persistence.*;
import java.util.List;

public class TeamContestList {
    int id;
    private ContestDetail contestDetail;
    private List<Student> studentList;
    String teacherAccount;
    String teacherName;
    String state;
    String ticketNumber;
    int score;
    String teamName;
    int remarksIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContestDetail getContestDetail() {
        return contestDetail;
    }

    public void setContestDetail(ContestDetail contestDetail) {
        this.contestDetail = contestDetail;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRemarksIndex() {
        return remarksIndex;
    }

    public void setRemarksIndex(int remarksIndex) {
        this.remarksIndex = remarksIndex;
    }
}
