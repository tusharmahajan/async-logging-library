package logger;

import models.LogMessage;
import sink.Sink;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class AsyncLoggerWorker implements Runnable {

    private final BlockingQueue<LogMessage> messageBlockingQueue;
    private final List<Sink> sinks;

    public AsyncLoggerWorker(BlockingQueue<LogMessage> messageBlockingQueue, List<Sink> sinks) {
        this.sinks = sinks;
        this.messageBlockingQueue = messageBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                LogMessage message = messageBlockingQueue.take();
                for (Sink sink : sinks) {
                    sink.logMessage(message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
