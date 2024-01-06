package sink;

import models.LogLevel;
import models.LogMessage;

public class ConsoleSink implements Sink {
    private LogLevel logLevel;

    public ConsoleSink(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void logMessage(LogMessage message) {
        if (message.getLevel().ordinal() >= logLevel.ordinal()) {
            System.out.println(message.getTimestamp() + " [" +message.getLevel()+"] " + message.getMessageContent());
        }
        else{
            System.out.println("Discarding the message as message has lower level!!");
        }
    }

    @Override
    public LogLevel getLogLevel() {
        return logLevel;
    }

}
