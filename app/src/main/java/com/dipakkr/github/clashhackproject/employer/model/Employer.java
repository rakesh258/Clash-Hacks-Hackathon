package com.dipakkr.github.clashhackproject.employer.model;

/**
 * Created by deepak on 26-03-2017.
 */

public class Employer {
    public String org_name;
    public String org_intro;
    public String org_city;
    public String org_mobile;
    public String org_email;
    public String skills_required;

    public Employer(){
    }

    public Employer(String org_name,String org_intro, String org_city, String org_mobile,String org_email, String skills_required){
        this.org_name= org_name;
        this.org_intro = org_intro;
        this.org_city = org_city;
        this.org_email = org_email;
        this.org_mobile = org_mobile;
        this.skills_required = skills_required;
    }

    public String getOrg_name() {
        return org_name;
    }

    public String getOrg_intro() {
        return org_intro;
    }

    public String getOrg_city() {
        return org_city;
    }

    public String getOrg_mobile() {
        return org_mobile;
    }

    public String getOrg_email() {
        return org_email;
    }

    public String getSkills_required() {
        return skills_required;
    }
}
