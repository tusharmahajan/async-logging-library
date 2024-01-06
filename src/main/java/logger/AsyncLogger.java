package logger;

import models.LogMessage;
import sink.Sink;
import utility.CommonLibrary;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class AsyncLogger implements Logger {
    private final List<Sink> sinks;
    private final BlockingQueue<LogMessage> messageQueue;

    public AsyncLogger(List<Sink> sinks, BlockingQueue<LogMessage> messageQueue) {
        this.sinks = sinks;
        this.messageQueue = messageQueue;
        submitTask();
    }

    @Override
    public void log(LogMessage message, String timestampFormat) {
        try {
            message.setTimestamp(CommonLibrary.getFormattedTimestamp(timestampFormat));
            messageQueue.put(message);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void submitTask() {
        Thread asyncLogger = new Thread(new AsyncLoggerWorker(messageQueue, sinks));
        asyncLogger.start();
    }
}