package base.tasks;

import io.dropwizard.servlets.tasks.Task;
import sun.util.logging.resources.logging;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class TestTask extends Task {
    public TestTask() {
        super("test-task");
    }

    @Override
    public void execute(Map<String, List<String>> map, PrintWriter printWriter) throws Exception {
        System.out.println("executing the test task");

        printWriter.println(("sdanjfjksdfns"));

    }
}
