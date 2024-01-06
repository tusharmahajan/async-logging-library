package logger;

import models.LogMessage;
import sink.Sink;
import utility.CommonLibrary;

import java.util.List;

public class SyncLogger implements Logger {
    private final List<Sink> sinks;

    public SyncLogger(List<Sink> sinks) {
        this.sinks = sinks;
    }

    @Override
    public void log(LogMessage message, String timestampFormat) {
        for (Sink sink : sinks) {
            message.setTimestamp(CommonLibrary.getFormattedTimestamp(timestampFormat));
            sink.logMessage(message);
        }
    }

}

