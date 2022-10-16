package pages;

import Help.Wait.WaitHelper;
import Help.logger.LoggerHelper;
import Help.window.WindowHelper;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class ResetPassword {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(ResetPassword.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement btnCancel;
    @FindBy(xpath = "//button[normalize-space()='Reset Password']")
    WebElement btnReset;

    public ResetPassword(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void clickToCancel(){
        log.info("Clicking on button cancel....");
        logExtentReport("Report: clicking on button cancel...");
        btnCancel.click();
        WindowHelper windowHelper = new WindowHelper(driver);
        windowHelper.switchToParentWindow();
    }
    public void logExtentReport(String s1){
        TestBase.test.log(Status.INFO, s1);
    }
}
