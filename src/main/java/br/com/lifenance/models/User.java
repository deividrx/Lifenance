package br.com.lifenance.models;

import br.com.lifenance.models.annotations.ColumnName;
import br.com.lifenance.models.annotations.PrimaryKey;

public class User {

    @PrimaryKey("user_cpf")
    private String cpf;
    @ColumnName("first_name")
    private String firstName;
    @ColumnName("last_name")
    private String lastName;
    @ColumnName("user_email")
    private String email;
    @ColumnName("user_password")
    private String pwd;

    public User(String args) { // Constructor for generic dao
        String[] arg = args.split(";");
        this.cpf = arg[0];
        this.firstName = arg[1];
        this.lastName = arg[2];
        this.email = arg[3];
        this.pwd = arg[4];
    }

    public User(String fisrtName, String lastName, String cpf, String email, String pwd) {
        this.firstName = fisrtName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.pwd = pwd;
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
