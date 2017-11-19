package by.tms;

import java.util.Date;

public class Message {
    private String user;
    private String message;
    private Date msgDate;

    public Message(String user, String message, Date msgDate) {
        this.user = user;
        this.message = message;
        this.msgDate = msgDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }
}
