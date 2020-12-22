package glue;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import javafx.scene.chart.Chart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.ActiveUserGroupPage;
import pages.MainPage;
import utils.Base;


import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class MainPageGlue extends Base {
    MainPage mp = new MainPage();

    ActiveUserGroupPage ap = new ActiveUserGroupPage();

    public MainPageGlue() throws IOException {


    }


    @Given("^user login to the application$")
    public void login_to_the_application() {
        Base.init();


    }

    @Then("^validating page title \"([^\"]*)\"$")
    public void validating_page_title(String title) {
        {
            String text = null;
            try {

                text = driver.getTitle();
                Assert.assertEquals(text, title);
                System.out.println("Page title are matching: Expected- " + title + " Actual- " + text);
            } catch (Exception e) {
                System.out.println("PageTitles are not matching: Expected- " + title + " Actual- " + text);

            }
        }
    }

    @And("^search with module name \"([^\"]*)\"$")
    public void search_with_module_name(String text) {
        mp.enterSearch(text);
    }

    @Then("^validate filtered modules matched with search string \"([^\"]*)\"$")
    public void validate_filtered_modules_matched_with_search_string(String moduleName) {
        mp.getModuleNames(moduleName);
    }

    @Given("^click module \"([^\"]*)\"$")
    public void click_module(String moduleName) throws IOException {
        mp.clickRepoLink(moduleName);

    }

    @Then("^validating module title \"([^\"]*)\"$")
    public void validating_module_title(String title) {
        String text = null;
        text = ap.getModuleTitle();
        try {
            Assert.assertEquals(text, title);
            System.out.println("Page title are matching: Expected- " + title + " Actual- " + text);
        } catch (Exception e) {
            System.out.println("PageTitles are not matching: Expected- " + title + " Actual- " + text);
            driver.quit();
        }


    }

    @And("^close browser$")
    public void close_browser() {
        driver.close();
        System.out.println("Closed browser ");
    }


}
