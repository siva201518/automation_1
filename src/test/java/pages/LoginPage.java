package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginPage extends Base {

    public MainPage mp;

    public String userId = "username";
    public String password = "password";

    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public String txtErrorMessage = "//div[@class='flash error']";

    public void enterUserName(String userName) throws IOException {


        try {
            driver.findElement(By.id(userId)).sendKeys(userName);

        } catch (NoSuchElementException e) {
            System.out.println("Not able to enter username");
        }
    }

    public void enterpassword(String Password) throws IOException {


        try {
            driver.findElement(By.id(password)).sendKeys(Password);

        } catch (NoSuchElementException e) {
            System.out.println("Not able to enter password");
        }
    }


    public void clickLogin() throws IOException {


        try {
            driver.findElement(By.cssSelector("[type='submit'][class='radius']")).click();
            System.out.println("clicked the login button ");


        } catch (NoSuchElementException e) {
            System.out.println("Not able to click login button");
        }

    }

    public void validateErrorMessage(String expMsg) throws IOException {

        try {
            String actualMsg = driver.findElement(By.xpath(txtErrorMessage)).getText();
            System.out.println("Actual message as :" + actualMsg);
            Assert.assertTrue(actualMsg.contains(expMsg));
        } catch (NoSuchElementException e) {
            System.out.println("not able to view error msg");
        }
    }


}
