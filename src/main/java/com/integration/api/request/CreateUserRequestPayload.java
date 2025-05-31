package com.integration.api.request;

import java.time.LocalDate;

public class CreateUserRequestPayload {

    private int id;
    private String name;
    private LocalDate birthDate;

    public CreateUserRequestPayload(Integer id, String name, LocalDate birthDate)
    {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "CreateUserRequestPayload{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
