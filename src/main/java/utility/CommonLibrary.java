package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonLibrary {

    private static final String TIME_FORMAT = "dd-MM-yyyy-HH-mm-ss";

    private CommonLibrary(){
    }

    public static String getFormattedTimestamp(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static String getTimestampFormat(){
        return TIME_FORMAT;
    }
}
