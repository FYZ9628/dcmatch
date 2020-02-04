package com.example.dcmatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Student {
    //定义主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    //对应于外键的名，整个列被外键的对象替换
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    String phone;
    String name;
    String sex;

    //对应于外键的名，整个列被外键的对象替换
    @OneToOne
    @JoinColumn(name="academy_id")
    Academy academy;


    //对应于外键的名，整个列被外键的对象替换
    @OneToOne
    @JoinColumn(name="grade_id")
    Grade grade;

    //对应于外键的名，整个列被外键的对象替换
    @OneToOne
    @JoinColumn(name="major_id")
    Major major;

    //对应于外键的名，整个列被外键的对象替换
    @OneToOne
    @JoinColumn(name="class_id")
    Class mClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Class getmClass() {
        return mClass;
    }

    public void setmClass(Class mClass) {
        this.mClass = mClass;
    }
}
