package tech.paramount.cold;

import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.slf4j.Logger;

public class ResourceCracExample implements Resource {

    Logger log = org.slf4j.LoggerFactory.getLogger(ResourceCracExample.class);

    private static String password;

    public ResourceCracExample() {
        log.info("ResourceCracExample constructor called");
        Context<Resource> context = Core.getGlobalContext();
        context.register(this);
        password = loadPassword();
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        password = null;
        log.info("beforeCheckpoint() called");
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        password = loadPassword();
        log.info("afterRestore() called");
    }

    private String loadPassword() {
        return "password";
    }
}
