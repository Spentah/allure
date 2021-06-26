import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"stepdefs", "hooks"}
)

public class TestRunner {
}
