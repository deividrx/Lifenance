package models;

import models.annotations.ColumnName;
import models.annotations.TableId;

public class User {

    @ColumnName("id_user")
    private long id;
    @ColumnName("cpf")
    private String cpf;
    @ColumnName("user_name")
    private String name;
    @ColumnName("user_password")
    private String password;

    public User(String args) throws NumberFormatException {
        String[] array = args.split(";");
        this.id = Long.parseLong(array[0]);
        this.cpf = array[1];
        this.name = array[2];
        this.password = array[3];
    }

    public long getId() {
        return id;
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
        return "User{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
