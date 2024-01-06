package sink;

import models.LogLevel;
import models.LogMessage;


public class FileSink implements Sink{

    private LogLevel logLevel;

    public FileSink(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void logMessage(LogMessage message) {

        if (message.getLevel().ordinal() >= logLevel.ordinal()) {
            logToFile(message);
        }
        else{
            System.out.println("Discarding the message as message has lower level!!");
        }
    }

    @Override
    public LogLevel getLogLevel() {
        return logLevel;
    }

    private void logToFile(LogMessage message) {
        // leaving empty as of now, as requirement says this is optional
        // in future will dump the data to file
    }
}
