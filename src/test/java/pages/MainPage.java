package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.io.IOException;
import java.util.List;

public class MainPage extends Base {


    public MainPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//p[contains(text(), 'repos per week')]")
    @CacheLookup
    WebElement repoPerWeek;

    @FindBy(id = "search")
    @CacheLookup
    WebElement search;

    @FindBy(xpath = "//p[contains(text(), '${moduleName}')]")
    @CacheLookup
    WebElement moduleNames;


    public void clickRepoLink() {
        repoPerWeek.click();
    }

    public void enterSearch(String text) {
        driver.findElement(By.id("search")).sendKeys(text);



    }

    public <WebElement> void getModuleNames(String moduleName) {

        List<org.openqa.selenium.WebElement> module = driver.findElements(By.xpath("//p[contains(text(), '" + moduleName + "')]"));
        for (org.openqa.selenium.WebElement compare : module) {


            if (compare.getText().contains(moduleName)) {
                System.out.println("Module Names: " + compare.getText());
            } else {
                System.out.println("results are not contains searched names");
            }
        }


    }

    public ActiveUserGroupPage clickRepoLink(String moduleName) throws IOException {
        driver.findElement(By.xpath("//p[contains(text(), '" + moduleName + "')]")).click();

        return new ActiveUserGroupPage();

    }


}