import java.lang.management.ManagementFactory
import java.nio.charset.Charset

def logFile = "build/tomcat/logs/spring-exec.log"
def logLevel = INFO

appender("FILE", RollingFileAppender) {
    file = logFile
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "build/tomcat/logs/archive/spring.log.%d{yyyyMMdd}.zip"
        maxHistory = 7
    }
    encoder(PatternLayoutEncoder) {
        charset = StandardCharsets.UTF_8
        pattern = "%d %p %t - %m%n"
    }
}

appender("STDOUT", ConsoleAppender) {
    target = "System.out"
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} %p %m%n"
    }
}

root(logLevel, ["FILE"])
