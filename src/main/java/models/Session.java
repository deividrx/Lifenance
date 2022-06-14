package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class Session {
    @ColumnName("user_id")
    private User user;
    @PrimaryKey("session_id")
    private String sessionId;

    public Session(User user, String sessionId) {
        this.user = user;
        this.sessionId = sessionId;
    }

    public Session(String args) { // Constructor for generic dao
        String[] split = args.split(";");
        this.user = ModelFactory.getModel(User.class, "users", Long.parseLong(split[0]));
        this.sessionId = split[1];
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
