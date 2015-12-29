package classloader.impl;

import com.jmp.classloader.Hello;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HelloSpaceImpl implements Hello {

    static final Logger logger = LogManager.getLogger(HelloSpaceImpl.class.getName());

    @Override
    public void sayHello() {

        logger.info("Hello space!");
    }
}
