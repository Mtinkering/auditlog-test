package com.example.auditLog.entity;

import com.example.auditLog.listener.PersonEntityListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "person")
@EntityListeners({PersonEntityListener.class})
//public class Person extends Auditable<String> {
public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Character gender;

    @Column
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }


//    @Override
//    public String toString() {
//        return "File{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
}