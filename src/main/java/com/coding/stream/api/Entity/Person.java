package com.coding.stream.api.Entity;

import java.util.ArrayList;
import java.util.List;

import static com.coding.stream.api.Entity.Person.Sex.FEMALE;
import static com.coding.stream.api.Entity.Person.Sex.MALE;

public class Person {

    public enum Sex{
        MALE,FEMALE
    }

    String name;
    int age;
    String emailAddress;
    Sex gender;

    public Person() {
    }

    public Person(String name, int age, String emailAddress, Sex gender) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender=" + gender +
                '}';
    }

    public void getPersonDetail(){
        System.out.println(this.toString());
    }

    public static List<Person> getDefaultPerson(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("aaaa",22,"aaaa@gmail.com",MALE));
        people.add(new Person("bbbb",54,"bbbb@gmail.com",FEMALE));
        people.add(new Person("cccc",25,"cccc@gmail.com",MALE));
        people.add(new Person("dddd",76,"dddd@gmail.com",FEMALE));

        return people;
    }
}
