package app.controller.model;

import java.util.List;

public class StudentJSON {
    private String firstname;
    private String lastname;
    private Integer age;
    private String school;
    private List<String> programmingLanguages;

    public StudentJSON() {
    }

    public StudentJSON(String firstname, String lastname, Integer age, String school, List<String> programmingLanguages) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.school = school;
        this.programmingLanguages = programmingLanguages;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
}
