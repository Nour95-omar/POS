package se.kth.iv1350.Util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;
import java.io.IOException;


/**
 * This class is responsible for the log
 */
public class FileLogHandler {
    private static final FileLogHandler FILE_LOG_HANDLER = new FileLogHandler();
    //private static final String Log_File_Name="/Users/nourbshar/Desktop/seminar4/log.txt";
    private static final String Log_File_Name="log.txt";
    private PrintWriter printWriter;



    private FileLogHandler() {
        try {
            printWriter = new PrintWriter(new FileWriter(Log_File_Name),true);
        }
        catch (IOException exc){
            System.out.println("The log could not created");
            exc.printStackTrace();
        }
    }

    public static FileLogHandler getLogger()
    {
        return FILE_LOG_HANDLER;
    }

    /**
     * This method prints log entry which describes the thrown exception..
     * @param exception the exception that shall be logged.
     */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append("*******************************");
        logMsgBuilder.append("            Log            \n");
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        printWriter.println(logMsgBuilder);
        exception.printStackTrace(printWriter);
        }

    private String createTime() {
         LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
        }
}
