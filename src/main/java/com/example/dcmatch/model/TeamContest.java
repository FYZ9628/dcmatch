package com.example.dcmatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "team_contest")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class TeamContest {
    //主键定义，只能有一个，选择对应的列名
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    //对应于外键的名，整个列被外键的对象替换
    //多个作业可以对应一个被发布出来的作业模板
    @OneToOne
    @JoinColumn(name="contest_id")
    private ContestDetail contestDetail;

    //对应于外键的名，整个列被外键的对象替换
    //多个作业可以对应多个教师
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    String teacherAccount;
    String teacherName;
    String state;
    String ticketNumber;
    int score;
    String teamName;
    String remarks;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
