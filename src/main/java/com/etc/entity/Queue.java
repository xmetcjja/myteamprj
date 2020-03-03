package com.etc.entity;

public class Queue {

    private String queueNo;
    private String busiType;
    private String queueTime;
    private String queueStatus;

    public String getQueueNo() {
        return queueNo;
    }

    public void setQueueNo(String queueNo) {
        this.queueNo = queueNo;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(String queueTime) {
        this.queueTime = queueTime;
    }

    public String getQueueStatus() {
        return queueStatus;
    }

    public void setQueueStatus(String queueStatus) {
        this.queueStatus = queueStatus;
    }

    public Queue(String queueNo, String busiType, String queueTime, String queueStatus) {
        this.queueNo = queueNo;
        this.busiType = busiType;
        this.queueTime = queueTime;
        this.queueStatus = queueStatus;
    }

    public Queue() {
    }
}
