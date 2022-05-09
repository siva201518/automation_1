package glue;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.MainPage;
import utils.Base;


import java.io.IOException;

public class MainPageGlue extends Base {
    MainPage mp = new MainPage();

    LoginPage lp = new LoginPage();

    public MainPageGlue() throws IOException {


    }


    @Given("^user navigate to The Internet Home page$")
    public void login_to_the_application() throws InterruptedException {
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


    @And("click authentication link")
    public void click_authentication_link() throws IOException {
        mp.clickAuthentication();

    }


    @And("^close browser$")
    public void close_browser() {
        driver.close();
        System.out.println("Closed browser ");
    }


}
