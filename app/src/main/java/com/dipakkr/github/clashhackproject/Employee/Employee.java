package com.dipakkr.github.clashhackproject.Employee;

/**
 * Created by admin on 25-03-2017.
 */

public class Employee {
    private String username;
    private String empname;
    private String age;
    private String gender;
    private String mobile;
    private String city;
    private String qualification;
    private String skill_name;
    private String skill_experience;
    private String skill_auth;


    public Employee() {

    }

    public Employee(String username, String empname, String age, String gender, String mobile, String city,
                    String qualification, String skill_name, String skill_experience, String skill_auth) {
        this.empname = empname;
        this.age = age;
        this.gender = gender;
        this.mobile = mobile;
        this.city = city;
        this.qualification = qualification;
        this.skill_name = skill_name;
        this.skill_experience = skill_experience;
        this.skill_auth = skill_auth;
    }
}
