package com.example.dcmatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "contest_detail")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ContestDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    //对应于外键的名，整个列被外键的对象替换
    //多个作业可以对应多个教师
    @ManyToOne
    @JoinColumn(name="organizer_id")
    private Organizer organizer;

    String contestTitle;
    String contestContent;
    String startTime;
    String endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public String getContestTitle() {
        return contestTitle;
    }

    public void setContestTitle(String contestTitle) {
        this.contestTitle = contestTitle;
    }

    public String getContestContent() {
        return contestContent;
    }

    public void setContestContent(String contestContent) {
        this.contestContent = contestContent;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
