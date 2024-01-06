import config.MyLoggingConfig;
import logger.Logger;
import models.LogLevel;
import models.LogMessage;
import models.LogType;
import models.SinkType;
import utility.CommonLibrary;

import java.util.ArrayList;
import java.util.List;

public class LoggingSimulator {

        public static void main(String[] args) {

            List<SinkType> sinkTypes = new ArrayList<>();
            sinkTypes.add(SinkType.STDOUT);
            sinkTypes.add(SinkType.STDOUT);

            List<LogLevel> sinkLogLevels = new ArrayList<>();
            sinkLogLevels.add(LogLevel.INFO);
            sinkLogLevels.add(LogLevel.DEBUG);

            MyLoggingConfig myLoggingConfig = new MyLoggingConfig(LogType.ASYNC, sinkTypes, sinkLogLevels, 10);
            Logger logger = myLoggingConfig.getLogger();

            LogMessage fatalMessage = new LogMessage("System has encountered an error!!", LogLevel.FATAL);
            LogMessage infoMessage = new LogMessage("Hi I am info message", LogLevel.INFO);
            LogMessage debugMessage = new LogMessage("Debugging the code flow!! ", LogLevel.DEBUG);

            logger.log(fatalMessage, CommonLibrary.getTimestampFormat());
            logger.log(infoMessage, CommonLibrary.getTimestampFormat());
            logger.log(debugMessage, CommonLibrary.getTimestampFormat());
        }

}
