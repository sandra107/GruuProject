package testScript;

import Help.assertion.AssertionHelper;
import Help.browserConfiguration.configReader.ObjectReader;
import Help.logger.LoggerHelper;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.Day1;
import testBase.TestBase;

import javax.management.Descriptor;
import javax.swing.*;

public class Script1 extends TestBase {
    private final Logger log = LoggerHelper.getLogger(Script1.class);

    @Test(description = "Check title", priority = 1)
    public void checkTitle(){
        getApplicationUrl(ObjectReader.reader.getUrl());
        Day1 day1 = new Day1();
        boolean title = day1.checkTitle();
        AssertionHelper.updateTestStatus(title);
    }

    @Test(description = "Click to mobile", priority = 2)
    public void clickToMobile(){
        getApplicationUrl(ObjectReader.reader.getUrl());
        Day1 day1 = new Day1();
        day1.clickToMobile();
    }

}
