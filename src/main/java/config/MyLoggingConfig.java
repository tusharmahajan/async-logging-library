package config;

import factory.LoggerFactory;
import factory.SinkFactory;
import logger.Logger;
import lombok.Getter;
import models.LogLevel;
import models.LogType;
import models.SinkType;
import sink.Sink;

import java.util.ArrayList;
import java.util.List;

@Getter
public
class MyLoggingConfig {

    private final Logger logger;

    public MyLoggingConfig(LogType logType, List<SinkType> sinkTypes, List<LogLevel> sinkLogLevels, int bufferSize) {

        if(bufferSize <= 0){
            throw new RuntimeException("Invalid buffer size for queue");
        }

        List<Sink> sinks = new ArrayList<>();
        for (int i = 0; i < Math.min(sinkTypes.size(), sinkLogLevels.size()); i++) {
            Sink sink = SinkFactory.getSink(sinkTypes.get(i), sinkLogLevels.get(i));
            if (sink != null) {
                sinks.add(sink);
            }
        }
        this.logger = LoggerFactory.getLogger(logType, sinks, bufferSize);
    }

}
