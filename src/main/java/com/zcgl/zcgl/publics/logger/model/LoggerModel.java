package com.zcgl.zcgl.publics.logger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ld
 * @name 日志
 * @table
 * @remarks
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoggerModel {

    private String uuid;
    //    级别
    private String level;
    private String logger;
    private String thread;
    private String message;
    private long systime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getSystime() {
        return systime;
    }

    public void setSystime(long systime) {
        this.systime = systime;
    }

    public LoggerModel() {
        super();
    }

    public LoggerModel(String uuid, String level, String logger, String thread, String message, long systime) {
        this.uuid = uuid;
        this.level = level;
        this.logger = logger;
        this.thread = thread;
        this.message = message;
        this.systime = systime;
    }

    @Override
    public String toString() {
        return "LoggerModel{" +
                "uuid='" + uuid + '\'' +
                ", level='" + level + '\'' +
                ", logger='" + logger + '\'' +
                ", thread='" + thread + '\'' +
                ", message='" + message + '\'' +
                ", systime=" + systime +
                '}';
    }
}
