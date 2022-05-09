package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.MainPage;
import utils.Base;

import java.io.IOException;

public class loginGlue extends Base {

    MainPage mp = new MainPage();
    LoginPage lp = new LoginPage();


    public loginGlue() throws IOException {
    }

    @And("^enter user name \"([^\"]*)\"$")
    public void enter_userName(String userName) throws IOException {
        lp.enterUserName(userName);

    }

    @And("^enter password \"([^\"]*)\"$")
    public void enter_password(String password) throws IOException {
        lp.enterpassword(password);

    }

    @And("click login button")
    public void click_login_button() throws IOException {
        lp.clickLogin();

    }

    @And("^validate error message \"([^\"]*)\"$")
    public void validate_error_message(String msg) throws IOException {
        lp.validateErrorMessage(msg);

    }


}

