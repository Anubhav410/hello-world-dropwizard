package base.core;

import net.greghaines.jesque.Config;
import net.greghaines.jesque.ConfigBuilder;
import net.greghaines.jesque.Job;
import net.greghaines.jesque.client.Client;
import net.greghaines.jesque.client.ClientImpl;
import net.greghaines.jesque.utils.JesqueUtils;
import net.greghaines.jesque.worker.MapBasedJobFactory;
import net.greghaines.jesque.worker.Worker;
import net.greghaines.jesque.worker.WorkerImpl;

import java.util.Arrays;

public class ResqueTesting {
    public static void main(String[] args) throws InterruptedException {
        // Configuration
        final Config config = new ConfigBuilder().build();

// Add a job to the queue
        final Job job = new Job("TestAction",
                new Object[]{1, 2.3, true, "test", Arrays.asList("inner", 4.5)});
        final Client client = new ClientImpl(config);
        client.enqueue("foo", job);
        client.end();

// Start a worker to run jobs from the queue
        final Worker worker = new WorkerImpl(config,
                Arrays.asList("foo"), new MapBasedJobFactory(JesqueUtils.map(JesqueUtils.entry("TestAction", TestAction.class))));

        final Thread workerThread = new Thread(worker);
        workerThread.start();
        Thread.sleep(1000);
// Enqueue more jobs, etc.

// Shutdown the worker when finished
        worker.end(true);
        try {
            workerThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TestAction implements Runnable{

    @Override
    public void run() {
        System.out.println("I am here");
    }
}