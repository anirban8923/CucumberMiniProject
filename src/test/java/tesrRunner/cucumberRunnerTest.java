package tesrRunner;


//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                // runner file should end with Test(eg cucumberRunnerTest.java) to execute it in maven mvn install , also
                // add in pom.xml
                /*<build>

        <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <encoding>UTF-8</encoding>
            </configuration>
        </plugin>
        </plugins>
    </build>*/
                // features=".//Features/",--to run all feature files
                //{".//Features/Customers.feature",".//Features/Login.feature"}, -- to run two feature files
               // tag for specific tag run scenarios
            features=".//Features/" ,
                glue="stepDefinations", // same as feature files for multiple step definations
                dryRun=false,
                monochrome = true,
                plugin={"pretty" ,
                        "html:Report/reports.html" ,
                        "json:Report/cucumber.json",
                        "junit:Report/reports.xml",

                },

                tags  = "@Regression or @Sanity" ,

                publish=true
        )
public class cucumberRunnerTest
{




}
