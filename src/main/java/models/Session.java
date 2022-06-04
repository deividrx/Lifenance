package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class Session {
    @ColumnName("user_id")
    private User user;
    @ColumnName("session_id")
    private Long sessionId;

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
