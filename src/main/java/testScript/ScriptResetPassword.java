package testScript;

import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.LoginOrangeHRM;
import pages.ResetPassword;
import testBase.TestBase;

public class ScriptResetPassword extends TestBase {
    private final Logger log = LoggerHelper.getLogger(ScriptResetPassword.class);

    @Test
    public void clickToCancel(){
//        getApplicationUrl(ObjectReader.reader.getUrl());
        ResetPassword resetPassword = new ResetPassword(driver);
        resetPassword.clickToCancel();
        System.out.println("Về rồi lè!!!");
    }
}
