package com.quesra.quesra.dto;

import com.quesra.quesra.domain.User;

public class SpaceDto {

    private String name;

    private String email;

    public SpaceDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
