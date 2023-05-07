package com.example.demo.modal;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final UUID id;
    public UUID getId() {
        return id;
    }
    private final String name;
    public String getName() {
        return name;
    }
    public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

}
