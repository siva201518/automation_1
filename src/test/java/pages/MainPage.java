package pages;


import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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


    public String search = "searchInput";
    public String searchButton = "searchButton";



    public CelebrityPage enterSearch(String text) throws IOException {
        try {
            driver.findElement(By.id(search)).sendKeys(text);
            driver.findElement(By.id(searchButton)).click();
            System.out.println("Searching with celebrity name in search box: " + text);


        } catch (NoSuchElementException e) {
            System.out.println("Not able to select/enter values in to the search box");
        }
        return new CelebrityPage();

    }

    public LanguagePage clickLanguage(String text) throws IOException {
        try {
            driver.findElement((By.xpath("//*[contains(@title,'" + text + "')]"))).click();

            System.out.println("clicked the new language : " + text);


        } catch (NoSuchElementException e) {

            Assert.fail("Not able to click the given language link");

        }

        return new LanguagePage();
    }






}
