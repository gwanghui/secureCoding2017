package oopsw.log.test;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTest {
	private static final Logger logger = Logger.getLogger(LogTest.class.getName());
    private FileHandler fileHandler;
 
    public LogTest() {
        addFileHandler(logger);
    }
 
    public static void main(String[] args) {
        logger.info("---main() Start---");
 
        LogTest le = new LogTest();
 
        // 정보로그
        logger.info("Info... log");
        // 오류로그
        logger.warning("Warning... log");
        // 에러로그
        logger.severe("Severe...  log");
 
        logger.info("---main() End---");
    }
 
    private void addFileHandler(Logger logger) {
        try {
            // 파일저장
            fileHandler = new FileHandler(LogTest.class.getName() + ".log");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        logger.addHandler(fileHandler);
    }
}
