package glue;

import io.cucumber.java.en.And;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import utils.Base;

import java.io.IOException;

public class homeGlue extends Base {

    MainPage mp = new MainPage();
    LoginPage lp = new LoginPage();
    HomePage hp = new HomePage();


    public homeGlue() throws IOException {
    }

    @And("^validate success message \"([^\"]*)\"$")
    public void validate_success_message(String msg) throws IOException {
        hp.validateSuccessMessage(msg);

    }


}

