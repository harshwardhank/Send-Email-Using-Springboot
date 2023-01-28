package com.email.email.model;

public class EmailRequest {

    private String from;
    private String to;
    private String to1;
    public String getTo1() {
        return to1;
    }
    public void setTo1(String to1) {
        this.to1 = to1;
    }
    private String message;
    private String subject;
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public EmailRequest(String from, String to, String to1, String message, String subject) {
        super();
        this.from = from;
        this.to = to;
        this.to1 = to1;
        this.message = message;
        this.subject = subject;
    }
    public EmailRequest() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "EmailRequest [from=" + from + ", to=" + to + ", to1=" + to1 + ", message=" + message + ", subject=" + subject + "]";
    }

}
