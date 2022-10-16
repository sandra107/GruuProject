package testScript;

import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.LoginOrangeHRM;
import testBase.TestBase;

public class ScriptLoginToHRM extends TestBase {
    private final Logger log = LoggerHelper.getLogger(ScriptLoginToHRM.class);

    @Test(priority = 2)
    public void loginToApplication(){
        getApplicationUrl(ObjectReader.reader.getUrl());
        LoginOrangeHRM hrm = new LoginOrangeHRM(driver);
        hrm.loginToHRM("Admin", "admin123");
        System.out.println("Vào rồi!!!!");
    }
    @Test(priority = 1)
    public void clickToForgotPass(){
        getApplicationUrl(ObjectReader.reader.getUrl());
        LoginOrangeHRM hrm = new LoginOrangeHRM(driver);
        hrm.clickToForgetPassword();
        System.out.println("Vào reset lè!!!");
    }
}
