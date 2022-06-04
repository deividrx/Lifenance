package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class User {

    @PrimaryKey("user_cpf")
    private String cpf;
    @ColumnName("username")
    private String name;
    @ColumnName("user_password")
    private String password;

    public User(String args) {
        String[] array = args.split(";");
        this.cpf = array[0];
        this.name = array[1];
        this.password = array[2];
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User={" +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
