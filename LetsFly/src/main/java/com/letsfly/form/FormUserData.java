package com.letsfly.form;

import com.letsfly.dto.UserDto;

public class FormUserData {
    private int id;
    private String name,surname,username;
    public FormUserData(){
        
    }
    public FormUserData(UserDto u){
        this.id=u.getId();
        this.name=u.getName();
        this.surname=u.getSurname();
        this.username=u.getUsername();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
}
