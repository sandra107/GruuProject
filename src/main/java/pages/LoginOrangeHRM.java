package pages;

import Help.Wait.WaitHelper;
import Help.logger.LoggerHelper;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class LoginOrangeHRM {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(LoginOrangeHRM.class);
    WaitHelper waitHelper;

    @FindBy(name = "username")
    WebElement userName;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    WebElement forgotPass;
    @FindBy(xpath = "//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]")
    WebElement highlightMes;
    @FindBy(xpath = "//div[@role='alert']")
    WebElement errorMessage;

    /**
     * Hàm tạo (Constructor)
     * Khởi tạo giá trị cho các thuộc tính hoặc thực hiện các hoạt động khởi tạo
     * PageFactory là phần mở rộng của POM, giúp khởi tạo các đôi tượng WE tối ưu và giảm thiếu code
     *
     */
    public LoginOrangeHRM(WebDriver driver){
        this.driver = driver;
        //Khởi tạo phần tử bằng initElements() -> Khởi tạo các phần tử web mà chúng định vị bằng sd @FindBy
        // This -> Khởi tạo cho chính đối tượng trong class này (Đối tượng WebElement
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
//        waitHelper.waitForElement(title, ObjectReader.reader.getExplicitWait());
//        TestBase.logExtentReport("Day 1 is comming...");
    }

    public void enterUserName(String userName){
        log.info("entering username..." + userName);
        logExtentReport("Report: entering username" + userName);
        this.userName.sendKeys(userName);
    }

    public void enterPassword(String password){
        log.info("entering password..." + password);
        logExtentReport("Report: entering password" + password);
        this.password.sendKeys(password);
    }

    public void clickToBtnLogin(){
        log.info("Clicking on button login....");
        logExtentReport("Report: clicking on button login...");
        btnLogin.click();
    }

    public void loginToHRM(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickToBtnLogin();
    }

    public ResetPassword clickToForgetPassword(){
        log.info("Clicking on forgot password....");
        logExtentReport("Report: clicking on forgot password...");
        forgotPass.click();
        return new ResetPassword(driver);
    }



    public void logExtentReport(String s1){
        TestBase.test.log(Status.INFO, s1);
    }
}
