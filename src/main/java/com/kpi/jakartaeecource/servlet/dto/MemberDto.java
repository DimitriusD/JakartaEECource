package com.kpi.jakartaeecource.servlet.dto;

public class MemberDto {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String jobTitle;
    private final String description;

    private final String photoUrl;

    public MemberDto(int id,
                     String firstName,
                     String lastName,
                     int age,
                     String jobTitle,
                     String description,
                     String photoUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.jobTitle = jobTitle;
        this.description = description;
        this.photoUrl = photoUrl;
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

    public String getPhotoUrl() {
        return photoUrl;
    }
}
