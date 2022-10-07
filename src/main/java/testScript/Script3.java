package testScript;

import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Day2;
import pages.Day3;
import testBase.TestBase;

public class Script3 extends TestBase {
    private final Logger log = LoggerHelper.getLogger(Script3.class);

    @DataProvider(name = "testData")
    public Object[][] testData() throws Exception {
        Object[][] data = getExcelData("testData.xlsx", "loginData");
        return data;
    }

    @Test(dataProvider = "testData")
    public void loginToApplication(String uid, String password){
        getApplicationUrl(ObjectReader.reader.getUrl());
        Day3 day2 = new Day3(driver);
        day2.loginToApplication(uid,password);
        System.out.println("Ok rồi má ơi");
    }

}
