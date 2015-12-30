package classloader.impl;
import com.jmp.classloader.Hello;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HelloImpl implements Hello {

    static final Logger logger = LogManager.getLogger(HelloImpl.class.getName());
    @Override
    public void sayHello() {

        logger.info("Hello world!");
       // logger.info("Hello space!");
    }
}
