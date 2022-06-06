package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class User {

    @ColumnName("first_name")
    private String fisrtName;
    @ColumnName("last_name")
    private String lastName;
    @PrimaryKey("user_cpf")
    private String cpf;
    @ColumnName("user_email")
    private String email;
    @ColumnName("user_password")
    private String pwd;

    public User(String args) {
        String[] arg = args.split(";");
        this.fisrtName = arg[0];
        this.lastName = arg[1];
        this.cpf = arg[2];
        this.email = arg[3];
        this.pwd = arg[4];
    }

    public User(String fisrtName, String lastName, String cpf, String email, String pwd) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.pwd = pwd;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
