package com.dipakkr.github.clashhackproject.Employee;

/**
 * Created by admin on 25-03-2017.
 */

public class Employee {

    public String empname;
    public String age;
    public String gender;
    public String mobile;
    public String city;
    public String qualification;
    public String skill;
    public String skill_experience;
    public String skill_auth;
    public String empimage;

    public Employee(){
    }
    public Employee(String empname, String age, String gender, String mobile,
                    String city, String qualification, String skill, String skill_experience, String skill_auth,String empimage ){
        this.empname = empname;
        this.age = age;
        this.gender = gender;
        this.mobile = mobile;
        this.city = city;
        this.qualification = qualification;
        this.skill = skill;
        this.skill_experience = skill_experience;
        this.skill_auth =skill_auth;
        this.empimage = empimage;
    }

    public String getEmpimage() {
        return empimage;
    }

    public String getEmpname() {
        return empname;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCity() {
        return city;
    }

    public String getQualification() {
        return qualification;
    }

    public String getSkill() {
        return skill;
    }

    public String getSkill_experience() {
        return skill_experience;
    }

    public String getSkill_auth() {
        return skill_auth;
    }
}
