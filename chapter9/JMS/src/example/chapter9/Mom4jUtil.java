package example.chapter9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;

import org.mom4j.api.Mom4jConfig;
import org.mom4j.api.Mom4jDestination;
import org.mom4j.api.Mom4jFactory;

public final class Mom4jUtil {

    public static void startJmsServer() throws Exception {
        Mom4jFactory.start(new CustomConfig(), true);
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.mom4j.jndi.InitialCtxFactory");
        System.setProperty(Context.PROVIDER_URL, "xcp://localhost:8001");
    }

}

class CustomConfig implements Mom4jConfig {

    public int getPort() { return 4444; }
    public int getAdminPort() { return 8888; }
    public int getJndiPort() { return 8001; }
    public int getThreadCount() { return 3; }
    public int getSyncInterval() { return 500; }
    public int getAsyncInterval() { return 1000; }

    public List getUsers() { return new ArrayList(); }
    public List getContextHandlers() { return new ArrayList(); }

    public File getMessageStore() {
        File dir = new File("store/");
        dir.mkdirs();
        return dir;
    }

    public File getDurablesStore() {
        return new File("durable.dat");
    }

    @SuppressWarnings("unchecked")
    public List getDestinations() {
        List list = new ArrayList(1);
        list.add(new Mom4jDestination() {
            public String getName() {
                return "jms/queue";
            }
            public int getType() {
                return Mom4jDestination.QUEUE;
            }
        });
        return list;
    }

}
