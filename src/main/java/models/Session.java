package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class Session {
    @PrimaryKey("id_session")
    private long sessionId;
    @ColumnName("user_cpf")
    private User user;
    @ColumnName("selector")
    private String selector;
    @ColumnName("validator")
    private String validator;

    public Session() {
    }

    public Session(long sessionId, User user, String selector, String validator) {
        this.sessionId = sessionId;
        this.user = user;
        this.selector = selector;
        this.validator = validator;
    }

    public Session(String args) { // Constructor for generic dao
        String[] split = args.split(";");
        this.sessionId = Long.parseLong(split[0]);
        this.user = ModelFactory.getModel(User.class, "users", Long.parseLong(split[1]));
        this.selector = split[2];
        this.validator = split[3];
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
