package glue;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CelebrityPage;
import pages.LanguagePage;
import pages.MainPage;
import utils.Base;

import java.io.IOException;

public class languageGlue extends Base {

    MainPage mp = new MainPage();
    CelebrityPage cp = new CelebrityPage();
    LanguagePage lp = new LanguagePage();

    public languageGlue() throws IOException {
    }


    @Then("^Validate page title for language \"([^\"]*)\"$")
    public void validating_lang_pageTitle(String title) {
        String text = null;

        try {
            text = driver.getTitle();
            Assert.assertEquals(text, title);
            System.out.println("Expected: " + title + " Actual: " + text);


        } catch (Exception e) {
            System.out.println("PageTitles are not matching: Expected- " + title + " Actual- " + text);
        }


    }
}
