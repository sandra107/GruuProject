package pages;

import Help.Wait.WaitHelper;
import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testBase.TestBase;

public class Day1 {
    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(Day1.class);
    WaitHelper waitHelper;

    @FindBy(css = "h2")
    WebElement title;

    @FindBy(linkText = "MOBILE")
    WebElement mobile;

    @FindBy(css = "select[title=\"Sort By\"]")
    WebElement sortBy;

    public void Day1(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(title, ObjectReader.reader.getExplicitWait());
        TestBase.logExtentReport("Day 1 is comming...");
    }

    public boolean checkTitle(){
        String acTitle = title.getText();
        System.out.println(acTitle);
        String msg = "THIS IS DEMO SITE FOR   ";
        if(acTitle.equals(msg)){
            return true;
        }
        return false;
    }

    public void clickToMobile(){
        log.info("Clicking to mobile");
        TestBase.logExtentReport("Clicking to mobile in testbase");
        mobile.click();
        new Select(sortBy).deselectByVisibleText("Name");
    }
}
