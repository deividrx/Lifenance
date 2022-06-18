package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class Session {
    @PrimaryKey("id_session")
    private String sessionId;
    @ColumnName("validator")
    private String validator;
    @ColumnName("user_cpf")
    private User user;

    public Session() {
    }

    public Session(String sessionId, User user, String validator) {
        this.sessionId = sessionId;
        this.user = user;
        this.validator = validator;
    }

    public Session(String args) { // Constructor for generic dao
        String[] split = args.split(";");
        this.sessionId = split[0];
        this.validator = split[1];
        this.user = ModelFactory.getModel(User.class, "users", split[2]);
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
