package glue;

import io.cucumber.java.en.Then;
import pages.MainPage;
import pages.ReposPerProgramPage;
import utils.Base;

import java.io.IOException;

public class repositoriesPerProgramGlue extends Base {

    ReposPerProgramPage rp = new ReposPerProgramPage();
    MainPage mp = new MainPage();

    public repositoriesPerProgramGlue() throws IOException {

    }

    @Then("^select \"([^\"]*)\" radio button$")
    public void select_radio_button(String languageName) throws IOException {
        rp.selectRadioButton(languageName);

    }


    @Then("^validating results based on languages selected$")
    public void validating_results_based_on_languages_selected() throws IOException {
        rp.selectLangList();

    }
}
