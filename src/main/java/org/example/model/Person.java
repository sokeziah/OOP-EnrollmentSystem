package org.example.model;

public abstract class Person {
    private String PersonID;
    private String PersonName;

    public Person() {

    }

    public String getPersonID(){
        return PersonID;

    }
    public void setPersonID(String PersonID){
        this.PersonID = PersonID;

    }
    public String getPersonName(){
        return PersonName;

    }
    public void setPersonName(String name){

        this.PersonName = PersonName;
    }

    public abstract void mainTask();

}
