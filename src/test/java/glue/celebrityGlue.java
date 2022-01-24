package glue;

import io.cucumber.java.en.Then;
import pages.CelebrityPage;
import pages.MainPage;
import utils.Base;

import java.io.IOException;

public class celebrityGlue extends Base {

    MainPage mp = new MainPage();
    CelebrityPage cp = new CelebrityPage();

    public celebrityGlue() throws IOException {
    }


    @Then("^print celebrity birth day \"([^\"]*)\"$")
    public void print_result_celebrity_birthDay(String celebrityName) throws IOException {
        cp.getBirthDay(celebrityName);
    }

    @Then("^print celebrity spouse name \"([^\"]*)\"$")
    public void print_result_celebrity_SpouseName(String celebrityName) throws IOException {
        cp.getSpouseName(celebrityName);
    }


}
