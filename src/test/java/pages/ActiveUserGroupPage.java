package pages;

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

            System.out.println("User Group Label :" + countStr);
        }

    }

    public <WebElement> void getUserGroupCount(int number) throws IOException {

        String countStr = "";
        List<org.openqa.selenium.WebElement> userGroupCount = driver.findElements(By.xpath("//div[@class='graph-bar']"));
        for (org.openqa.selenium.WebElement print : userGroupCount) {
            countStr = print.getText();
            int count = Integer.parseInt(countStr);
            if (count < number) {
                System.out.println("User Group Events counts are less than 5: " + count);
            } else {
                System.out.println("----User Group Label :" + countStr);
            }
        }
    }

}
