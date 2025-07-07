public class LoggerSystemApplication {

    public static void main(String[] args) {
        System.out.println("---Logger System started---");
        Logger logger = Logger.getLoggerInstance();
        logger.info("INFO message");
        logger.debug("DEbug message");
        logger.error("Error message");
    }
}
