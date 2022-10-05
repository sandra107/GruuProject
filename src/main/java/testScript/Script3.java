package testScript;

import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Day3;
import testBase.TestBase;

public class Script3 extends TestBase {
    private final Logger log = LoggerHelper.getLogger(Script3.class);

    Day3 day3;

    @DataProvider(name = "testData")
    public Object[][] testData(){
        Object[][] data = getExcelData("testData.xlxs", "loginData");
        return data;
    }

    @Test(dataProvider = "testData")
    public void loginToApplication(String uid, String password){
        for(int i = 0; i<data.length; i++){
            uid = data[i][0];

        }
    }

}
