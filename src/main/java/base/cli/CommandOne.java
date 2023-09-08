package base.cli;

import io.dropwizard.cli.Command;
import io.dropwizard.setup.Bootstrap;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;

public class CommandOne extends Command {
    public CommandOne() {
        super("mycmd", "test command");
    }

    @Override
    public void configure(Subparser subparser) {
        subparser.addArgument("-n").dest("name").type(String.class).required(true).help("whats your name ? ");
    }

    @Override
    public void run(Bootstrap<?> bootstrap, Namespace namespace) throws Exception {
        System.out.println("Hello " + namespace.getString("name"));
    }
}
