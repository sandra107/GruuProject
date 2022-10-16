package pages;

import Help.Wait.WaitHelper;
import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Day4 {
    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(Day3.class);
    WaitHelper waitHelper;
    @FindBy(css = "h2")
    WebElement title;

    @FindBy(linkText = "MOBILE")
    WebElement mobile;

    @FindBy(xpath = ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[2]/ul/li[2]/a")
    WebElement mainMobile1;
}
