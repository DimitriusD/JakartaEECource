package com.kpi.jakartaeecource.servlet.dto;

public class ShortMemberInfoDto {

    private final int id;
    private final String firstName;
    private final String secondName;
    private final String jobTitle;
    private final int age;

    public ShortMemberInfoDto(int id, String firstName, String secondName, String jobTitle, int age) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getAge() {
        return age;
    }
}
