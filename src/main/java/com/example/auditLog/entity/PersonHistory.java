package com.example.auditLog.entity;

import com.example.auditLog.action.Action;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PersonHistory {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "FK_person_history_person"))
    private Person person;

    @OneToOne
    @JoinColumn(name = "changelog_id", foreignKey = @ForeignKey(name = "FK_person_history_change_log"))
    private ChangeLog changeLog;

    private String personContent;

    @CreatedBy
    private String modifiedBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date modifiedDate;

    @Enumerated(STRING)
    private Action action;

    public PersonHistory() {
    }

    public PersonHistory(Person person, Action action, ChangeLog changelog) {
        this.person = person;
        this.personContent = person.toString();
        this.action = action;
        this.changeLog = changelog;
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPersonContent() {
        return personContent;
    }

    public void setPersonContent(String personContent) {
        this.personContent = personContent;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public ChangeLog getChangeLog() {
        return changeLog;
    }

    public void setChangeLog(ChangeLog changeLog) {
        this.changeLog = changeLog;
    }
}