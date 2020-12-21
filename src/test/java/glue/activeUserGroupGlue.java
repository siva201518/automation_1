package glue;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ActiveUserGroupPage;
import pages.MainPage;
import utils.Base;

import java.io.IOException;

public class activeUserGroupGlue extends Base {

    MainPage mp = new MainPage();
    ActiveUserGroupPage ap = new ActiveUserGroupPage();

    public activeUserGroupGlue() throws IOException {
    }

    @Then("^validating modules title \"([^\"]*)\"$")
    public void validating_modules_title(String title) {
        String text = null;
        try {
            text = ap.getModuleTitle();
            Assert.assertEquals(text, title);
            System.out.println("Page title: " + text);


        } catch (Exception e) {
            System.out.println("Page titles are not matching" + text);
        }
    }

    @Then("print result user group names")
    public void print_result_user_group_names() throws IOException {
        ap.getUserGroupNames();
    }


    @Then("^validating result user group counts are greater than \"([^\"]*)\" events$")
    public void validating_result_user_group_counts_are_greater_than_events(Integer count) throws IOException {
        ap.getUserGroupCount(count);

    }

}
