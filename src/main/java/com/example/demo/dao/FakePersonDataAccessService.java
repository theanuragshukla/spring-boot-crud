package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.modal.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> listAllPeople() {
        return db;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> toDelete = selectPersonById(id);
        if (toDelete.isEmpty())
            return 0;
        db.remove(toDelete.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(p -> {
                    int idx = db.indexOf(p);
                    if (idx >= 0) {
                        db.set(idx, person);
                        return 1;
                    } else
                        return 0;
                }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID uuid) {
        return db.stream()
                .filter(person -> person.getId().equals(uuid))
                .findFirst();
    }

}