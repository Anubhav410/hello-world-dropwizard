package base;

import base.cli.CommandOne;
import base.health.TemplateHealthCheck;
import base.resources.HelloWorldResource;
import base.tasks.TestTask;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TutorialApplication extends Application<TutorialConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TutorialApplication().run(args);
    }

    @Override
    public String getName() {
        return "tutorial";
    }

    @Override
    public void initialize(final Bootstrap<TutorialConfiguration> bootstrap) {
        bootstrap.addCommand(new CommandOne());
    }

    @Override
    public void run(final TutorialConfiguration configuration, final Environment environment) {
        HelloWorldResource res = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(res);

        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);


        environment.admin().addTask(new TestTask());

    }
}
