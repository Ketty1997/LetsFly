package com.letsfly.form;

public class FormUserPassword {
    private int id;
    private String oldpassword,newpassword,checknewpassword;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOldpassword() {
        return oldpassword;
    }
    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }
    public String getNewpassword() {
        return newpassword;
    }
    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
    public String getChecknewpassword() {
        return checknewpassword;
    }
    public void setChecknewpassword(String checknewpassword) {
        this.checknewpassword = checknewpassword;
    }
    
}
