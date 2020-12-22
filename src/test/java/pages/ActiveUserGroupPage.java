package pages;

import com.google.common.base.Verify;
import utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class ActiveUserGroupPage extends Base {

    public MainPage mp;

    public ActiveUserGroupPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='graph-section']//h3")
    @CacheLookup
    WebElement titleModule;

    @FindBy(xpath = "//div[@class='graph-label']")
    @CacheLookup
    WebElement userGroupNames;

    @FindBy(xpath = "//div[@class='graph-bar']")
    @CacheLookup
    WebElement userGroupCount;


    public String getModuleTitle() {
        return titleModule.getText();
    }

    public <WebElement> void getUserGroupNames() throws IOException {

        String countStr = "";
        List<org.openqa.selenium.WebElement> userGroupNames = driver.findElements(By.xpath("//div[@class='graph-label']"));
        for (org.openqa.selenium.WebElement print : userGroupNames) {
            countStr = print.getText();

            System.out.println("Active User Group Labels :" + countStr);
        }

    }

    public <WebElement> void getUserGroupCount(int number) throws IOException {

        String countStr = "";
        List<org.openqa.selenium.WebElement> userGroupCount = driver.findElements(By.xpath("//div[@class='graph-bar']"));
        for (org.openqa.selenium.WebElement print : userGroupCount) {
            countStr = print.getText();
            int count = Integer.parseInt(countStr);
            if (count < number) {
                Verify.verify(count < number);
                System.out.println("User Group Events Labels which are less than given event numbers: " + count);
            } else {
                System.out.println("User Group Labels greater than given event numbers :" + countStr);
            }
        }
    }

}
