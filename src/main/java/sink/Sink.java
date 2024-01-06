package sink;

import models.LogLevel;
import models.LogMessage;

public interface Sink {

    void logMessage(LogMessage message);
    LogLevel getLogLevel();

}
