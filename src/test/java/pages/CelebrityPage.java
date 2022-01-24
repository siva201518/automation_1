package pages;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CelebrityPage extends Base {

    public MainPage mp;

    public String birthdayxpath = "//*[@id='mw-content-text']//table/tbody//tr[contains(.,'Born')] //td[contains(@class, 'infobox-data')]";
    public String spouseXpath = "//*[@id='mw-content-text']//table/tbody//tr[contains(.,'Spouse(s)')] //td[contains(@class, 'infobox-data')]";

    public CelebrityPage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void getBirthDay(String celebrityName) throws IOException {
        String birthDay;


        try {
            birthDay = driver.findElement(By.xpath(birthdayxpath)).getText();
            int count = 0;

            String[] strSplit = birthDay.split("\\R");


            ArrayList<String> strList = new ArrayList<String>(
                    Arrays.asList(strSplit));

            for (String s : strList) {
                if (s.contains("age")
                ) {
                    System.out.println("Celebrity- " + celebrityName + " Birthdate as: " + s);
                    count++;

                }
            }
            if (count == 0) {
                System.out.println("Celebrity- " + celebrityName + " Birthdate is not available");
            }


        } catch (NoSuchElementException e) {
            System.out.println("Not able to click/get birthday");
        }
    }


    public void getSpouseName(String celebrityName)  {
        String spouseName;


        try {
            spouseName = driver.findElement(By.xpath(spouseXpath)).getText();


            System.out.println("Celebrity- " + celebrityName + " Spouse Name is/are : " + spouseName);

        } catch (NoSuchElementException e) {
            System.out.println("Celebrity- " + celebrityName + " has no spouse");

        }
    }


}
