package factory;

import logger.AsyncLogger;
import logger.Logger;
import logger.SyncLogger;
import models.LogType;
import sink.Sink;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class LoggerFactory {

    private LoggerFactory(){

    }

    public static Logger getLogger(LogType logType, List<Sink> sinks, int bufferSize) {

        if (logType.equals(LogType.ASYNC)) {
            return new AsyncLogger(sinks, new ArrayBlockingQueue<>(bufferSize));
        }
        return new SyncLogger(sinks);
    }
}
