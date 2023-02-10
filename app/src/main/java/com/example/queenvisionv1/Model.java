package com.example.queenvisionv1;

public class Model {

    String id, name, lastname, age, cell, grade, city, topicofinterest;
    public Model(){}

    public Model(String id, String name, String lastname, String age, String cell, String grade, String city, String topicofinterest){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.cell = cell;
        this.grade = grade;
        this.city = city;
        this.topicofinterest = topicofinterest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTopicofinterest() {
        return topicofinterest;
    }

    public void setTopicofinterest(String topicofinterest) {
        this.topicofinterest = topicofinterest;
    }
}
