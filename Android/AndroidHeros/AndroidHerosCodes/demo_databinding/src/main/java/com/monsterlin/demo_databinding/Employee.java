package com.monsterlin.demo_databinding;

/**
 * Created by  monsterLin on 2016/11/3.
 */

public class Employee {
    private String firstName ;
    private String lastName ;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
