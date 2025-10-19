package dev.vorstu.dto;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "students")
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fio;

    @Column(name="group_of_students")
    private String group;

    //todo group - отдельная сущность

    private String phone_number;


    public Student() {
    }

    public Student(String fio, String group, String phone_number) {
        this.fio = fio;
        this.group = group;
        this.phone_number = phone_number;
    }

    public Student(Long id, String fio, String group, String phone_number) {
        this.id = id;
        this.fio = fio;
        this.group = group;
        this.phone_number = phone_number;
    }

//    //todo getter setter lombok, data - what generate

}
