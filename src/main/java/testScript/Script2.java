package testScript;

import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.Day2;
import testBase.TestBase;

public class Script2 extends TestBase {
    private final Logger log = LoggerHelper.getLogger(Script2.class);

    @Test
    public void testLoginToApplication(){
        getApplicationUrl(ObjectReader.reader.getUrl());
        Day2 day2 = new Day2(driver);
        day2.loginToApplication("mngr444993","UbysAmy");
        System.out.println("Ok rồi má ơi");
    }
}
