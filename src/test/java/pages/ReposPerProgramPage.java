package pages;

import utils.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class ReposPerProgramPage extends Base {

    public MainPage mp;

    public ReposPerProgramPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='graph list-lang']//a")
    @CacheLookup
    WebElement langList;

    public void selectRadioButton(String languageName) throws IOException {

        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//label[contains(.,'" + languageName + "')]/input"));
        actions.doubleClick(elementLocator).perform();


    }

    public <WebElement> void selectLangList() throws IOException {

        String listCount = "";



        List<org.openqa.selenium.WebElement> langListcount = driver.findElements(By.xpath("//div[@class='graph list-lang']//p"));

        for (org.openqa.selenium.WebElement print : langListcount) {
            listCount = print.getText();

            System.out.println("Lang List and Count :" + listCount);
        }


    }


}
