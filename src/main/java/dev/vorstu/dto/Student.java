package dev.vorstu.dto;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "group")
    private String group;

    @Column(name = "phoneNumber")
    private String phoneNumber;


    public Student() {
    }

    public Student(String fio, String group, String phoneNumber) {
        this.fio = fio;
        this.group = group;
        this.phoneNumber = phoneNumber;
    }

    public Student(Long id, String fio, String group, String phoneNumber) {
        this.id = id;
        this.fio = fio;
        this.group = group;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
