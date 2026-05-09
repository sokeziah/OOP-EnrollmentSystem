package org.example.model;

public abstract class Person {
    private String personId;
    protected String personFullName;

    public Person(String personId, String personFullName) {
        this.personId = personId;
        this.personFullName = personFullName;
    }

    public String getPersonId() {
        return personId;
    }

    public String getPersonFullName() {
        return personFullName;
    }

    public void setPersonFullName(String personFullName) {
        this.personFullName = personFullName;
    }

    // Abstract method to be handled by Services later
    public abstract void displayProfile();
}