public class App {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started");
        logger.log("Performing some operations");
        logger.close();
    }
}
