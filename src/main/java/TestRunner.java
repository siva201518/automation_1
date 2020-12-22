import io.cucumber.junit.Cucumber;
import io.cucumber.core.api.*;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.AllTests;


import java.util.Base64;

@RunWith(Cucumber.class)

@CucumberOptions
        (
                features = "src/test/resources/features",
                //  glue= {"classpath:glue"},
                glue = {""},
              //  tags = "@repositoriesPerProgramming",
                stepNotifications = true,
                // plugin = {"pretty", "html:target/report/cucumber.html", "json:target/report/cucumber.json", "junit:target/report/cucumber.xml"},
                monochrome = true,
                plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"}


        )
public class TestRunner {

    public static void main(String[] args) {
        System.out.println("************Test statements*********************");
        io.cucumber.core.cli.Main.run(args, ClassLoader.getSystemClassLoader());


    }
}



