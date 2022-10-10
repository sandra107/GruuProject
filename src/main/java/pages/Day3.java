package pages;

import Help.Wait.WaitHelper;
import Help.alert.AlertHelper;
import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;
import utils.Util;

public class Day3 {
    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(Day3.class);
    WaitHelper waitHelper;

    @FindBy(name = "uid")
    WebElement uId;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement btnLogin;

    public Day3(WebDriver driver){
        this.driver = driver;
        //Khởi tạo phần tử bằng initElements() -> Khởi tạo các phần tử web mà chúng định vị bằng sd @FindBy
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(uId, ObjectReader.reader.getExplicitWait());
        log.info("Hế lô lại là mình đây, Day 3");
        TestBase.logExtentReport("Day 3 is comming...");
    }

    public void enterUid(String uid){
        log.info("entering uid..." + uid);
        logExtentReport("entering uid" + uid);
        this.uId.sendKeys(uid);
    }
    public void enterpassword(String password){
        log.info("Entering password...." + password);
        logExtentReport("entering password....." + password);
        this.password.sendKeys(password);
    }

    public void clickToBtnLogin(){
        log.info("Clicking on button login....");
        logExtentReport("Clicking on button login...");
        btnLogin.click();
    }

    public boolean checkAlert(){
        AlertHelper alertHelper = new AlertHelper(driver);
        alertHelper.getAlert();
        String alt = alertHelper.getAlertText();
        alertHelper.acceptAlert();
        if(alt.equals(Util.EXPECT_ERROR_LOGIN)){
            System.out.println("ahihi, tao nè!!!");
        }else {
            System.out.println("lại là tao đây, nhưng mày sai rồi");
        }
        return true;
    }

    public void loginToApplication(String uid, String password){
        enterUid(uid);
        enterpassword(password);
        clickToBtnLogin();
    }

    public void logExtentReport(String s1){
        TestBase.test.log(Status.INFO, s1);
    }
}
