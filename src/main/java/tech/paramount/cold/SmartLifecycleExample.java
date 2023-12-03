package tech.paramount.cold;

import org.slf4j.Logger;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class SmartLifecycleExample implements SmartLifecycle {

    Logger log = org.slf4j.LoggerFactory.getLogger(SmartLifecycleExample.class);
    private volatile boolean running;
    private String password;

    public SmartLifecycleExample() {
        log.info("SmartLifecycleExample constructor called");
    }

    @Override
    public boolean isAutoStartup() {
        log.info("isAutoStartup() called");
        return SmartLifecycle.super.isAutoStartup();
    }

    @Override
    public void start() {
        running = true;
        password = loadPassword();
        log.info("Application restoring (start)");
    }

    @Override
    public void stop() {
        running = false;
        password = null;
        log.info("Checkpoint creating (stop)");
    }

    @Override
    public boolean isRunning() {
        log.info("isRunning() called");
        return running;
    }

    private String loadPassword() {
        return "password";
    }
}
