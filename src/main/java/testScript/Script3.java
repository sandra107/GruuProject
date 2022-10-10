package testScript;

import Help.assertion.AssertionHelper;
import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import Help.resource.ResourceHelper;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Day2;
import pages.Day3;
import testBase.TestBase;

import javax.management.ObjectName;

public class Script3 extends TestBase {
    private final Logger log = LoggerHelper.getLogger(Script3.class);

    @DataProvider(name = "testData")
    public Object[][] testData() {
        Object[][] data = getExcelData("testData.xlsx", "loginData");
        return data;
    }

    @Test(dataProvider = "testData")
    public void loginToApplication(String uid, String password){
        getApplicationUrl(ObjectReader.reader.getUrl());
        Day3 day3 = new Day3(driver);
        day3.loginToApplication(uid,password);
        boolean alert = day3.checkAlert();
        AssertionHelper.updateTestStatus(alert);
    }
}
