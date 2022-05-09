package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.io.IOException;

public class HomePage extends Base {

    public MainPage mp;
    public LoginPage lp;


    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public String txtMessage = "//div[@class='flash success']";


    public void validateSuccessMessage(String expMsg) throws IOException {

        try {
            String actualMsg = driver.findElement(By.xpath(txtMessage)).getText();
            System.out.println("Actual message as :" + actualMsg);
            Assert.assertTrue(actualMsg.contains(expMsg));
        } catch (NoSuchElementException e) {
            System.out.println("not able to view success msg");
        }
    }


}
