package com.huseyin.registerform;

/**
 * Created by huseyin on 13.01.2017.
 */
public class Student {

   String name, email,number;

    public Student(){

    }

    public Student(String name, String number, String email) {
        this.name = name;
        this.email = email;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
