package wood.mike

class LoggingEvent {

    Long eventId
    Long timestmp
    String formattedMessage
    String loggerName
    String levelString
    String threadName
    Integer referenceFlag
    String arg0
    String arg1
    String arg2
    String arg3
    String callerFilename
    String callerClass
    String callerMethod
    String callerLine

    static mapping = {
        id name: 'eventId'
        version false
        autoTimestamp false
        datasource 'loggingDs'
    }

    static constraints = {
    }
}
