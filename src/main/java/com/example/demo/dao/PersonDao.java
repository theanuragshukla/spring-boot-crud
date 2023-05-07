package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.modal.Person;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    List<Person> listAllPeople();
    int deletePersonById(UUID uuid);
    int updatePersonById(UUID uuid, Person person);
    Optional<Person> selectPersonById(UUID uuid);
}
