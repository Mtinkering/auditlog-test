package com.example.auditLog.service;

import com.example.auditLog.entity.Person;
import com.example.auditLog.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void save(Person person) {

        this.personRepository.save(person);
    }

    public void update(Person person) {
        Long id = person.getId();

//        Example<Person> example = Example.of(id);

        updatedPerson(this.personRepository.findById(id).get(), person);
    }

    private Person updatedPerson(Person existingPerson, Person updatedPerson) {
        if (StringUtils.isNotBlank(updatedPerson.getName())) {
            existingPerson.setName(updatedPerson.getName());
        }

        if (updatedPerson.getAge() != 0) {
            existingPerson.setAge(updatedPerson.getAge());
        }

        if (updatedPerson.getGender() != null) {
            existingPerson.setGender(updatedPerson.getGender());
        }

        return this.personRepository.save(existingPerson);
    }
}