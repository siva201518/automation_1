package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LanguagePage extends Base {

    public MainPage mp;

    public LanguagePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


}
