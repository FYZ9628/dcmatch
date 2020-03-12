package com.example.dcmatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "contest")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Contest {

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

    int state;
    String ticketNumber;
    int score;

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
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
}
