package com.kpi.jakartaeecource.model;

public class Member {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String jobTitle;
    private String fullDescription;
    private String photoUrt;

    public Member(int id,
                  String firstName,
                  String lastName,
                  int age,
                  String jobTitle,
                  String fullDescription, String photoUrt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.jobTitle = jobTitle;
        this.fullDescription = fullDescription;
        this.photoUrt = photoUrt;
    }

    public Member() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getPhotoUrt() {
        return photoUrt;
    }

    public void setPhotoUrt(String photoUrt) {
        this.photoUrt = photoUrt;
    }
}