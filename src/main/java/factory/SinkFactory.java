package factory;

import models.LogLevel;
import models.SinkType;
import sink.ConsoleSink;
import sink.FileSink;
import sink.Sink;

public class SinkFactory {

    private SinkFactory(){

    }

    public static Sink getSink(SinkType sinkType, LogLevel logLevel) {

        if (sinkType.equals(SinkType.STDOUT)) {
            return new ConsoleSink(logLevel);
        }
        else if(sinkType.equals(SinkType.FILE)){
            return new FileSink(logLevel);
        }
        System.out.println("Sink type "+ sinkType + " not supported!!");
        return null;
    }
}
