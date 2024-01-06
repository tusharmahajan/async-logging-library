package models;

import lombok.Data;

@Data
public class LogMessage {

    private String messageContent;
    private LogLevel level;
    private String timestamp;

    public LogMessage(String messageContent, LogLevel level) {
        this.messageContent = messageContent;
        this.level = level;
    }
}