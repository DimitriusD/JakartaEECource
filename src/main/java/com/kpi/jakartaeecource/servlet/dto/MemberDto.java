package com.kpi.jakartaeecource.servlet.dto;

public class MemberDto {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String jobTitle;
    private String description;

    public MemberDto(int id,
                     String firstName,
                     String lastName,
                     int age,
                     String jobTitle,
                     String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.jobTitle = jobTitle;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDescription() {
        return description;
    }
}
