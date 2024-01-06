package logger;

import models.LogMessage;

public interface Logger {
    void log(LogMessage message, String timestampFormat);
}
