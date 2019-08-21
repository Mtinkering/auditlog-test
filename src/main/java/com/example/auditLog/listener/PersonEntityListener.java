package com.example.auditLog.listener;

import com.example.auditLog.action.Action;
import com.example.auditLog.entity.ChangeLog;
import com.example.auditLog.entity.Person;
import com.example.auditLog.entity.PersonHistory;
import com.example.auditLog.util.BeanUtil;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import static com.example.auditLog.action.Action.DELETED;
import static com.example.auditLog.action.Action.INSERTED;
import static com.example.auditLog.action.Action.UPDATED;
import static javax.transaction.Transactional.TxType.MANDATORY;

public class PersonEntityListener {

    @PrePersist
    public void prePersist(Person target) {
        perform(target, INSERTED);
    }

    @PreUpdate
    public void preUpdate(Person target) {
        perform(target, UPDATED);
    }

    @PreRemove
    public void preRemove(Person target) {
        perform(target, DELETED);
    }

    @Transactional(MANDATORY)
    void perform(Person target, Action action) {
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        ChangeLog changeLog = new ChangeLog();

        entityManager.persist(changeLog);

        entityManager.persist(new PersonHistory(target, action, changeLog));
    }
}
