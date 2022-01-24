package glue;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CelebrityPage;
import pages.MainPage;
import utils.Base;


import java.io.IOException;

public class MainPageGlue extends Base {
    MainPage mp = new MainPage();

    CelebrityPage cp = new CelebrityPage();

    public MainPageGlue() throws IOException {


    }


    @Given("^user navigate to the Wikipedia Home page$")
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

    @And("^search with celebrity name \"([^\"]*)\"$")
    public void search_with_module_name(String text) throws IOException {
        mp.enterSearch(text);
    }

    @And("^click language link \"([^\"]*)\"$")
    public void search_with_lang_name(String text) throws IOException {
        mp.clickLanguage(text);
    }


    @And("^close browser$")
    public void close_browser() {
        driver.close();
        System.out.println("Closed browser ");
    }


}
