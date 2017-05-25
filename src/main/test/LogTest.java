import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zqh on 2017/5/25.
 */
public class LogTest {
    private static  final Logger LOGGER = Logger.getLogger(LogTest.class);
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSetCourseService() throws Exception {
        // 记录debug级别的信息
        LOGGER.debug("This is debug message.");
        // 记录info级别的信息
        LOGGER.info("This is info message.");
        // 记录warn级别的信息
        LOGGER.info("This is warn message.");
        // 记录error级别的信息
        LOGGER.error("This is error message.");
    }

}
