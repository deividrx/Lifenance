package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class Flag {

    @PrimaryKey("flag_id")
    private long id;
    @ColumnName("flag_name")
    private String name;

    public Flag(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Flag(String args) { // Constructor for generic dao
        String[] split = args.split(";");
        this.id = Long.parseLong(split[0]);
        this.name = split[1];
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
