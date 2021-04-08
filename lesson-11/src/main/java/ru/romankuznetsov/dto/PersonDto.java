package ru.romankuznetsov.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonDto {
    @NotNull
    private String firstName;
    @NotBlank(message = "Фамилия не должна быть пустой")
    private String secondName;
    private Long cityId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
