package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serialNum =1L;//pk

    @NotBlank
    private String id;

    @Column(length = 14)
    @NotBlank
    private String password;

    @Column(length = 10)
    @NotBlank
    private String name;

    @Column
    private int age;

    public Member(String id, String password, int age, String name) {
        this.id = id;
        this.password = password;
        this.age = age;
        this.name = name;
    }

    public Member() {
    }
}
